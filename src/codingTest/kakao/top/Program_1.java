package codingTest.kakao.top;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {



        }
    }

    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        Arrays.sort(gift_cards);
        Arrays.sort(wants);
        boolean[] isVisited = new boolean[wants.length];

        for (int i = 0; i < isVisited.length; i++)
            isVisited[i] = true;

        int temp;

        for (int i = 0; i < wants.length; i++) {
            temp = bs(gift_cards, isVisited, wants[i]);
            if (temp == -1)
                answer++;
        }

        return answer;
    }

    public int bs(int[] arr, boolean[] isVisited, int x) {
        int mid, low = 0, high = arr.length-1;

        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == x && isVisited[mid]) {
                isVisited[mid] = false;
                return mid;
            }
            else if(arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;  //못찾으면 -1
    }
}
/*
4 5 3 2 1
2 4 4 5 1

1 2 3 4 5
1 2 4 4 5

2 4 10 15 25
3 4 7 10 12 20


 */