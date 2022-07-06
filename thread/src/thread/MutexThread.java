package thread;

public class MutexThread extends Thread{
	private Semaphore mutex;
	public MutexThread(Semaphore mutex, String name) {
		super(name);
		this.mutex = mutex;
		start();
	}
	public void run() {
		while(true) {
			mutex.down();// acquiring lock
			System.out.println("Enter Critical Sectio: "+ getName());
			try {
				sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {}
			System.out.println("Leave Critical Section: "+ getName());
			mutex.up(); // releasing lock
		}
	}
}
