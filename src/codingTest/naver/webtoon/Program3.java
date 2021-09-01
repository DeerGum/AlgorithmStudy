package codingTest.naver.webtoon;

import java.util.ArrayList;

public class Program3 {
    public static int[] pi;
    public int solution(String s, String t) {
        pi = new int[t.length()];
        getPi(t);

        int result = 0;
        while(kmp(s, t)) {
            s = s.replaceFirst(t,"");
            result++;
        }

        return result;
    }

    public void getPi(String target) {
        int j = 0;
        for (int i = 1; i< target.length(); i++) {
            while( j > 0 && target.charAt(i) != target.charAt(j))
                j = pi[j - 1];

            if (target.charAt(i) == target.charAt(j))
                pi[i] = ++j;
        }
    }

    public boolean kmp(String str, String target) {
        int j =0;
        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != target.charAt(j))
                j = pi[j - 1];

            if (str.charAt(i) == target.charAt(j)) {
                if (j == target.length() - 1) {
                    return true;
                }
                else
                    ++j;
            }
        }
        return false;
    }
}
