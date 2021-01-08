package codingTest.codeforce.educationalRound101;

import java.io.*;
import java.util.Stack;

public class Program_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> s;

        int t = Integer.parseInt(br.readLine());
        String input;
        int result;
        for(int len=0;len<t;len++) {
            input = br.readLine();
            result = 0;
            s = new Stack<>();
            if(input.length()%2 == 1) {
                bw.write("NO\n");
                continue;
            }

            for(int i=0;i<input.length();i++) {
                char temp = input.charAt(i);
                if(s.isEmpty()) {
                   if(temp == '(') {
                       s.push(temp);
                   }
                   else if(temp ==')') {
                       result = -1;
                       break;
                   }
                   else {
                       s.push(temp);
                   }
                }
                else {
                    if(temp == '(')
                        s.push(temp);
                    else if(temp == ')') {
                        s.pop();
                    }
                    else {
                        s.push(temp);
                    }
                }
            }
            if(result != -1) {
                if(s.isEmpty() || s.size()%2 == 0)
                    bw.write("YES\n");
                else
                    bw.write("NO\n");
            }
            else {
                bw.write("NO\n");
            }
        }
        bw.flush();

    }
}
