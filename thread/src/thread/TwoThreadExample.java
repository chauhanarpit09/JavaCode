package thread;

public class TwoThreadExample {
	
	public TwoThreadExample() {
		(new SimpleThread("First Thread")).start();
		(new SimpleThread("Second Thread")).start();
		(new SimpleThread("Third Thread")).start();
		(new SimpleThread("Fourth Thread")).start();
		(new SimpleThread("Fifth Thread")).start();
		(new SimpleThread("Sixth Thread")).start();
		
	}
	
	private class SimpleThread extends Thread {
		public SimpleThread(String str) {
			super(str);
		}
		public void run() {
			for(int i=0;i<10;i++) {
				System.out.println(getName() + " says"+i);
				try {
					sleep((long)(Math.random()*1000));
				} catch(InterruptedException e) {
					
				}
			}
			System.out.println("-->" + getName() + " is done");
		}
	}
	
	public static void main(String[] args) {
		new TwoThreadExample();
	}
}
