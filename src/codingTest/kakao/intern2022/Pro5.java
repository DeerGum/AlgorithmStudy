package codingTest.kakao.intern2022;

public class Pro5 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int R, C;

    public int[][] solution(int[][] rc, String[] operations) {
        R = rc.length;
        C = rc[0].length;

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("Rotate")) {
                rotate(rc);
            } else {
                shiftRow(rc);
            }
        }
        return rc;
    }

    public void rotate(int[][] m) {
        int len = (R * 2 + C * 2) - 4;
        int r = 0;
        int c = 0;
        int curr;
        int prev = m[1][0];
        int d = 0;
        for (int i = 0; i < len; i++) {
            curr = m[r][c];
            m[r][c] = prev;
            if (r + dir[d][0] < 0 || r + dir[d][0] >= R || c + dir[d][1] < 0 || c + dir[d][1] >= C)
                d = (d + 1) % 4;

            r = r + dir[d][0];
            c = c + dir[d][1];

            prev = curr;
        }
    }

    public void shiftRow(int[][] m) {
        int[] prev = m[R-1];
        int[] curr;
        for (int i = 0; i < R; i++) {
            curr = m[i];
            m[i] = prev;
            prev = curr;
        }
    }
}
/*
로테이션은 테두리만 회전된다



 */