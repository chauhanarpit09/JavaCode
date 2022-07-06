package thread;

public class Semaphore {
	private int value; // how many resources we have
	public Semaphore(int init) {
		if(init<0)
			init  = 0;
		value = init;
	}
	
	public synchronized void down() { //p = down I am acquiring the resource
		while(value==0) {
			try {
				wait(); // thread will wait till resource free
			} catch(InterruptedException e) {}
		}
		value--; 
	}
	
	public synchronized void up() { //releasing the resource
		value++;
		notify();
	}
}
