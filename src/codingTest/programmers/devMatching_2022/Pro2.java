package codingTest.programmers.devMatching_2022;

import java.util.HashSet;

public class Pro2 {
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int[][] map;
    static int R, C;
    static int answer;
    static int qmCnt;

    public static void main(String[] args) {
        Pro2 pro2 = new Pro2();

        pro2.solution(new String[]{"??b","abc","cc?"});
    }

    public int solution(String[] grid) {

        R = grid.length;

        C = grid[0].length();
        qmCnt = 0;
        map = new int[R][C];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                char c = grid[i].charAt(j);
                if (c == 'a') {
                    map[i][j] = 0;
                } else if (c == 'b') {
                    map[i][j] = 1;
                } else if (c == 'c') {
                    map[i][j] = 2;
                } else {
                    qmCnt++;
                    map[i][j] = -1;
                }
            }
        }

        answer = 0;

        perm(0, new int[qmCnt]);


        return answer;
    }

    public void perm(int cnt, int[] p) {
        if (cnt == qmCnt) {
            int[][] grid = new int[R][C];
            HashSet<Integer> nums = new HashSet<>();
            for (int i = 0, q = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != -1)
                        grid[i][j] = map[i][j];
                    else
                        grid[i][j] = p[q++];
                    nums.add(grid[i][j]);
                }
            }

            boolean[] isCheck = new boolean[3];
            boolean[][] v = new boolean[R][C];
            int count = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!v[i][j]) {
                        count++;
                        dfs(grid, i, j, grid[i][j], v);
                        isCheck[grid[i][j]] = true;
                    }
                }
            }

            if (count == nums.size())
                answer++;

            return;
        }

        for (int i = 0; i < 3; i++) {
            p[cnt] = i;
            perm(cnt + 1, p);
        }

    }


    public void dfs(int[][] grid, int r, int c, int word, boolean[][] v) {
        v[r][c] = true;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= R || dc < 0 || dc >= C || grid[dr][dc] != word || v[dr][dc])
                continue;

            dfs(grid, dr, dc, word, v);
        }
    }


}

/*

19683

 */