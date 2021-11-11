package codingTest.nhn.commerce_2021;

import java.io.*;
import java.util.*;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String curr = br.readLine();
        int size = 0;
        int cnt = 1;
        String next;
        StringBuilder sb = new StringBuilder();
        boolean isPop = false;
        for (int i = 1; i < n; i++) {
            next = br.readLine();
            if (curr.equals(next)) {    //같으면
                cnt++;
            } else {    //다르면
                if (cnt == 1) { //이전꺼 출력
                    sb.append(curr + "\n");
                }
                else {
                    sb.append(curr + " (" + cnt + ")\n");
                }
                    size++;
                curr = next;
                cnt = 1;
            }
        }

        if (cnt == 1)
            sb.append(curr + "\n");
        else
            sb.append(curr + " (" + cnt + ")\n");
        size++;

        bw.write(size+"\n");
        bw.write(sb.toString());



        bw.close();
    }
}

/*
10
SMS 010-1234-5678
CALL 010-1234-5678
CALL 010-1234-5678
SMS 010-1111-1111
SMS 010-5555-5555
CALL 010-5555-5555
CALL 010-5555-5555
CALL 010-4444-4444
SMS 010-5555-5555
SMS 010-5555-5555


 */