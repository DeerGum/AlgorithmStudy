package codingTest.codeforce.round694;

import java.io.*;
import java.util.StringTokenizer;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr;
        int n, x;
        for(int test=0;test<t;test++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            int min = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                min += arr[i];
            }
            int max = 0;
            for(int i=0;i<n;i++) {
                int mod = arr[i]%x;
                int div = arr[i]/x;
                arr[i] = (mod == 0)? div : div+1;
                max += arr[i];
            }

            int mod = min%x;
            min = (mod == 0)? min/x : min/x+1;

            bw.write(min+" "+max+"\n");
        }
        bw.flush();

    }
}
