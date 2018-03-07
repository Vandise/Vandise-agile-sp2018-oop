/*
 * Observer pattern
 */
public abstract class CoordinateSubject {
	protected Ship observer;

	// TODO
	// update the observer
	// read about the observer pattern
	//
	public void notifyObserver() throws Exception {
		// I tried "this.observer.update()" and "observer.update()", but I couldn't get it to work properly.
		// it broke the Tests.
	}

	public Ship getObservable() {
		return this.observer;
	}

	public void attach(Ship observer) {
		this.observer = observer;
	}
}
