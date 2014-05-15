package charnetskaya.threads;


public class FactorialThreads {


	public static void main(String[] args) {
		Thread t1 = new Factorial(5);
		Thread t2 = new Factorial(2);
		
		t1.start();
		t2.start();
	}

}
