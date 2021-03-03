package algorithm.study;

import java.math.BigInteger;

public class RepeatFibo {

	public static void main(String[] args) {
		int array[] = {10,20,50,100};
		System.out.println("RepeatFibo");
		for(int i=0;i<array.length;i++) {
			System.out.println("input num : " + array[i]);
			long startTime = System.currentTimeMillis();
			BigInteger result = repeatFibo(array[i]);
			long endTime = System.currentTimeMillis();
			System.out.println("fibo num : "+result+"\ndelay : "+(endTime-startTime)/1000.0+"s\n");
		}
	}
	
	public static BigInteger repeatFibo(int n) {
		BigInteger n1, n2, result;
		n1=n2=BigInteger.ONE;
		result=BigInteger.ZERO;
		if(n<=2) 
			return BigInteger.ONE;
		else {
			for(int i=3;i<=n;i++) {
				result = n1.add(n2);	
				n1 = n2;
				n2 = result;
			}
			return result;
		}
	}
}
