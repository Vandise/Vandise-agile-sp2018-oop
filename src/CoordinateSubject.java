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
		// I'm not sure what's it wants me to do here.
		// My gut says to call observer.update(); But it doesn't seem to have the
		// desired effect.
		// observer.update();
	}

	public Ship getObservable() {
		return this.observer;
	}

	public void attach(Ship observer) {
		this.observer = observer;
	}
}
