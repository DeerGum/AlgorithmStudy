package codingTest.codeforce.educationalRound104;

import java.io.*;
import java.util.StringTokenizer;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n, k, result;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if (n%2 == 0) {
                result = (k%n == 0)? n : k%n;
            }
            else {
                int temp = (k-1)/(n/2);
                k += temp;
                result = (k%n == 0)? n : k%n;
            }
            bw.write(result+"\n");
        }
        bw.flush();
    }
}
/*
1 2 3 4 5
5 4 3 2 1
1 2 4 5 2

n k
7 11
1 2 3 4 5 6 7/8 9 10 11
7 6 5 4 3 2 1 7 6 5  4
1 2 3 5 6 7 2 3 4 6  7

n이 짝수이면 방해받지 않고 이동가능
result = k%n == 0? n : k%n


n이 홀수이면
k <= n/2
result = k
k > n/2
    k < n
    result = k+1
    k >= n
    result = (k-1)/(n/2)

 */