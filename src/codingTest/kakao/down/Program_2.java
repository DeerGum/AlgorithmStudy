package codingTest.kakao.down;

import java.io.*;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Program_2 p = new Program_2();
        System.out.println(p.solution(1,7));

    }
    // 소수 2 3
    public int solution(int n, int k) {
        String num = convertDigit(n, k);
        return check(num);
    }

    public int check(String num) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char n = num.charAt(i);
            if (n == '0') { //0을 만나면
                if (sb.length() != 0 && isPrime(Integer.parseInt(sb.toString()))) { // 0P0, P0
                    count++;
                }
                sb = new StringBuilder();
            } else {
                sb.append(n);
            }

            if (n != '0' && i+1 == num.length()) {  //마지막인덱스가 0이 아니면
                if (sb.length() != 0 && isPrime(Integer.parseInt(sb.toString())))   // 0P
                    count++;
            }

        }

        return count;
    }

    public boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public String convertDigit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int curr = n;

        if (k == 10)
            return String.valueOf(n);

        while(curr > 0) {
            sb.append(curr % k);
            curr /= k;
        }

        return sb.reverse().toString();
    }
}
/*
2 1 1 0 2 0 1 0 1 0 1 1
0 1 2 3 4 5 6 7 8 9 1011

public int check(String num) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char n = num.charAt(i);
            if (n == '0') { //0을 만나면
                if (sb.length() != 0 && isPrime(Integer.parseInt(sb.toString()))) { // 0P0, P0
                    int startIdx = i - sb.length();
                    if (startIdx == 0) // P0
                        count++;
                    else if (startIdx > 0 && num.charAt(startIdx-1) == '0')  // 0P0
                        count++;
                }

                sb = new StringBuilder();
            } else {
                sb.append(n);
                if (i+1 == num.length()) { //마지막 인덱스이면
                    if (sb.length() != 0 && isPrime(Integer.parseInt(sb.toString())))   // 0P
                        count++;
                }
            }

        }

        return count;
    }
 */