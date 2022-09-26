package codingTest.programmers.devMatching_2022_2;

public class Pro2 {
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};    //좌 상 우 하

    public int[][] solution(int n, boolean horizontal) {
        map = new int[n][n];
        int cnt = 1;
        map[0][0] = cnt++;
        
        if (horizontal)
            cleaning(0, 1, horizontal, cnt);
        else
            cleaning(1, 0, !horizontal, cnt);
        
        
        
        

        return map;
    }

    public void cleaning(int r, int c, boolean isHorizontal, int cnt) {
        int max = Math.max(r, c);
        map[r][c] = cnt;
        
        int dr, dc;
        if (isHorizontal) {
            if (c == max) {

            }
        } else {
            
        }
    }
}

/*
0, 0

0, 1

0 ~ 1



 */