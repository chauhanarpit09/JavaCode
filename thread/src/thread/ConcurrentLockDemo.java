package thread;

import java.util.concurrent.locks.ReentrantLock;
class Display{
	ReentrantLock l = new ReentrantLock();
	public void wish(String name) {
		for(int i=0;i<10;i++) {
			l.lock();
			System.out.print("GoodMorning ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
			l.unlock();
		}
	}
}

class DemoThread extends Thread{
	Display d;
	String name;
	DemoThread(Display d,String name){
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}
public class ConcurrentLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d = new Display();
		DemoThread t1 = new DemoThread(d,"Dhoni");
		DemoThread t2 = new DemoThread(d,"Yuvi");
		t1.start();
		t2.start();
	}

}
