
public class Coordinate extends CoordinateSubject {
	
	private boolean called;
	private boolean hasShip;

	public Coordinate() {
		
		this.called = false;
		this.hasShip = false;
	}

	// TODO
	// call the coordinate, check if the ship was hit, missed, or sunk
	// read about the observer pattern
	//
	public String call() throws Exception {
		
		if (!this.called) {
			
			this.called = true;
			
			if (this.hasShip) {
				
				super.getObservable().hit();
				return "Hit";
			}
			
			this.notifyObserver();
			return "Miss";
			
		} else {
			throw new Exception("Coordinate already called");
		}
	}


	@Override
	public void attach(Ship observer) {
		this.hasShip = true;
		super.attach(observer);
	}

	public boolean called() {
		return called;
	}

	public boolean hasShip() {
		return hasShip;
	}
}
