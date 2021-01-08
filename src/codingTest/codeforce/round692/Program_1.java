package codingTest.codeforce.round692;

import java.io.*;
import java.util.Stack;

public class Program_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> s;
        char[] str;
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(br.readLine());
            String read = br.readLine();
            str = new char[n];
            s = new Stack<>();
            for(int j=0;j<n;j++) {
                str[j] = read.charAt(j);
            }

            for(int j=0;j<n;j++) {
                if(str[j] == ')')
                    s.push(str[j]);
                else {
                    s = new Stack<>();
                }
            }
            if(s.size() > n/2)
                bw.write("Yes");
            else
                bw.write("No");
            bw.newLine();
        }
        bw.flush();

    }
}
