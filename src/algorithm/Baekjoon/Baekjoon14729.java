package algorithm.Baekjoon;


import java.util.Scanner;

public class Baekjoon14729 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		double grades[] = new double[n];
		for(int i=0;i<grades.length;i++)
			grades[i] = input.nextDouble();
		
		sort(grades, 7);
		
		for(int i=0;i<7;i++)
			System.out.printf("%.3f\n",grades[i]);

	}
	
	public static void sort(double[] arr, int n) {
		double temp;
		int index;
		
		for(int i=0;i<n;i++) {
			index = -1;
			temp = arr[i];
			for(int j=i;j<arr.length;j++) {
				if(temp>arr[j]) {
					temp = arr[j];
					index = j;
				}
			}
			if(index != -1) {
				arr[index] = arr[i];
				arr[i] = temp;
			}			
		}
	}
}
