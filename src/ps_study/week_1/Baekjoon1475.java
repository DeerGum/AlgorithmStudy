package ps_study.week_1;

import java.util.Scanner;

public class Baekjoon1475 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String roomNum = input.next();
        int sixAndNine = 0;
        int max = 0;
        int[] number = new int[10];
        for(int i=0;i<roomNum.length();i++)
            number[roomNum.charAt(i)-'0']++;

        for(int i=0;i<number.length;i++) {
            if(i == 6 || i == 9) {
                sixAndNine += number[i];
            }
            else {
                if(number[i]>max)
                    max = number[i];
            }
        }
        sixAndNine = (int)Math.ceil(sixAndNine/2.0);
        if(max < sixAndNine)
            max = sixAndNine;
        System.out.println(max);
    }
}
