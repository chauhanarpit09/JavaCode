package thread;


class MyThread extends Thread{
	public void run() {
		while(true) {
			System.out.println("Thread1");
		}
	}
}

class MyThread2 extends Thread{
	public void run() {
		while(true) {
			System.out.println("Thread2");
		}
	}
}

public class ThreadExample {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread2 t2 = new MyThread2();
		t1.start();
		t2.start();

	}

}
