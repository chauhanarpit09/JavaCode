package thread;

import java.util.*;

public class DiningPhilospherProblem {
	philospher[] philosphers;
	Fork[] forks;
	Thread[] threads;
	
	Scanner scan;
	int number;
	
	public static void main(String[] args) {
		DiningPhilospherProblem ob = new DiningPhilospherProblem();
		ob.init();
		ob.startThinkingEating();
	}
	public void startThinkingEating() {}
	public void init(){}
	public class Fork{}
	public class philospher{}
}
