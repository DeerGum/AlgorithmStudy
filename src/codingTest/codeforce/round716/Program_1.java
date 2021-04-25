package codingTest.codeforce.round716;

import java.io.*;
import java.util.StringTokenizer;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
        int[] arr;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];

            for (int j = 0; j < arr.length; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            boolean result = false;
            for (int j = 0; j < arr.length; j++) {
                Double temp = Math.sqrt(arr[j]);
                if (temp != temp.intValue()) {
                    result = true;
                    break;
                }
            }
            if (result)
                bw.write("YES");
            else
                bw.write("NO");
            bw.newLine();
            bw.flush();
        }
    }
}
