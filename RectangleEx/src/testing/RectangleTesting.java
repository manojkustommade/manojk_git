package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import JavaExample.Rectangle;

class RectangleTesting {

	Rectangle rect1 = new Rectangle(0, 0, 3, 3);
	Rectangle rect2 = new Rectangle(2, 0, 4, 4);
	Rectangle rect3 = new Rectangle(0, 6, 4, 10);
	Rectangle rect4 = new Rectangle(1, 1, 2, 2);

	@Test
	void testIsOverlapping() {
		assertEquals(true, rect1.isOverlapping(rect2));
		assertEquals(true, rect2.isOverlapping(rect1));
		assertEquals(false, rect2.isOverlapping(rect3));
		assertEquals(true, rect1.isOverlapping(rect4));
		assertEquals(true, rect4.isOverlapping(rect1));

	}

	@Test
	void testGetOverlappingRectangle() {
		Rectangle r = new Rectangle(2, 0, 3, 3);
		Rectangle r1 = new Rectangle(1,1,2,2);
		Rectangle r2 = new Rectangle(5, 4, 7, 6);
		assertTrue(r.isEqual(rect1.getOverlappingRectangle(rect2)));
		assertTrue(r1.isEqual(rect1.getOverlappingRectangle(rect4)));
		assertTrue(r2.isEqual((new Rectangle(0, 4, 7, 12)).getOverlappingRectangle(new Rectangle(5, 0, 10, 6))));
	}
}
