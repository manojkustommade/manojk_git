import java.util.*;
public class ReservationApplication extends BerthReservation {
    
	public static void main(String[] args) {
           BerthReservation br=new BerthReservation();	
           Thread t1=new Thread(br);
           Thread t2=new Thread(br);
           Thread t3=new Thread(br);
           t1.setName("Manoj");
           t2.setName("ManojY");
           t3.setName("vaibhav");
           t1.start();
           t2.start();
           t3.start();
		}
		
	}


