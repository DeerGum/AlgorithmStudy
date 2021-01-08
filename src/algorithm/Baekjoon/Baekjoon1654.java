package algorithm.Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1654 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k, n;
		k = input.nextInt();
		n = input.nextInt();
		
		long[] arr = new long[k];
		
		for(int i=0;i<k;i++)
			arr[i] = input.nextInt();
		
		Arrays.parallelSort(arr);
		
		long lowNum = arr[k-1];

		long result = binarySearch(arr,lowNum,n);
		System.out.println(result);
	}

	public static long binarySearch(long[] arr, long x, long n) {
		long mid = 0, low = 1, high = x;
		int count;
		long max = 0;
		while(low<=high) {
			count = 0;
			mid = (low+high)/2;
			
			for(int i=0;i<arr.length;i++) 
				count += arr[i]/mid;
			
			if(count >= n) {
				low = mid+1;
				if(mid>max) 
					max = mid;
			}
			else if(count < n) 
				high = mid-1;
		}
		return max;
	}
}
