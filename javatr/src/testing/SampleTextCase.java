package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class SampleTextCase {
	Arithmetic am=new Arithmetic();
	
	@Test
	public void testAddPositive() {
		assertEquals(8, am.add(3, 5));
	}
	@Test
	public void testAddNegative() {
		assertNotEquals(20,am.add(10, 20));
	}

}
