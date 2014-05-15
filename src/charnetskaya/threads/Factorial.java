package charnetskaya.threads;

import java.math.BigInteger;

public class Factorial extends Thread {
	private long num;
	
	
	public Factorial(long num){
		this.num = num;
	}

	public BigInteger fact (long num){
		
		BigInteger factorialSum = BigInteger.valueOf(1);
		
		for(long i = num; i > 1; i--){
			factorialSum = factorialSum.multiply(BigInteger.valueOf(i));
		}
		return factorialSum;
		
	}
	public void run(){
		super.run();
		System.out.println(fact(num));
	}
}
