
public class Coordinate extends CoordinateSubject {
	private boolean called;
	private boolean hasShip;

	public Coordinate() {
		this.called = false;
		this.hasShip = false;
	}

	public String call() throws Exception {
		
		if (!this.called) {
			
			this.notifyObserver();
			this.called = true;
			
			if (this.hasShip) {
				this.observer.hit();
			}
			
			return "Miss";
			
		} else {
			
			throw new Exception("Coordinate already called");
			
		}
	}

	@Override
	public void attach(Ship observer) {
		
		this.hasShip = true;
		this.observer = observer;
		
	}

	public boolean called() {
		if (this.called) {
			
			return true;
			
		} else {
			
			return false;
			
		}
	}

	public boolean hasShip() {
		
		if (this.hasShip) {
			
			return true;
			
		} else {
			
			return false;
			
		}
	}
}
