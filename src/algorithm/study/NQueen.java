package algorithm.study;

import java.io.*;

public class NQueen {
    public static int n;
    public static int count;
    public static int[] board;
    public static char[][] tree;
    public static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        board = new int[n];
        tree = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                tree[i][j] = ' ';
            }
        }

        count = 0;
        
        for(int i=0;i<n;i++) {
            board[0] = i;
            tree = new char[n][n];
            tree[0][i] = 'O';
            queen(1);
        }
        bw.flush();

    }

    public static void queen(int r) throws IOException {
        if(r == n) {
            count++;
            if(count<3) //2개만 출력함
                printTree(count);
            return;
        }
        for(int i=0;i<n;i++) {
            board[r] = i;
            if(isPromising(r)) {    //유효성 판단
                tree[r][i] = 'O';
                queen(r+1);
            }
            tree[r][i] = 'X';
            
        }
        //탐색 끝나면 배열 공백으로 다시 되돌림
        for(int i=0;i<n;i++) 
            tree[r][i] = ' ';
        
    }
    public static boolean isPromising(int c) {
        for(int i=0;i<c;i++) {
            //같은 열에 위치하거나 같은 대각선상에 있으면 false
            if(board[i] == board[c] || Math.abs(i-c) == Math.abs(board[i]-board[c]))
                return false;
        }
        return true;
    }

    public static void printTree(int count) throws IOException {
        bw.write(count+"번째 해답\n");
        for(int i=0;i<n;i++) {
            bw.write("[ ");
            for(int j=0;j<n;j++) {
                bw.write(tree[i][j]);
            }
            bw.write(" ]\n");
        }
        bw.write("\n");
    }
}