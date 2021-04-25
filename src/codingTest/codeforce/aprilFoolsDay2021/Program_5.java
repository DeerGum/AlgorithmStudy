package codingTest.codeforce.aprilFoolsDay2021;

import java.io.*;
import java.util.StringTokenizer;

public class Program_5 {
    public static char[][] map;
    public static int[][] dir = {{1,0},{0,1}};
    public static int berry = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        String temp;
        int h,w;
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        
        for (int i = 0; i < h; i++) {
            temp = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        dfs(0,0);
        bw.write(berry+"\n");
        bw.flush();

    }

    public static void dfs(int row, int col) {
        if (row == map.length-1 && col == map[row].length - 1)
            return ;

        if (map[row][col] == '*')
            berry++;


        int r1 = row+dir[0][0];
        int c1 = col+dir[0][1];
        int r2 = row+dir[1][0];
        int c2 = col+dir[1][1];

        boolean isPass1 = true;
        boolean isPass2 = true;

        if (r1 >= map.length || r1 < 0 || c1 < 0 || c1 >= map[r1].length)
            isPass1 = false;
        if (r2 >= map.length || r2 < 0 || c2 < 0 || c2 >= map[r2].length)
            isPass2 = false;

        if (isPass1) {
            if (map[r1][c1] == '*') {
                dfs(r1,c1);
            }
            else if (isPass2) {
                dfs(r2,c2);
            }
            else
                dfs(r1,c1);
        }
        else {
            if (isPass2)
                dfs(r2,c2);
        }

    }
}
