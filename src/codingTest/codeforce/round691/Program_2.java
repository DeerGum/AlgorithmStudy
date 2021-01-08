package codingTest.codeforce.round691;

import java.io.*;

public class Program_2 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        if(n%2 == 0) {
            if(n == 2)
                bw.write((int)Math.pow(n,2)+"");
            else
                bw.write((int)Math.pow(n/2+1,2)+"");
        }
        else {
            bw.write((int)Math.pow(n+2,2)/2+"");
        }
        bw.newLine();
        bw.flush();
    }
}
