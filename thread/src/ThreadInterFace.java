

class MyThreadRunnable1 implements Runnable{
	public void run(){
		int i=0;
		while(i<1000) {
			System.out.println("thread1");
			i++;
		}
	}
}

class MyThreadRunnable2 implements Runnable{
	public void run(){
		int i=0;
		while(i<1000) {
			System.out.println("thread2");
			i++;
		}
	}
}

public class ThreadInterFace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyThreadRunnable1());
		Thread t2 = new Thread(new MyThreadRunnable2());
		t1.start();
		t2.start();
	}

}
