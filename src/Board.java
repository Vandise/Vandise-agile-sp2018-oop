
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
		shipCount++;
		// TODO: implement add ship functionality. See vectors
		Ship ship = ShipFactory.create(type);
		for ( int i = 0; i < ship.getLife(); i++){
			int coord = ((y-i) * this.getSize() + x);
			this.coordinateVector[coord].attach(ship);
		}
	}

	public int getShipCount() {
		return this.shipCount;
	}
}
