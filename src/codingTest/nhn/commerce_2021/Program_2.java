package codingTest.nhn.commerce_2021;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n, m;
        int[] num;
        HashSet<Integer> set;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            num = new int[n];
            set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                num[j] = Integer.parseInt(st.nextToken());

            int idx = 0;
            for (int j = 0; j < n; j++) {
                set.add(num[j]);
                idx = j;
                if (set.size() >= m) {
                    idx = j+1;
                    break;
                }
            }

            bw.write(idx+"\n");
        }
        bw.close();
    }
}
