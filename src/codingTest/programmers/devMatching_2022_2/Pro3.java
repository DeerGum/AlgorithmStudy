package codingTest.programmers.devMatching_2022_2;

public class Pro3 {
    static int[][] map;
    static int R, C;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int cnt;

    public static void main(String[] args) {
        Pro3 pro3 = new Pro3();

        pro3.solution(5, 6, new int[][]{{2, 2}, {2, 3}, {2, 4}, {3, 2}, {3, 5}, {4, 3}, {4, 4}});

    }

    public int[] solution(int rows, int columns, int[][] lands) {
        map = new int[rows][columns];
        R = rows;
        C = columns;

        for (int i = 0; i < lands.length; i++)
            map[lands[i][0] - 1][lands[i][1] - 1] = 2;

        searchSea(0, 0);

        int max = -1;
        int min = 10000;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0)
                    continue;

                cnt = 0;
                searchLake(i, j);
                max = Math.max(cnt, max);
                min = Math.min(cnt, min);
            }
        }
        int[] answer = new int[2];

        if (max == -1) {
            answer[0] = -1;
            answer[1] = -1;
        } else {
            answer[0] = min;
            answer[1] = max;
        }

        return answer;
    }

    public static void searchSea(int r, int c) {
        map[r][c] = 1;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= R || dc < 0 || dc >= C || map[dr][dc] != 0)
                continue;

            searchSea(dr, dc);
        }
    }

    public static void searchLake(int r, int c) {
        map[r][c] = 3;
        cnt++;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= R || dc < 0 || dc >= C || map[dr][dc] != 0)
                continue;

            searchLake(dr, dc);
        }
    }
}
