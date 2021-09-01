package codingTest.naver.webtoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Program2 {
    public static void main(String[] args) {
        String[] result = solution("abcdef");
        for (String str : result)
            System.out.println(str);
    }

    public static String[] solution(String s) {
        int len = s.length();
        String left, right;
        Queue<String> answerLeft = new LinkedList<>();
        Stack<String> answerRight = new Stack<>();

        int piece = 1;
        for (int i = 0; i < len / 2; ) {
            left = s.substring(i, i + piece);
            right = s.substring(len - i - piece, len - i);

            if (left.equals(right)) {
                answerLeft.add(left);
                if (i != len - i - piece)
                    answerRight.push(left);
                i += piece;
                piece = 1;
            } else
                piece++;
        }

        String[] answer = new String[answerLeft.size() + answerRight.size()];

        for (int i = 0; i < answer.length; i++) {
            if (!answerLeft.isEmpty()) {
                answer[i] = answerLeft.poll();
            } else if (!answerRight.isEmpty()) {
                answer[i] = answerRight.pop();
            }
        }

        return answer;
    }


}
/*
a xy day xy a
axydayxya
012345678
1 2 3

price = 2
i = 0
left = 0, 2
right = 4, 6

i = 2
left = 2, 4
right = 2, 4

 */