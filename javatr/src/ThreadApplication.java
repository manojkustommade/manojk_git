
public class ThreadApplication extends Numbers{
	public static void main(String[ ] args) {
		Numbers num=new Numbers();
		Thread t1=new Thread(num);
		Thread t2=new Thread(num);
		Thread t3=new Thread(num);
		t1.setName("Thread1");
		t2.setName("Thread2");
		t3.setName("Thread3");
		t1.start();
		t2.start();
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.start();
	}

}
