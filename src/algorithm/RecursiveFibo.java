package algorithm;

import java.math.BigInteger;

public class RecursiveFibo {

	public static void main(String[] args) {
		System.out.println("RecursiveFibo");
		int array[] = {10,20,50,100};
		for(int i=0;i<array.length;i++) {
			System.out.println("input num : " + array[i]);
			long startTime = System.currentTimeMillis();
			BigInteger result = fibo(array[i]);
			long endTime = System.currentTimeMillis();
			System.out.println("fibo num : "+result+"\ndelay : "+(endTime-startTime)/1000.0+"s\n");
		}
	}
	
	public static BigInteger fibo(long n) {
		if(n <= 2)
			return BigInteger.ONE;
		else 
			return fibo(n-1).add(fibo(n-2));
	}
}
