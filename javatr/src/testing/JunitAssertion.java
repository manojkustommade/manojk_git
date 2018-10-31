package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitAssertion {

	String obj1="medplus";
	String obj2="medplus";
	
	String obj3=null;
	
	int var1=10;
	int var2=20;
	
	int[] arithmetic1= {10,20,30};
	int[] arithmetic2= {10,20,30};
	
	@Test
	public void testEquals() {
		assertEquals("They are not equal", obj1, obj2);
	}
	@Test
	public void testNull() {
		assertNull(obj3);
	}
	@Test
	public void testTrue() {
		assertTrue(var1<var2);
	}
	@Test
	public void testArrayEqual() {
		assertArrayEquals(arithmetic1, arithmetic2);
	}

}
