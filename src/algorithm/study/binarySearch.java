package algorithm.study;

import java.util.Random;

public class binarySearch {

	public static final int ARR_SIZE = 20;
	public static final int X_RANGE = 50;
	public static Random r = new Random();

	public static void main(String[] args) {
		int[] arr = new int[ARR_SIZE];
		int x = r.nextInt(X_RANGE);	//������ �˻�����
		initArray(arr);
		int searchIndex = binarySearch(arr,x);
		printArray(arr);
		System.out.println("X : "+x);
		System.out.println((searchIndex != -1) ? ("X index : "+searchIndex):("X is not found"));
	}
	
	
	public static void initArray(int[] arr) {
		//random number init
		for(int i=0;i<ARR_SIZE;i++) {
			arr[i] = r.nextInt(X_RANGE);
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) 
					i--;
			}
		}
		int temp;
		//array sort
		for(int i=0;i<ARR_SIZE;i++) {
			for(int j=0;j<ARR_SIZE-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static int binarySearch(int[] arr, int x) {
		int mid, low = 0, high = ARR_SIZE-1;
		
		while(low <= high) {
			mid = (low + high) / 2;
			if(arr[mid] == x)
				return mid;
			else if(arr[mid] < x) 
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		return -1;	//�迭�ȿ� x�� ����
	}
	
	public static int binarySearch2(int[] arr, int x, int low, int high) {
		int mid;
		
		if(low > high)
			return -1;
		else {
			mid = (low + high)/2;
			if(x == arr[mid])
				return mid;
			else if(x < arr[mid])
				return binarySearch2(arr,x,low,mid-1);
			else
				return binarySearch2(arr,x,mid+1,high);
		}
	}
	
	public static void printArray(int[] arr) {
		System.out.print("[ ");
		for(int i=0;i<ARR_SIZE;i++) {
			System.out.print(arr[i]+" ");
			if(i % 50 == 0 && i!= 0)
				System.out.println();
		}
		System.out.println("]");
	}
}
