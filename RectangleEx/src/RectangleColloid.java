public class RectangleColloid {
	
	/*public RectangleColloid(int lb1x1,int lb1y1,int tr1x1,int tr1y1,int lb2x2,int lb2y2,int tr2x2,int tr2y2) {
		
	}*/
	public static void main(String[] args) {
		int lb1x1=5,lb1y1=0,tr1x1=10,tr1y1=6;
		int lb2x2=0,lb2y2=4,tr2x2=7,tr2y2=12;
		Overlappmethod ovm=new Overlappmethod();
		ovm.RectangleOverlap(lb1x1, lb1y1, tr1x1, tr1y1, lb2x2, lb2y2, tr2x2, tr2y2);
	}	
}
