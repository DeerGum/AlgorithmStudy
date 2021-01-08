package codingTest.codeforce.prevCode;

import java.io.*;
import java.util.StringTokenizer;

public class Program_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
        int max;
        int[] arr;
        StringTokenizer st;
        for(int l=0;l<t;l++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++)
                arr[j] = Integer.parseInt(st.nextToken());

            max = 0;

            for(int j=n;j>0;j--) {
                int idx = j;
                int temp = 0;
                while(idx <= n) {
                    temp += arr[idx];
                    idx += arr[idx];
                }
                arr[j] = temp;
                if(max < temp)
                    max = temp;
            }

            bw.write(max+"\n");
        }
        bw.flush();
    }
}
