package codingTest.nhn.game_2021;

import java.io.*;
import java.util.*;

public class Program2 {
    static int[][] map;
    static int N;
    static int time;
    static int mid;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        time = 1;
        mid = N/2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    map[i][j] = -1;
            }
        }

        bfs();

        System.out.println(map[N-1][N-1]);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[N][N];
        q.offer(new int[] {0, 0, 0});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] t = q.poll();
            if (!hasMove(t[0],t[1],t[2])) {
                t[2]++;
                q.offer(t);
                continue;
            }
            map[t[0]][t[1]] = t[2];

            for (int i = 0; i < dir.length; i++) {
                int dr = t[0] + dir[i][0];
                int dc = t[1] + dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] == -1 || v[dr][dc])
                    continue;

                q.offer(new int[]{dr, dc, t[2] + 1});
                v[dr][dc] = true;
            }

        }
    }

    public static boolean hasMove(int r, int c, int currTime) {
        int cctv = currTime % 4;

        if (r > mid) {
            if (c > mid) {  // 오른쪽 아래
                if (cctv == 2)
                    return false;
            } else if (c < mid) {   // 왼쪽 아래
                if (cctv == 3)
                    return false;
            }
        } else if (r < mid) {
            if (c > mid) {  //오른쪽 위
                if (cctv == 1)
                    return false;
            } else if (c < mid) {   //왼쪽 위
                if (cctv == 0)
                    return false;
            }
        }
        return true;
    }
}
