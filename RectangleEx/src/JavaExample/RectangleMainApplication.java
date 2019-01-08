package JavaExample;

public class RectangleMainApplication {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(0, 0, 3, 3);
		Rectangle r2 = new Rectangle(1, 1, 2, 2);
		System.out.println(r1.getOverlappingRectangle(r2));
	}
}
