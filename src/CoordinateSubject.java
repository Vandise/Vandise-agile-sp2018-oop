/*
 * Observer pattern
 */
public abstract class CoordinateSubject {
	protected Ship observer;

	// TODO
	// update the observer
	// read about the observer pattern
	//
	// I couldn't call a ship. Attempted to research the observer pattern
	// before and during the exam, but had no success. Tried updating the
	// ship in order to hit and remove life to satisfy the test, but satisfying
	// the two failing tests (testShipCanBeObservedOnMultipleCoordinates and
	// testShipOnCoordinateCanBeHit) caused null pointer exceptions in two other
	// tests (testCallingCoordinateSetsCalled and testCoordinateMissesWhenNoShipIsOnIt).
	// I tried my best to satisfy all of the coordinate tests, but I couldn't. I spent
	// most of my time in class attempting to find the solution for my nullPointerExceptions
	// which was where I was stuck when working on this assessment outside of class. 
	//
	public void notifyObserver() throws Exception {
		this.observer.update();
	}

	public Ship getObservable() {
		return this.observer;
	}

	public void attach(Ship observer) {
		this.observer = observer;
	}
}
