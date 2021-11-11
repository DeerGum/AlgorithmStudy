package codingTest.nhn.commerce_2021;

import java.io.*;
import java.util.StringTokenizer;

public class Program_3 {
    static int N, M, K;
    static int[][] block;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        block = new int[N][M];
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                block[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0, K, new int[N]);
        bw.write(max+"\n");
        bw.close();
    }

    public static void perm(int cnt, int k, int[] p) {
        if (cnt == N) {
            if (k != 0)
                return;

            int sum = 0;
            for (int row = 0; row < N; row++) {
                int col = M - p[row];
                if (col == M)
                    continue;
                sum += block[row][col];
            }
            max = Math.max(sum, max);

            return;
        }

        for (int i = 0; i <= M; i++) {
            if (k - i < 0)
                break;

            p[cnt] = i;
            perm(cnt+1, k-i, p);
        }

    }
}
