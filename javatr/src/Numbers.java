
public class Numbers implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
        for(int i=1;i<=5;i++) {
        	System.out.println(i+" ");
        }
        try {
        	
        	Thread.sleep(3000);
        }
        catch(InterruptedException e) {
        	e.printStackTrace();
        	
        }
	}
}
