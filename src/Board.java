
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
		// TODO: implement add ship functionality. See vectors
		shipCount += 1;
		Ship ship = ShipFactory.create(type);
		int coordinates = y * this.size + x;
		Coordinate Coord = new Coordinate();
		Coord.attach(ship);
		coordinateVector[coordinates] = Coord;
		for (int i = 0; i < ship.getLife();i++) {
			int extCoord = (y - i) * this.size + x;
			Coordinate nxtCoord = new Coordinate();
			nxtCoord.attach(ship);
			coordinateVector[extCoord] = nxtCoord;
		}
	}

	public int getShipCount() {
		return this.shipCount;
	}
}
