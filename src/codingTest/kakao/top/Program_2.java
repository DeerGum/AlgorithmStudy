package codingTest.kakao.top;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {



        }
    }

    public static int[][] combiR;
    public static ArrayList<int[]> combiTemp;
    public static int R;

    public int solution(int[][] needs, int r) {
        int answer = 0;
        combiTemp = new ArrayList<>();
        R = r;
        boolean[] isVisited = new boolean[R];
        int[] arr = new int[R];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i+1;

        combi(arr,isVisited,0, arr.length, R);
        int[][] combiArr = combiTemp.toArray(new int[combiTemp.size()][R]);

        return answer;
    }

    public static void combi(int[] arr, boolean[] isVisited, int start, int n, int r) {
        if(r == 0) {
            combiSave(arr,isVisited,n);
            return;
        }
        else {
            for(int i = start; i < n; i++) {
                isVisited[i] = true;
                combi(arr, isVisited, i + 1, n, r - 1);
                isVisited[i] = false;
            }
        }
    }

    public static void combiSave(int[] arr, boolean[] isVisited, int n) {
        int[] temp = new int[R];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                temp[index++] = arr[i];
            }
        }
        combiTemp.add(temp);
    }


}
/*
0
0 1
0 1
0 2
0 1
1 2
DP?







 */