package codingTest.gabia;

public class Pro6 {
    private static int[][] map;
    private static int K;
    private static int N;

    public int solution(int[][] grid, int K) {
        this.K = K;
        initMap(grid);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int customer1 = map[i][j];
                answer = Math.max(customer1 + findMaxCustomer2(i, j), answer);
            }
        }

        return answer;
    }

    private void initMap(int[][] grid) {
        if (K == 1) {
            N = grid.length;
            map = grid;
            return;
        }

        N = grid.length - K + 1;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < K; k++) {
                    for (int l = 0; l < K; l++) {
                        map[i][j] += grid[i + k][j + l];
                    }
                }
            }
        }
    }

    private int findMaxCustomer2(int r, int c) {
        int maxCustomer2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int distance = Math.abs(i - r) + Math.abs(j - c);
                if (i == r || j == c) { //첫번째 상권과 같은 행이나 열에 있으면
                    if (distance >= K)
                        maxCustomer2 = Math.max(map[i][j], maxCustomer2);
                } else {
                    if (distance > K)
                        maxCustomer2 = Math.max(map[i][j], maxCustomer2);
                }
            }
        }

        return maxCustomer2;
    }

}
/*
5 2
4개

5 3
3개

5 4
2개


6 2
5개

6 3
4개


250000

 */