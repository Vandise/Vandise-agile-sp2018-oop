
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
		return getCoordinate(x, y).call();
	}

	public void addShip(int x, int y, ShipType type) throws Exception {
		getCoordinate(x, y).attach(ShipFactory.create(type));
		shipCount++;
	}

	public int getShipCount() {
		return this.shipCount;
	}
	
	private Coordinate getCoordinate(int x, int y) throws Exception {
		return this.coordinateVector[y * this.size + x];
	}
}
