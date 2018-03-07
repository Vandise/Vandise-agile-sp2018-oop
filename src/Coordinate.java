
public class Coordinate extends CoordinateSubject {
	
	private boolean	called;
	private boolean	hasShip;
	
	
	public Coordinate() {
		this.called = false;
		this.hasShip = false;
	}
	
	
	public String call() throws Exception {
		if (!this.called) {
			this.called = true;
			if (getObservable() != null) {
				this.notifyObserver();
				if (this.getObservable().isSunk()) {
					return "Sunk";
				} else {
					return "Hit";
				}
			} else {
				return "Miss";
			}
			
		} else {
			throw new Exception("Coordinate already called");
		}
	}
	
	
	@Override
	public void attach(Ship observer) {
		super.attach(observer);
		hasShip = true;
	}
	
	
	public boolean called() {
		return called;
	}
	
	
	public boolean hasShip() {
		return hasShip;
	}
}
