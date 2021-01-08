package algorithm;

import java.util.Arrays;
import java.util.Random;

public class MatrixChainMultiplication {

    static final int[] MAX_SIZE = {10,15,20,22};
    static final int MAX_NUMBER = 10;
    static final int MAX_VALUE = 9999999;
    static int[][] P;
    static int[][] M;
    static int[] d;
    static Random r = new Random();

    public static void main(String[] args) {
        for(int l=0;l<MAX_SIZE.length;l++) {
            System.out.println("number of matrix's : "+MAX_SIZE[l]);

            P = new int[MAX_SIZE[l]+1][MAX_SIZE[l]+1];
            M = new int[MAX_SIZE[l]+1][MAX_SIZE[l]+1];
            d = new int[MAX_SIZE[l] + 1];

            //배열 랜덤값으로 초기화
            for (int i = 0; i < d.length; i++)
                d[i] = r.nextInt(MAX_NUMBER) + 1;

            double[] delay = new double[2];
            long startTime, endTime;
            startTime = System.currentTimeMillis();
            minMul(MAX_SIZE[l], d, M, P);
            endTime = System.currentTimeMillis();
            delay[0] = (endTime - startTime) / 1000.0;

            startTime = System.currentTimeMillis();
            bfMul(MAX_SIZE[l], d);
            endTime = System.currentTimeMillis();
            delay[1] = (endTime - startTime) / 1000.0;

            System.out.println("DP : "+delay[0]+"s");
            System.out.println("BF : "+delay[1]+"s");
        }
    }

    //무작정 알고리즘 (brute-force), 시간복잡도는 2^n
    public static int bfMul(int n, int[] d) {
        //무작정 알고리즘에 가까운 시간이 걸리도록 만든 의사코드
        int count = 0;
        if(n == 1)
            return 1;
        else if(n>=2){
            for(int k=1;k<n;k++)
                count += bfMul(k,Arrays.copyOfRange(d,0,k)) * bfMul(n-k,Arrays.copyOfRange(d,0,n-k));
        }
        return count;

    }
    //DP를 이용한 연쇄행렬곱셈, 시간복잡도는 n^3
    public static int minMul(int n, int[] d, int[][] M, int[][] P) {
        for(int diagonal=1;diagonal<n;diagonal++) {
            for(int i=1;i<=n-diagonal;i++) {
                int j = i + diagonal;
                M[i][j] = MAX_VALUE;
                for(int k = i;k<=j-1;k++) {
                    int temp = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];
                    if(M[i][j]> temp) {
                        M[i][j] = temp;
                        P[i][j] = k;
                    }
                }
            }
        }
        return M[1][n];
    }

    // 괄호 묶은 후의 행렬 출력(사용하진 않음)
    public static void print(int row, int col) {
        if(row == col)
            System.out.print("A"+row);
        else {
            int k = P[row][col];
            System.out.print("(");
            print(row,k);
            print(k+1,col);
            System.out.print(")");
        }
    }

}
