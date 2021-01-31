package codingTest.codeforce.educationalRound103;

import java.io.*;
import java.util.StringTokenizer;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n, k;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if(n == k) {
                bw.write(1+"\n");
            }
            else if(n > k) {
                for (int j = 2; true ; j++) {
                    int temp = k * j;
                    if (n <= temp) {
                        if(temp%n == 0)
                            bw.write(temp/n+"\n");
                        else
                            bw.write((temp/n + 1)+"\n");
                        break;
                    }
                }
            }
            else {  // n < k
                if(k%n == 0)
                    bw.write(k/n+"\n");
                else
                    bw.write((k/n+1)+"\n");
            }
        }
        bw.flush();
    }

}
