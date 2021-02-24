package codingTest.programmers.skillCheck2.try1;

/**
 * 땅따먹기
 * 문제링크 https://programmers.co.kr/learn/courses/30/lessons/12913
 */
public class Program_1 {
    public int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[2][4];
        int row = 0;    //dp array row
        int max;
        int resultMax = 0;
        for (int i = 0; i < n; i++) {
            if (row == 0) {
                for (int j = 0; j < 4; j++) {
                    dp[0][j] = land[i][j];    //dp배열에 땅배열 값 저장
                    max = 0;
                    for (int k = 0; k < 4; k++) {   //다른 행 순회 dp[1]
                        if(k == j)  //같은 열에 있으면 건너 뜀
                            continue;
                        if (dp[1][k] > max) //최대값 갱신
                            max = dp[1][k];
                    }
                    dp[0][j] += max;  //이전 행의 최대값을 더해줌
                    if (dp[0][j] > resultMax)
                        resultMax = dp[0][j];
                }
                row = 1;    //행 번호 변경
            }
            else {  //row = 1
                for (int j = 0; j < 4; j++) {
                    dp[1][j] = land[i][j];
                    max = 0;
                    for (int k = 0; k < 4; k++) {   //다른 행 순회 dp[0]
                        if(k == j)  //같은 열에 있으면 건너 뜀
                            continue;
                        if (dp[0][k] > max) //최대값 갱신
                            max = dp[0][k];
                    }
                    dp[1][j] += max;  //이전 행의 최대값을 더해줌
                    if (dp[1][j] > resultMax) //결과 최대값 갱신
                        resultMax = dp[1][j];
                }
                row = 0;    //행 번호 변경
            }
        }
        return resultMax;
    }
}
