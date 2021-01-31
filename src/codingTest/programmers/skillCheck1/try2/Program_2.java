package codingTest.programmers.skillCheck1.try2;

import java.io.*;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
    }

    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder(phone_number);
        int len = sb.length();
        int starLen = len - 4;
        for (int i = 0; i < starLen; i++)
            sb.setCharAt(i,'*');

        return sb.toString();
    }
}
