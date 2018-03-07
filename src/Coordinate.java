
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
		// I've tried using the observer pattern that we used 
		// in class, but I didnt understand the implementation
		// here with what we did in class.  There was no
		// observable behavior in what was shown in class
		// just copying code without explanation.  
		if (!this.called) {
			this.notifyObserver();
			return "Miss";
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
	}

	// TODO
	// return if the coordinate has been called or not
	//
	public boolean called() {
		if (this.called) {
			return true;
		} else {
			return false;
		}
	}

	// TODO
	// is there a ship on this coordinate?
	//
	public boolean hasShip() {
		if (this.hasShip) {
			return true;
		} else {
			return false;
		}
	}
}
