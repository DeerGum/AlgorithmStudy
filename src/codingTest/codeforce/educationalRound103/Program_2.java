package codingTest.codeforce.educationalRound103;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n, k;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            int increase = 0;
            double rate = k;
            double sum = arr[0];
            for (int j = 1; j < n; j++) {
                double temp = (arr[j] * 100) / sum  ;
                double temp2;
                if( temp > rate) {
                    temp2 = temp - rate;
                    increase += sum * temp2;
                    sum += (arr[j] + sum/temp2);
                }
                else
                    sum += arr[j];
            }

            bw.write(increase+"\n");
        }
        bw.flush();
    }
}
