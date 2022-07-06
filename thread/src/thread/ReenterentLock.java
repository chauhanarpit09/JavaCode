package thread;

public class ReenterentLock {
	boolean isLocked = false;
	Thread lockedBy = null;
	int lockedCount = 0;
	
	public synchronized void lock() {
		Thread callingThread = Thread.currentThread();
		while(this.isLocked && this.lockedBy != callingThread) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.isLocked = true;
		this.lockedBy = callingThread;
		this.lockedCount++;
	}
	
	public synchronized void unlock() {
		if( Thread.currentThread() == this.lockedBy) {
			this.lockedCount--;
			if(this.lockedCount==0) {
				this.isLocked = false;
				notify();
			}
		}
	}
}
