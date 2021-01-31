package codingTest.programmers.skillCheck2.try1;

/**
 * 땅따먹기
 * 문제링크 https://programmers.co.kr/learn/courses/30/lessons/12913
 */
public class Program_1 {
    public static int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[2][4];
        int idx = 0;
        int max;
        int resultMax = 0;
        for (int i = 0; i < n; i++) {
            if (idx == 0) {
                for (int j = 0; j < 4; j++) {
                    dp[idx][j] = land[i][j];
                    max = 0;
                    for (int k = 0; k < 4; k++) {
                        if(k == j)
                            continue;
                        if (dp[1][k] > max)
                            max = dp[1][k];
                    }
                    dp[idx][j] += max;
                    if (dp[idx][j] > resultMax)
                        resultMax = dp[idx][j];
                }
                idx = 1;
            }
            else {  //idx = 0
                for (int j = 0; j < 4; j++) {
                    dp[idx][j] = land[i][j];
                    max = 0;
                    for (int k = 0; k < 4; k++) {
                        if(k == j)
                            continue;
                        if (dp[0][k] > max)
                            max = dp[0][k];
                    }
                    dp[idx][j] += max;
                    if (dp[idx][j] > resultMax)
                        resultMax = dp[idx][j];
                }
                idx = 0;
            }
        }
        return resultMax;
    }
}
