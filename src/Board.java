import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
		x = 7;
<<<<<<< HEAD
	    y = 7;
	    
	    type = ShipType.BATTLESHIP;
	    
	    /*I couldnt figure out the coordinates and tried to create variables. I tried to use an if else
	     * statement where if the coordinate x and y are 7 then add ship.*/
		
		
=======
		y = 7;
		type = ShipType.BATTLESHIP;
		return;
>>>>>>> ship-branch
	}

	public int getShipCount() {
		return this.shipCount;
	}
	
	public void canHitShips() throws Exception {
		
	}
	
	public void canSinkShips() throws Exception {
		int life = 0;
		
		if (life > 0) {
			System.out.println("Hit");
		} else {
			System.out.println("Sunk");
		}
	}
}
