package codingTest.gabia;

import java.util.*;

public class Pro2 {
    public static int solution(String p) {
        int len = p.length();
        int leftIdx = 0;
        int rightIdx = len - 1;
        int answer = 0;

        boolean leftSearch = true;
        boolean rightSearch = true;
        for (int i = 0; i < len && (leftSearch || rightSearch); i++) {
            if (leftSearch) {
                if (p.charAt(leftIdx++) == '<')
                    answer++;
                else
                    leftSearch = false;
            }

            if (rightSearch) {
                if (p.charAt(rightIdx--) == '>')
                    answer++;
                else
                    rightSearch = false;
            }
        }

        return answer;
    }
}
/*
투포인터를 사용하면 최적화가능
양끝으로 향하는 방향의 갯수를 세면 됨


 */