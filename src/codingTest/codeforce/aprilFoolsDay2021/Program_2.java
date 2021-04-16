package codingTest.codeforce.aprilFoolsDay2021;

import java.io.*;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        bw.write((int)(Math.sqrt(t))+"\n");
        bw.flush();
    }
}
