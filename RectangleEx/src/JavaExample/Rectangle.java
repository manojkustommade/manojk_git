package JavaExample;

import java.lang.Math;

public class Rectangle {
	private Point leftBottom;
	private Point rightTop;

	public Rectangle(int leftBottomX, int leftBottomY, int rightTopX, int rightTopY) {
		leftBottom = new Point(leftBottomX, leftBottomY);
		rightTop = new Point(rightTopX, rightTopY);
	}

	public boolean isOverlapping(Rectangle r) {
		boolean flag = true;
		if (leftBottom.getX() > r.rightTop.getX() || r.leftBottom.getX() > rightTop.getX()) {
			flag = false;
		}
		if (leftBottom.getY() > r.rightTop.getY() || r.leftBottom.getY() > rightTop.getY()) {
			flag = false;
		}
		return flag;
	}

	public Rectangle getOverlappingRectangle(Rectangle rectangle) {
		int leftBottomOverlappedRectX = 0, leftBottomOverlappedRectY = 0, rightTopOverlappedRectX = 0,
				rightTopOverlappedRectY = 0;
		if (!isOverlapping(rectangle)) {
			return null;
		}
		leftBottomOverlappedRectX = Math.max(leftBottom.getX(), rectangle.leftBottom.getX());
		leftBottomOverlappedRectY = Math.max(leftBottom.getY(), rectangle.leftBottom.getY());
		rightTopOverlappedRectX = Math.min(rightTop.getX(), rectangle.rightTop.getX());
		rightTopOverlappedRectY = Math.min(rightTop.getY(), rectangle.rightTop.getY());
		Rectangle rect = new Rectangle(leftBottomOverlappedRectX, leftBottomOverlappedRectY, rightTopOverlappedRectX,
				rightTopOverlappedRectY);
		return rect;
	}
	public boolean isEqual(Rectangle r) {
		if ((leftBottom.getX() == r.leftBottom.getX()) && (leftBottom.getY() == r.leftBottom.getY())
				&& (rightTop.getX() == r.rightTop.getX()) && (rightTop.getY() == r.rightTop.getY()))
				return true;
		return false;
	}

	
}
