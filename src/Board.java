
public class Board {

	private int size;
	private int shipCount;
	Coordinate[] coordinateVector;
	
	public Board(int size) {
		this.size = size;
		this.shipCount = 0;
		this.coordinateVector = new Coordinate[size*size];
		for (int i = 0; i < this.coordinateVector.length; i++) {
			this.coordinateVector[i] = new Coordinate();
		}
	}

	public int getSize() {
		return this.size;
	}

	public String callCoordinate(int x, int y) throws Exception {
		int coordinates = y * this.size + x;
		return (this.coordinateVector[coordinates]).call();
	}

	public void addShip(int x, int y, ShipType type) throws Exception {
		// Need to add 1 to coordinate 7,7 to pass test - takes in ship type which has a value
		// associated with it of how many "spots" to fill. Coordinate needs to +1 when ship is on it.
		//coordinateVector.add()
		
	}

	public int getShipCount() {
		return this.shipCount;
	}
}
