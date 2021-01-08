package ps_study.week_1;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon1406 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int commandNum = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<Character>();
        for(int i=0; i<str.length();i++)
            left.push(str.charAt(i));

        StringTokenizer st;
        for(int i=0;i<commandNum;i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "L":
                    if(!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    if(!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case "B":
                    if(!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "P":
                    left.push(st.nextToken().charAt(0));
                    break;
            }
        }

        while(!left.isEmpty())
            right.push(left.pop());
        while(!right.isEmpty())
            bw.write(right.pop());

        bw.flush();
        br.close();
        bw.close();
    }
}
