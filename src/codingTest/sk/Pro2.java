package codingTest.sk;

import java.util.Arrays;

public class Pro2 {
    public static void main(String[] args) {
        Pro2 pro2 = new Pro2();
        int[][] test = pro2.solution(5, true);

        for (int[] arr : test) {
            System.out.println(Arrays.toString(arr));
        }


    }
    static int[][] clockDir = {{0,1},{1,0},{0,-1},{-1,0}};  //오른쪽 아래 왼쪽 위
    static int[][] rClockDir = {{1,0},{0,1},{-1,0},{0,-1}}; //아래 오른쪽 위 왼쪽
    static int[][] map;
    static int N;
    public int[][] solution(int n, boolean clockwise) {
        int d, cnt;
        map = new int[n][n];
        N = n;
        if(n == 1)
            map[0][0] = 1;
        else if(clockwise) {
            search(0,0,clockDir,0,1,1,n-1);
            search(0,n-1,clockDir,1,1,1,n-1);
            search(n-1,n-1,clockDir,2,1,1,n-1);
            search(n-1,0,clockDir,3,1,1,n-1);
        } else {
            search(0,0,rClockDir,0,1,1,n-1);
            search(n-1,0,rClockDir,1,1,1,n-1);
            search(n-1,n-1,rClockDir,2,1,1,n-1);
            search(0,n-1,rClockDir,3,1,1,n-1);
        }

        return map;
    }

    public void search(int r, int c, int[][] dir, int d, int num, int cnt, int moveMax) {
        map[r][c] = num;

        if(N%2 == 0) {  //N이 짝수일 때
            if((r == N/2-1 || r == N/2) && (c == N/2-1 || c == N/2))
                return;

        } else {    //N이 홀수일 때
            if(r == N/2 && c == N/2)
                return;
        }

        int dr, dc;
        if(cnt == moveMax) {
            int nextD = (d+1) % 4;
            dr = r + dir[nextD][0];
            dc = c + dir[nextD][1];
            int nextMoveMax = (moveMax - 2 > 0)? moveMax - 2 : 1;
            search(dr, dc, dir, nextD, num+1, 1, nextMoveMax);
        } else {
            dr = r + dir[d][0];
            dc = c + dir[d][1];

            search(dr, dc, dir, d, num+1, cnt+1, moveMax);
        }
    }
}
