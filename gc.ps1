$($location = $(Get-Location).path
$gitWithUpdates = 'C:\users\dpope\OneDrive - IDEXX\dpope\Desktop\oldAgile'
$gitBeingUpdated = 'C:\users\dpope\OneDrive - IDEXX\dpope\Desktop\newAgile'
$currentBranch
Set-Location $gitWithUpdates
git checkout 'master'
$commitList = git log --oneline
[array]::Reverse($commitList)
$commitList = $commitList[1..($commitList.Length-1)]
Set-Location $gitBeingUpdated
$commitList | ForEach-Object {
  $hash, $message =  $_ -split ' ',2
  if ($message.StartsWith('feature-')) {
    git checkout 'master'
    git merge $currentBranch
    if ($currentBranch -ne $null) {git branch -D $currentBranch}
    $currentBranch = $message.Split(' ')[0]
    git checkout -b $currentBranch}
  Set-Location $gitWithUpdates
  git checkout $hash
  Get-ChildItem -Path $gitBeingUpdated -Recurse |
    Select-Object -ExpandProperty FullName |
      Where-Object {$_ -notlike '*\.git*'} |
        Sort-Object length -Descending |
          Remove-Item -force -recurse
  Copy-Item -Recurse -Force -Exclude ".git" "$gitWithUpdates\*" $gitBeingUpdated
  Set-Location $gitBeingUpdated
  git add .
  git commit -m $message}
git checkout 'master'
git merge $currentBranch
git branch -D $currentBranch
Set-Location $location) *>&1 > $null