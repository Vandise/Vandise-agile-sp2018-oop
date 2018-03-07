
public class ShipFactory {
	// TODO:
	// Create a ship based on the ShipType
	// read about the factory pattern
	//
	public static Ship create(ShipType type) throws Exception {
		Ship ship = null;
		switch(type) {
		case BATTLESHIP:
			ship = new Ship(4);
			break;
		
		//Creates a Patrol Ship
		case PATROL: 
			ship = new Ship(2);
			break;
		
		//Creates a Sub Ship
		case SUBMARINE:
			ship = new Ship(3);
			break;
			
		//Creates a Carrier Ship
		case CARRIER:
			ship = new Ship(5);
			break;
			
		//Creates a Destroyer Ship
		case DESTROYER:
			ship = new Ship(3);
			break;
			
		default:
			throw new Exception("Undefined ShipType: " + type);
		}
		return ship;
	}
}
