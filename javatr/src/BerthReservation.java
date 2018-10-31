import java.util.*;
public class BerthReservation implements Runnable{
        protected int available=10;
        protected int requested;
        protected String name;
        		
		@Override
		public synchronized void run() {
		  Scanner s=new Scanner(System.in);
		  int flag=1;
		  do {
		    System.out.println("Welcome to booking reservation "+Thread.currentThread().getName());
		    System.out.println("No of seats available "+available);
		    
		    if(available>0) {	
		    	
		    	System.out.println("\nEnter requested seats");
			    requested=s.nextInt();
		    	if(requested<=available) {
				   available=available-requested;
				   System.out.println("You booked "+requested+" seats\n");
				   flag=1;
			    }
		    	else {
		    		flag=0;
		    		System.out.println("Sorry, No seats available  for your requested seats");
		    	}
		   }  
		    else {
		    	System.out.println("Available seats are "+available);
		    	flag=0;
		    }
			
		}while(flag!=0);
	  }  
}
