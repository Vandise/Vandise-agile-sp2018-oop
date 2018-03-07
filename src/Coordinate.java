
public class Coordinate extends CoordinateSubject {
	private boolean called;
	private boolean hasShip;

	public Coordinate() {
		this.called = false;
		this.hasShip = false;
	}

	public String call() throws Exception {
		if (this.called) {
			throw new Exception("Coordinate already called");
		}
		this.called = true;
		if (this.hasShip) {
			this.notifyObserver();
			return "Hit";
		}  else {
			return "Miss";
		}
	}

	@Override
	public void attach(Ship observer) {
		super.attach(observer);
		this.hasShip = true;
	}

	public boolean called() {
		return this.called;
	}

	public boolean hasShip() {
		return this.hasShip;
	}
}
