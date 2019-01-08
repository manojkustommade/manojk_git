import java.lang.Math;
public class Rectangle {
	Point leftbottom;
	Point topright;
	
	public Rectangle(int RectLeftbottomx,int RectLeftbottomy,int RectToprightx,int RectToprighty) {
		  leftbottom=new Point();
		  topright=new Point();
		  leftbottom.x=RectLeftbottomx;
	      leftbottom.y=RectLeftbottomy;
	      topright.x=RectToprightx;
	      topright.y=RectToprighty;
	}
	
	public void OverlappingRectangle(Rectangle rectangle) {
		int overlappedRectx1=0,overlappedRecty1=0,overlappedRectx3=0,overlappedRecty3=0,overlappedRectx2=0,overlappedRecty2=0,overlappedRectx4=0,overlappedRecty4=0;
		boolean flag=true;
		if(leftbottom.x > rectangle.topright.x ||rectangle.leftbottom.x > topright.x ) {
			 System.out.println("Not overlapping");
			 flag=false;
		}
		if(leftbottom.y > rectangle.topright.y || rectangle.leftbottom.y > topright.y) {
			System.out.println("Not overlapping");
			flag=false;
		}
		if(flag) {
			overlappedRectx1=Math.max(leftbottom.x, rectangle.leftbottom.x);
			overlappedRecty1=Math.max(leftbottom.y,rectangle.leftbottom.y);
			overlappedRectx3=Math.min(topright.x,rectangle.topright.x);
			overlappedRecty3=Math.min(topright.y, rectangle.topright.y);
			overlappedRectx2=overlappedRectx3;
			overlappedRecty2=overlappedRecty1;
			overlappedRectx4=overlappedRectx1;
			overlappedRecty4=overlappedRecty3;
			System.out.println("Overlapping Rectangle Points ("+overlappedRectx1+","+overlappedRecty1+"), "+"("+overlappedRectx2+","+overlappedRecty2+"), "+"("+overlappedRectx3+","+overlappedRecty3+"), "+"("+overlappedRectx4+","+overlappedRecty4+")");
			
		}
		
	}

}
