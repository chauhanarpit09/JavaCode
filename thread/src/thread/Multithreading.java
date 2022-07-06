package thread;

public class Multithreading {
	public static void main(String[] args) {
		int noThreadInCriticalSection = 3;
		Semaphore mutex = new Semaphore(noThreadInCriticalSection);
		for(int i=1;i<=10;i++) {
			new MutexThread(mutex,"Thread "+i);
		}
	}
}
