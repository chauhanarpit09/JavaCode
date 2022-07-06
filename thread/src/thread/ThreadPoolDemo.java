package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name;
	PrintJob(String name){
		this.name = name;
	}
	public void run() {
		System.out.println(name+" job started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" job stoped");
	}
}
public class ThreadPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintJob[] jobs = {new PrintJob("durga"),
						   new PrintJob("Ravi"),
						   new PrintJob("Shiva"),
						   new PrintJob("Pavan"),
						   new PrintJob("Suresh"),
						   new PrintJob("Anil")};
		ExecutorService service = Executors.newFixedThreadPool(6);
		for(PrintJob job: jobs) {
			service.submit(job);
		}
		service.shutdown();
	}

}
