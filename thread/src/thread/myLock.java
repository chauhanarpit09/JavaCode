package thread;

public class myLock {
	private boolean isLocked = false;
	
	public synchronized void lockThread() {
		while(isLocked) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		this.isLocked = true;
	}
	
	public synchronized void unlockThread() {
		this.isLocked = false;
		notify();
	}

}
