package codingTest.kakao.intern2022;

import java.util.HashMap;

public class Pro1 {
    static int[] values = {3, 2, 1, 0, 1, 2, 3};
    static char[] alphabet = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    static int[] counts;

    public static void main(String[] args) {
        Pro1 p = new Pro1();


    }

    public String solution(String[] survey, int[] choices) {
        counts = new int[8]; // R T C F J M A N
        HashMap<Character, Integer> index = new HashMap<>();
        index.put('R', 0);
        index.put('T', 1);
        index.put('C', 2);
        index.put('F', 3);
        index.put('J', 4);
        index.put('M', 5);
        index.put('A', 6);
        index.put('N', 7);

        for (int i = 0; i < choices.length; i++) {
            int curr = choices[i] - 1;
            if (curr < 3)
                counts[index.get(survey[i].charAt(0))] += values[curr];
            else
                counts[index.get(survey[i].charAt(1))] += values[curr];
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 8; i+=2) {
            if (counts[i] < counts[i+1])
                answer.append(alphabet[i+1]);
            else
                answer.append(alphabet[i]);
        }

        return answer.toString();
    }
}
