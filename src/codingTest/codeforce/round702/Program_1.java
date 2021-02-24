package codingTest.codeforce.round702;

import java.io.*;
import java.util.StringTokenizer;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
        int[] arr;
        int count;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            count = 0;

            for (int j = 0; j < n - 1; j++) {
                double max = Math.max(arr[j],arr[j+1]);
                double min = Math.min(arr[j],arr[j+1]);

                if (max/min > 2) {
                    if (min == arr[j]) {
                        while(max/min > 2) {
                            min *= 2;
                            count++;
                        }
                    }
                    else {  // min == arr[j+1]
                        while(max/min > 2) {
                            max = (max%2 == 1)? ((int)(max/2) + 1) : (int)(max / 2);
                            count++;
                        }
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}
