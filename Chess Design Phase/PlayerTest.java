package Package;
import junit.framework.*;


public class PlayerTest extends TestCase {
	//@Test
	public void testSetName() {
		Player whitePlayer = new Player("Mark");
		whitePlayer.setName("Sarah");
		assertTrue(whitePlayer.getName() == "Sarah");
	}
	
	public void testRemovePiece
}
