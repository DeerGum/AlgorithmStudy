package algorithm.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon9359 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long a,b,n;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            long count = 0;
            long high, low;
            for (long j = a; j <= b; j++) {
                high = Math.max(j,n);
                low = Math.min(j,n);
                if(gcd(high,low) == 1)
                    count++;
            }

            bw.write("Case #"+(i+1)+": "+count);
            bw.newLine();
        }
        bw.flush();
    }

    public static long gcd(long a, long b) {
        if(a % b == 0)
            return b;
        return gcd(b, a%b);
    }
}