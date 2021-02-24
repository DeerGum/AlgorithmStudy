package codingTest.codeforce.educationalRound104;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
        int[] heroes;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            heroes = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                heroes[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(heroes);

            int temp = heroes[0];
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (heroes[j] == temp) {
                    count++;
                }
                else {
                    break;
                }
            }
            bw.write(n-count+"\n");
        }
        bw.flush();
    }
}

/*
경우의 수

한쪽이 큰 경우
같은 경우

1 1 1 2 3 4
1 2 3 4 5 6
1 1 1 1 1 1


 */