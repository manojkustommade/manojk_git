import java.lang.Math;
public class Overlappmethod {
	public void RectangleOverlap(int lb1x1,int lb1y1,int tr1x1,int tr1y1,int lb2x2,int lb2y2,int tr2x2,int tr2y2) {
		int ax1=0,ay1=0,cx1=0,cy1=0,bx1=0,by1=0,dx1=0,dy1=0;
		int flag=1;
		if(lb1x1 > tr2x2 ||lb2x2 > tr1x1 ) {
			 System.out.println("Not overlapping");
			 flag=0;
		}
		else if(lb1y1 > tr2y2 || lb2y2 > tr1y1) {
			System.out.println("Not overlapping");
			flag=0;
		}
		if(flag==1) {
			ax1=Math.max(lb1x1, lb2x2);
			ay1=Math.max(lb1y1,lb2y2);
			cx1=Math.min(tr1x1,tr2x2);
			cy1=Math.min(tr1y1, tr2y2);
			bx1=cx1;
			by1=ay1;
			dx1=ax1;
			dy1=cy1;
			System.out.println("Overlapping Rectangle Points ("+ax1+","+ay1+"), "+"("+bx1+","+by1+"), "+"("+cx1+","+cy1+"), "+"("+dx1+","+dy1+")");
			
		}
		
	}

}
