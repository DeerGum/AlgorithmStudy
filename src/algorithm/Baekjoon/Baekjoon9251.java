package algorithm.Baekjoon;

import java.io.*;

public class Baekjoon9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str1, str2;
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        int[][] dp = new int[2][str2.length+1];   //2행만 사용함
        int maxIdx = 0;
        for (int i = 1, idx = 0; i < str1.length + 1; i++, idx = ++idx % 2) {
            for (int j = 1; j < str2.length + 1; j++) {
                if (str1[i-1] == str2[j-1])   //문자가 같으면
                    dp[idx][j] = dp[(idx+1)%2][j-1]+1;  //대각선 왼쪽 윗칸값에 1을 더함
                else    //문자가 다르면
                    dp[idx][j] = Math.max(dp[(idx+1)%2][j],dp[idx][j-1]); //왼쪽과 위쪽값중에 큰 값
            }
            maxIdx = idx;
        }

        bw.write(dp[maxIdx][str2.length]+"");
        bw.flush();
    }
}