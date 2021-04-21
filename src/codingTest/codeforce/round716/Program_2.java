package codingTest.codeforce.round716;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n, k;

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if (n <= k) {
                bw.write((int)(Math.pow(n,k))+"\n");
            }
            else {

                BigInteger temp = BigInteger.ONE;
                BigInteger temp2 = BigInteger.ONE;
                long temp3 = (long)Math.pow(k,k);

                for (int j = n; j > (n - k) ; j--) {
                    temp = temp.multiply(BigInteger.valueOf(j));
                }

                for (int j = k; j > 0; j--) {
                    temp2 = temp2.multiply(BigInteger.valueOf(j));
                }

                temp = temp.divide(temp2);
                temp = temp.multiply(BigInteger.valueOf(temp3));
                temp = temp.remainder(BigInteger.valueOf(1000000007));

                bw.write(temp+"\n");
            }
        }
        bw.flush();
    }
}

/*
1 0 1 0
8 0 2 0
10

4 4

1 1 1 0
1 1 0 1
1 0 1 1
0 1 1 1

0 0 0 0
1 1 1 1
1 1 1 1
1 1 1 1





0 3

1 0
0 1

1 1
0 0

4 2

1 1
1 1
1 0
0 1

1 1
1 0
1 1
0 1

1 1
1 0
0 1
1 1

1 0
1 1
0 1
1 1

1 0
0 1
1 1
1 1

1 0
1 1
1 1
0 1

2 x 2 x 6

4 2
  4!
-----
2! 2!
= 6

5 2
  5!
------
2! 3!

2 3
2^3 = 8

0 0 0
1 1 1

0 0 1
1 1 0

0 1 0
1 0 1

0 1 1
1 0 0

1 0 0
0 1 1

1 0 1
0 1 0

1 1 0
0 0 1

1 1 1
0 0 0


100000 20

100000!
-------
20! 99080!
8

1 2

2 2




 */
