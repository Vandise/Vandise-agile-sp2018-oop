
public class ShipFactory {
	// TODO:
	// Create a ship based on the ShipType
	// read about the factory pattern
	//
	public static Ship create(ShipType type) throws Exception {
		Ship ship = null;
		switch(type) {
		case PATROL:
			ship = new Ship(2);
			break;
		
		case BATTLESHIP:
			ship = new Ship(4);
			break;
		default:
			throw new Exception("Undefined ShipType: " + type);
		}
		return ship;
	}
}
