package codingTest.codeforce.educationalRound104;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/*
문제링크 - https://codeforces.com/contest/1487/problem/C
 */
public class Program_3 {
    public static int n;
    public static int maxRound;
    public static int[] teams;
    public static LinkedList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            teams = new int[n];
            result = new LinkedList<>();
            maxRound = n*(n-1)/2;

            match(0,1,0);

        }

    }

    public static void match(int idxI, int idxJ, int round) {


        if (round == maxRound) {
            Iterator<Integer> it = result.iterator();
            while (it.hasNext()) {
                int temp = it.next();
                System.out.print(temp+" ");
            }
            System.out.println();
            return;
        }

        boolean first = true;
        for (int i = idxI; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (first) {
                    j = idxJ;
                    first = false;
                    if (j >= n)
                        break;
                }
                teams[i] += 3;  //i 승리
                result.addLast(1);
                match(i,j+1,round+1);
                teams[i] -= 3;
                result.removeLast();

                teams[j] += 3;  //j 승리
                result.addLast(-1);
                match(i,j+1,round+1);
                teams[j] += 3;
                result.removeLast();

                teams[i] += 1;  //무승부
                teams[j] += 1;
                result.addLast(0);
                match(i, j+1,round+1);
                teams[i] -= 1;
                teams[j] -= 1;
                result.removeLast();


            }
        }
    }
}
/*

3
1 2  3 0 0  0 3 0  1 1 0
1 3  3 0 3  3 3 0  2 1 1
2 3  3 3 3  3 3 3  2 2 2

4
1 2  3 0 0 0
1 3  4 0 1 0
1 4  4 0 1 3
2 3  4 3 1 3
2 4  4 4 1 4
3 4  4 4 4 4

5
1 2  3 0 0 0 0
1 3  6 0 0 0 0
1 4  6 0 0 3 0
1 5  6 0 0 3 3
2 3  6 3 0 3 3
2 4  6 6 0 3 3
2 5  6 6 0 3 6
3 4  6 6 3 3 6
3 5  6 6 6 3 6
4 5  6 6 6 6 6

n개의 팀이 있으면 한 팀당 n-1번의 경기를 함

 */