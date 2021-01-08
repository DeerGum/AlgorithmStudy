package algorithm;

import java.util.Scanner;

public class HanoiTower {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("hanoi : ");
		int n = input.nextInt();
		hanoi(n,"A","B","C");
	}
	
	public static void hanoi(int n, String start, String to, String temp) {
		if(n==1)
			System.out.println(start+" --> "+to);
		else {
			hanoi(n-1,start,temp,to);
			System.out.println(start+" --> "+to);
			hanoi(n-1,temp,to,start);
		}
	}
}
