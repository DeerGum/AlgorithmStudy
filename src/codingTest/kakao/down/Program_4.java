package codingTest.kakao.down;

import java.io.*;
import java.util.Arrays;

public class Program_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Program_4 p = new Program_4();
        int[] temp = p.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        System.out.println(Arrays.toString(temp));
    }

    static int[] point = {10,9,8,7,6,5,4,3,2,1,0};
    static int maxPoint;
    static int[] result;
    static int N;
    static int[] apeach;
    public int[] solution(int n, int[] info) {

        maxPoint = 0;
        N = n;
        apeach = info;
        result = new int[]{-1};
        shot(0,0,new int[11]);
        return result;
    }

    public void shot(int cnt, int start, int[] ryan) {
        if (N == cnt) {
            int ryanPoint = calPointRyan(ryan);
            int apeachPoint = calPointApeach(ryan);
            if (ryanPoint > apeachPoint && ryanPoint >= maxPoint) {
                maxPoint = ryanPoint;
                result = ryan.clone();
            }
            return;
        }

        for (int i = start; i < point.length; i++) {
            if (apeach[i] < ryan[i])
                continue;

            ryan[i]++;
            shot(cnt+1,0,ryan);
            ryan[i]--;
        }
    }

    public int calPointRyan(int[] target) {
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] != 0 && apeach[i] < target[i])
                sum += point[i];
        }
        return sum;
    }

    public int calPointApeach(int[] target) {
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            if (apeach[i] != 0 && apeach[i] >= target[i])
                sum += point[i];
        }
        return sum;
    }

}
