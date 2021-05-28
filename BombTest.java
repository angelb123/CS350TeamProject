import org.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
public class BombTest {
	
	// Tests written by Angel Bermudez
	
	@Test
	public void testWind() {
		Bomb bomb = new Bomb(0, 0, 0, 0, null, 0, 45, 10);
		assertEquals(bomb.getWindDirection(),45,"getWindDirection()");
		
		assertEquals(bomb.getWindSpeed(),10.0,"getWindSpeed()");
	}
	
	@Test
	public void testRelease() {
		Bomb bomb = new Bomb(100, 200, 300, 10, null, 0, 0, 0);
		
		Bomb.Coordinates coord = bomb.getReleaseCoordinates();
		
		assertEquals(coord.getX(), 100, "getX()");
		assertEquals(coord.getY(), 200, "getY()");
		assertEquals(bomb.getReleaseAltitude(), 300.0, "getReleaseAltitude()");
		assertEquals(bomb.getDescentSpeed(), 10, "getDescentSpeed()");
		
	}
	@Test
	public void testError() {
		Bomb.E_ErrorType e1 = Bomb.E_ErrorType.NONE;
		Bomb bomb1 = new Bomb(0, 0, 0, 0,e1, 10, 0, 0);
		assertEquals(bomb1.getErrorType(), e1, "getErrorType()");
		
		
		Bomb.E_ErrorType e2 = Bomb.E_ErrorType.UNIFORM;
		Bomb bomb2 = new Bomb(0, 0, 0, 0,e2, 10, 0, 0);
		assertEquals(bomb2.getErrorType(), e2, "getErrorType()");
		assertEquals(bomb2.getErrorRange(), 10, "getErrorRange()");
		
		Bomb.E_ErrorType e3 = Bomb.E_ErrorType.GAUSSIAN;
		Bomb bomb3 = new Bomb(0, 0, 0, 0,e3, 10, 0, 0);
		assertEquals(bomb3.getErrorType(), e3, "getErrorType()");
		assertEquals(bomb3.getErrorRange(), 10, "getErrorRange()");
		
		
	}
}
