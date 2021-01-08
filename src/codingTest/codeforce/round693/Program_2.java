package codingTest.codeforce.round693;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        Stack<Integer> s1;
        Stack<Integer> s2;
        int n;
        StringTokenizer st;
        for(int i=0;i<t;i++) {
            s1 = new Stack<>();
            s2 = new Stack<>();
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    s1.add(temp);
                }
                else {
                    s2.add(temp);
                }
            }

            if(n%2 == 0) {
                if(s1.size() % 2 == 0 && s2.size() % 2 == 0) {
                    bw.write("YES");
                }
                else
                    bw.write("NO");
            }
            else {
                if(s1.size() % 2 == 0 && s1.size() != 0) {
                    bw.write("YES");
                }
                else
                    bw.write("NO");
            }
            bw.newLine();
        }
        bw.flush();

    }
}
