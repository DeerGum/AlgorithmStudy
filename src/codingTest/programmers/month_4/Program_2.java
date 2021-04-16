package codingTest.programmers.month_4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Program_2 p2 = new Program_2();
        System.out.println(p2.solution("{"));

    }

    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        char firstChar;

        if (isCorrect(sb.toString()))
            answer++;

        for (int i = 1; i < sb.length(); i++) {
            firstChar = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(firstChar);
            if (isCorrect(sb.toString()))
                answer++;
        }

        return answer;
    }

    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack();
        char c;
        if (s.length()%2 == 1)
            return false;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                    break;
            }
        }
        return true;

    }
}
