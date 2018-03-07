public class Ship implements Observable {
	private int life;
	private boolean sunk;

	public Ship(int life) {
		this.life = life;
		this.sunk = false;
	}

	// TODO
	// See unit tests for what needs to be done here
	// in the observer pattern
	
	public void update() throws Exception {
		this.hit();
		//The unit tests mentions "callHitonUpdate" seems to be causing errors
	}

	public boolean isSunk() {
		return this.sunk;
	}

	public int getLife() {
		return this.life;
	}

	// TODO
	//	a piece of logic is missing here
	//
	public void hit() throws Exception {
		if (!this.sunk) {
			this.life -= 1;
			if (this.getLife() < 1) {
				this.sunk = true;
			}
		} else {
			throw new Exception("Hit on ship that's already sunk.");
		}
	}
}
