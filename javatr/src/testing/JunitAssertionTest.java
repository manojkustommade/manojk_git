package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitAssertionTest {

  @Test
  public void Test() {	
	
	 String obj1="manoj";
	 String obj2="manoj";
   	 String obj3="kasturi";
	 String obj4="kasturi";
	 String obj5=null;
	 int var1=10;
	 int var2=20;

	 int[] arithmetic1= {1,2,3,4};
	 int[] arithmetic2= {1,2,3,4};
	 
	 assertEquals(obj1, obj2);
	 assertSame(obj3, obj4);
	 assertNotSame(obj2, obj4);
	 assertNull(obj5);
	 assertTrue(var1<var2);
	 assertArrayEquals(arithmetic1, arithmetic2);
	
 }

}
