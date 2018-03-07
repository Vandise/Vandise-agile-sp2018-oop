import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Board board;
	
	@Before
	public void setUp() throws Exception {
		this.board = new Board(10);
	}

	@Test
	public void testBoardIsInitializedWithSize() {
		assertThat(this.board.getSize(), is(10));
	}

	@Test
	public void testBoardCanCallACoordinate() throws Exception {
		assertThat(this.board.callCoordinate(5, 5), is("Miss"));
	}

	@Test(expected = Exception.class)
	public void testBoardCannotCallTheSameCoordinateTwice() throws Exception {
		assertThat(this.board.callCoordinate(5, 5), is("Miss"));
		this.board.callCoordinate(5, 5);
	}

	@Test
	public void testBoardCanAddShipsToCoordinates() throws Exception {
		this.board.addShip(7, 7, ShipType.BATTLESHIP);
		assertThat(this.board.getShipCount(), is(1));
	}

	@Test
	public void testBoardCanHitShips() throws Exception {
		this.board.addShip(7, 7, ShipType.BATTLESHIP);
		assertThat(this.board.callCoordinate(7, 7), is("Hit"));
		// Not sure why this test case is not working, addShip() is adding a ship to the specific coordinate (7,7) 
		// in the coordinate vector. callCoordinate is taking the same coordinate (7,7) and running the call() method.
		// The call() method is checking this coordinate to see if the boolean hasShip was set to true, which I 
		// believe it was in the addShip() method.
	}

	@Test
	public void testBoardCanSinkShips() throws Exception {
		Ship ship = ShipFactory.create(ShipType.BATTLESHIP);
		int life = ship.getLife();
		this.board.addShip(7, 7, ShipType.BATTLESHIP);
		for (int i = 0; i < (life - 1); i++) {
			assertThat(this.board.callCoordinate(7, 7 - i), is("Hit"));
		}
		assertThat(this.board.callCoordinate(7, (7 - life + 1)), is("Sunk"));
		// This test case will not work if I cannot get the previous test case to work. s
	}
}
