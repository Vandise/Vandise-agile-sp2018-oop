import java.util.ArrayList;

/*
 * Observer pattern
 */
public abstract class CoordinateSubject {
	protected Ship observer;

	// TODO
	// update the observer
	// read about the observer pattern
	//
	ArrayList<ShipElement> element = new ArrayList<ShipElement>();
	public void notifyObserver() throws Exception {
		for (ShipElement element : this.element) {
			element.update();
		}
	}


	public Ship getObservable() {
		return this.observer;
	}

	public void attach(Ship observer) {
		this.observer = observer;
	}
}
