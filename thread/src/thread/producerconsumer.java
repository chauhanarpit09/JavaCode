package thread;
import java.util.*;


class Producer implements Runnable{
	List<Integer> temp;
	public Producer(List<Integer> temp) {
		this.temp = temp;
	}
	public void run() {
		int i=0;
		while(true) {
			if(temp.size()==4)
				continue;
			i++;
			temp.add(i);
			System.out.println("put"+temp.size());
		}
	}
}

class Consumer implements Runnable{
	List<Integer> temp;
	public Consumer(List<Integer> temp) {
		this.temp = temp;
	}
	public void run() {
		while(true) {
			if(temp.isEmpty())
				continue;
			temp.remove(temp.size()-1);
			System.out.println("get"+temp.size());
		}
	}
}

public class producerconsumer {

	public static void main(String[] args) {
		List<Integer> temp = new ArrayList<>();
		Thread p = new Thread(new Producer(temp));
		Thread c = new Thread(new Consumer(temp));
		p.start();
		c.start();

	}

}
