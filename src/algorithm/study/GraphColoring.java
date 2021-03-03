package algorithm.study;

import java.io.*;

public class GraphColoring {
    public static int n = 5;
    public static int m = 3;
    public static int count = 0;
    public static boolean[][] W;//노트의 연결 유무를 저장하는 배열
    public static char[] color; //색깔의 이름을 저장하는 배열
    public static int[] vColor; //색깔을 매칭한 결과 배열
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        color = new char[m];
        vColor = new int[n];
        for(int i=0;i<n;i++)
            vColor[i] = -1;

        color[0] = 'R'; //빨강
        color[1] = 'Y'; //노랑
        color[2] = 'W'; //하양
        
        W = new boolean[n][n];
        //노드간 연결 유무 설정
        W[0][1] = W[0][3] = true;
        W[1][0] = W[1][2] = W[1][4] = true;
        W[2][1] = W[2][4] = true;
        W[3][0] = W[3][4] = true;
        W[4][1] = W[4][2] = W[4][3] = true;

        for(int i=0;i<m;i++) {
            vColor[0] = i;
            coloring(0);
        }
        
        bw.write(count+"\n");
        bw.flush();
    }

    public static void coloring(int i) throws IOException {
        if(isPromising(i)) {
            if(i == n-1) {
                for(int j=0;j<n;j++)
                    bw.write(color[vColor[j]]+" ");
                bw.newLine();
                count++;
            }
            else {
                for(int j =0;j<m;j++) {
                    vColor[i+1] = j;
                    coloring(i+1);
                }
            }
        }
    }

    public static boolean isPromising(int i) {
        int j = 0;
        while(j < i) {
            if(W[i][j] && vColor[i] == vColor[j])
                return false;
            j++;
        }
        return true;
    }
}
