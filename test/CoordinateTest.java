import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

	private Ship ship;
	private Coordinate coordinate;
	
	@Before
	public void setUp() throws Exception {
		this.ship = ShipFactory.create(ShipType.BATTLESHIP);
		this.coordinate = new Coordinate();
	}

	@Test
	public void testHasShipIsEmptyWithoutShipSet() {
		assertThat(this.coordinate.hasShip(), is(false));
	}
	
	@Test
	public void testCallingCoordinateSetsCalled() throws Exception {
		this.coordinate.call();
		assertThat(this.coordinate.called(), is(true));
	}
	
	@Test
	public void testCoordinateMissesWhenNoShipIsOnIt() throws Exception {
		assertThat(this.coordinate.call(), is("Miss"));
	}

	@Test
	public void testShipOnCoordinateCanBeHit() throws Exception {
		this.coordinate.attach(this.ship);
		this.coordinate.call();
		assertThat(this.ship.getLife(), is(3));
		
		// I added onto the if statement in Coordinate.java to test if there was a ship there or not
		// and if there was to take the observer object and call update on it to register a hit. I also tried 
		// just calling the hit on the observer and that did not seem to work either.
	}

	@Test
	public void testShipCanBeObservedOnMultipleCoordinates() throws Exception {
		Coordinate c = new Coordinate();
		c.attach(this.ship);
		this.coordinate.attach(this.ship);

		this.coordinate.call();
		assertThat(this.ship.getLife(), is(3));

		c.call();
		assertThat(this.coordinate.getObservable().getLife(), is(2));
		assertThat(this.coordinate.getObservable().getLife(), is(
				c.getObservable().getLife()));
		
		// I couldn't get it to register a hit on one coordinate so I feel like this one was kind of impossible for me.
		// I spent a lot of time on the one above and feel like if someone explained these two to me I would understand it completely.
	}
}
