package codingTest.codeforce.round700;

import java.io.*;
import java.util.StringTokenizer;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int A, H, n;
        int[] a, h;
        StringTokenizer st, st2;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            a = new int[n];
            h = new int[n];

            st = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
                h[j] = Integer.parseInt(st2.nextToken());
            }
            int temp, count;
            boolean isFinish = false;
            boolean allKill = true;
            boolean save = false;
            int[] saveM = new int[2];
            for (int j = 0; j < n; j++) {
                if (j == n-1)
                    isFinish = true;

                count = (h[j]%A == 0)? h[j]/A : h[j]/A+1;

                if (!isFinish && a[j]*count >= H) { //마지막 몬스터 이전에 죽으면
                    if (!save) {
                        saveM[0] = a[j];
                        saveM[1] = h[j];
                        save = true;
                        continue;
                    }

                    allKill = false;
                    break;
                }

                if (isFinish && a[j]*count >= H) {  //마지막에 몬스터한테 죽으면
                    temp = (H%a[j] == 0)? H/a[j] : H/a[j]+1;
                    if (count > temp)
                        allKill = false;
                    break;
                }

                H -= a[j]*count;
            }
            if (save && !allKill) {
                count = (saveM[1]%A == 0)? saveM[1]/A : saveM[1]/A+1;
                if (saveM[0]*count >= H) {
                    temp = (H%saveM[0] == 0)? H/saveM[0] : H/saveM[0]+1;
                    if (count > temp)
                        allKill = false;
                }
            }

            if (allKill)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
    }
}

/*
1
200 11 2
100 4
10 10

 */
