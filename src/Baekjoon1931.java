import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Baekjoon1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            arr[t][0] = Integer.parseInt(st.nextToken());
            arr[t][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b) -> {
            if (a[1] == b[1])        //종료시간이 같으면 
                return a[0] - b[0]; //시작지점 정렬
            return a[1] - b[1];
        }); //람다함수 형식으로 comparator 전달

        int prevTime = arr[0][1];
        int count = 1;
        for (int i=1;i<n;i++) {
            if(prevTime <= arr[i][0]) { //이전 종료시간이 현재 시작시간보다 작거나 같을 경우
                prevTime = arr[i][1];   //이전 종료시간 업데이트
                count++;    //회의실 배정
            }
        }

        bw.write(count+"\n");
        bw.flush();
    }
}