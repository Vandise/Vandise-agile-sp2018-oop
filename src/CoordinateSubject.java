
public abstract class CoordinateSubject {

	protected Ship observer;

	public void notifyObserver() throws Exception {
		observer.update();
	}

	public Ship getObservable() {
		return this.observer;
	}

	public void attach(Ship observer) {
		this.observer = observer;
	}
}
