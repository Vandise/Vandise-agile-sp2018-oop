
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
			this.notifyObserver();
			return "Miss";
			// I tried to do a try catch, and an if else statement, but I could not get either of them to work.
		} else {
			throw new Exception("Coordinate already called");
		}
	}

	// TODO
	//	read about inheritance and calling parent
	//	methods in Java
	//
	@Override
	public void attach(Ship observer) {
		// TODO
		
		// Wasn't able to figure out how to attach the Ship to the coordinates.
	}

	public boolean called() {
		if (!this.called) {
			return true;
		} else {
			return false;
		}
	}

	// TODO
	// is there a ship on this coordinate?
	//
	public boolean hasShip() {
		// Wasn't able to figure out how to attach the Ship.
		return false;
	}
}
