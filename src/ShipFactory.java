
public class ShipFactory {

	public static Ship create(ShipType type) throws Exception {
		
		Ship ship = null;
		
		switch(type) {
		
		case CARRIER:
			ship = new Ship(5);
			break;
			
		case BATTLESHIP:
			ship = new Ship(4);
			break;
			
		case DESTROYER:
			ship = new Ship(3);
			break;
			
		case SUBMARINE:
			ship = new Ship(3);
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
