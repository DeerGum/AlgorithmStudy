package codingTest.codeforce.round702;

import java.io.*;

public class Program_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long n;
        long a,b;

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            a = 1024;
            b = 1024;
            long temp1, temp2;
            long parsing = (long)Math.cbrt(n);
            temp1 = parsing/2;
            temp2 = parsing/2;
            while(true) {
                temp1 = (long)Math.pow(a,3);
                temp2 = (long)Math.pow(b,3);

                if (temp1+temp2 < n) {
                    a *= 2;
                    b *= 2;

                }
                else if (temp1+temp2 > n) {
                    a /= 2;
                    b /= 2;

                }

            }



        }
    }
}
/*
54
1
1

2
2
16

4
4
128

1000
1000
1000000000

 */