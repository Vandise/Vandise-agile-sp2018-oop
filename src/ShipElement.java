
public class ShipElement {
	
	private String shipType;
	
	public ShipElement (String shipType) {
		this.shipType = shipType;
	}
	

	public void update() {
		System.out.println("I've pudated: " + this.shipType);
		
	}
	
}
