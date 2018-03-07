
public class ShipFactory {
	
	public static Ship create(ShipType type) throws Exception {
		Ship ship = null;
		switch(type) {
		case BATTLESHIP:
			ship = new Ship(4);
			break;
		case PATROL:
			ship = new Ship(2);
			break;
		default:
			throw new Exception("Undefined ShipType: " + type);
		}
		return ship;
	}
}
