
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
		// if there is not a ship at these coordinates, nothing will be hit
		if (!this.called) {
			
			// Uncommenting this line does cause the ship to be hit during the
			// two currently failing tests. Two of the currently passing tests
			// change to nullPointerExceptions, meaning that the ship was not selected.
			// When I attempt to update and remove life from an unselected ship, it 
			// attempts to remove life from null and a nullPointerException is thrown.
			// I don't understand why the ship isn't selected since it is attached during
			// the CoordinateTest tests.
			//this.notifyObserver();
			return "Miss";
		// if there is a ship at these coordinates, the ship part will be hit
		} else if (this.hasShip()) {
			return "Hit";
		// if these coordinates contain a part of a ship that has already
		// been sunk, nothing will be hit
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
		super.attach(observer);
	}

	// TODO
	// return if the coordinate has been called or not
	//
	public boolean called() {
		// Temporarily setting to true for the sake of attempting to call
		// and hit coordinates. There would normally be an
		// if statement checking if the coordinate has been called
		// or not
		//
		//if () {
			return true;
		//} else {
			//return false;
		//}
	}

	// TODO
	// is there a ship on this coordinate?
	//
	public boolean hasShip() {
		// Temporarily setting to false for the sake of attempting to call
		// and hit coordinates. There would normally be an
		// if statement checking if there is ship on this coordinate
		// or not
		//
		//if () {
			//return true;
		//} else {
		return false;
		//}
	}
}
