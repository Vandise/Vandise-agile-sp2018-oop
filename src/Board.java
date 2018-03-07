
public class Board {
	//this is the test
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
		if(ShipType.BATTLESHIP == type) {
			this.size = 4;
			this.shipCount ++;
			coordinateVector.add(x,y);
		}
		else if(ShipType.CARRIER == type) {
			this.size = 5;
			this.shipCount ++;
		}
		else if(ShipType.DESTROYER == type) {
			this.size = 3;
			this.shipCount ++;
		}
		else if(ShipType.SUBMARINE == type) {
			this.size = 3;
			this.shipCount ++;
		}
		else if(ShipType.PATROL == type) {
			this.size = 2;
			this.shipCount ++;
		}
		
		//I have tried to added the coordinates into the vector so they can then be check to see if there is a shipt there
		//if there was a ship there I would then have it show that the ship was hit. With the incorporated size above
		// I would be able to then check to see if all the spots on the ship was hit or not. If it was i would then call
		// call the sunk method to show that it was sunk. 
		
	}

	public int getShipCount() {
		return this.shipCount;
	}
}
