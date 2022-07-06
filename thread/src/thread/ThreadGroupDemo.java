package thread;
class MyThrea extends Thread{
	MyThrea(ThreadGroup g, String name){
		super(g,name);
	}
	public void run() {
		System.out.println("Child Thread");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class ThreadGroupDemo {
	public static void main(String[] args) {
		ThreadGroup pg = new ThreadGroup("Parent Group");
		ThreadGroup cg = new ThreadGroup(pg,"Child Group");
		MyThrea t1 = new MyThrea(pg,"Thread 1");
		MyThrea t2 = new MyThrea(pg,"Thread 2");
		t1.start();
		t2.start();
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
	}
}
