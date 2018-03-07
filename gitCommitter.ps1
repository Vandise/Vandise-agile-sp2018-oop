$location = $(Get-Location).path
$gitWithUpdates = 'C:\users\dpope\OneDrive - IDEXX\dpope\Desktop\oldAgile'
$gitBeingUpdated = 'C:\users\dpope\OneDrive - IDEXX\dpope\Desktop\newAgile'
$startBranch = 'master'
$currentBranch = $false
$skipMergeBranches = $true
$branchMessage = 'feature-'
"`nEXECUTING GITCOMMITTER...`n"
"PATH WITH UPDATES  = $gitWithUpdates"
"PATH BEING UPDATED = $gitBeingUpdated"
"BASE BRANCH              = '$startBranch'"
"FEATURE BRANCH SIGNIFIER = '$branchMessage'"
"SKIP MERGE BRANCHES      = $skipMergeBranches`n"
Set-Location $gitWithUpdates
"CD: PATH WITH UPDATES"
"CHECKOUT: $startBranch`n"
git checkout $startBranch
$commitList = git log --oneline
[array]::Reverse($commitList)
#Known previous commits of 1.
#Otherwise would input start hash, default BeingUpdated
$commitList = $commitList[1..($commitList.Length-1)]
"`nCOMMIT LIST:"
$commitList
Set-Location $gitBeingUpdated
"`nCD: PATH BEING UPDATED"
$commitList | ForEach-Object {
  $hash, $message =  $_ -split ' ',2
  if ($message.StartsWith($branchMessage)) {
    "CHECKOUT: $startBranch"
    git checkout $startBranch
    if ($currentBranch) {
      "`nMERGING BRANCH '$currentBranch'..."
      git merge $currentBranch
      "COMPLETE`n"
      "DELETING BRANCH '$currentBranch'..."
      git branch -D $currentBranch
      "COMPLETE"
    }
    $currentBranch = $message.Split(' ')[0]
    "`nCHECKOUT: $currentBranch"
    git checkout -b $currentBranch
  } elseif ($currentBranch) {
    "CONTINUING BRANCH: $currentBranch"
  } else {
    'NO FEATURE BRANCH'
    "CURRENT BRANCH: $startBranch"
  }
  if (!$message.StartsWith('Merge branch') -and $skipMergeBranches) {
    Set-Location $gitWithUpdates
    "`nCD: PATH WITH UPDATES"
    "CHECKOUT: $hash`n"
    git checkout $hash
    "`nATTEMPTING RM..."
    Get-ChildItem -Path $gitBeingUpdated -Recurse |
      Select-Object -ExpandProperty FullName |
        Where-Object {$_ -notlike '*\.git*'} | # .gitignore updates will also be.. ignored.
          Sort-Object length -Descending |
            Remove-Item -force -recurse #remove-Item -recurse sometimes deletes folders before items because it finds them first...............
    'COMPLETE'
    "`nATTEMPTING COPY..."
    Copy-Item -Recurse -Force -Exclude ".git" "$gitWithUpdates\*" $gitBeingUpdated
    'COMPLETE'
    Set-Location $gitBeingUpdated
    "`nCD: PATH BEING UPDATED`n"
    "ADDING FILES..."
    git add .
    "COMPLETE`n"
    "COMMITTING... $message"
    git commit -m $message
    "COMPLETE`n"
  }
}
"CHECKOUT: $startBranch"
git checkout $startBranch
"`nMERGING BRANCH '$currentBranch'..."
git merge $currentBranch
"COMPLETE`n"
"DELETING BRANCH '$currentBranch'..."
git branch -D $currentBranch
"COMPLETE`n"
"CD: ORIGINAL PATH`n"
Set-Location $location
"GITCOMMITTER COMPLETE`n"