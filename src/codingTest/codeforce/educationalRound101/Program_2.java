package codingTest.codeforce.educationalRound101;

import java.io.*;
import java.util.StringTokenizer;

public class Program_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int r, b;
        int rIdx, bIdx;
        int max;
        int[] red, blue, seq;
        StringTokenizer st;


        for(int len =0;len<t;len++) {
            r = Integer.parseInt(br.readLine());
            rIdx = 0;
            red = new int[r];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<r;i++)
                red[i] = Integer.parseInt(st.nextToken());

            b = Integer.parseInt(br.readLine());
            bIdx = 0;
            blue = new int[b];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<b;i++)
                blue[i] = Integer.parseInt(st.nextToken());

            seq = new int[r+b];

            for(int i=0;i<r+b;i++) {
                if(rIdx >= r)
                    seq[i] = blue[bIdx++];
                else if(bIdx >= b)
                    seq[i] = red[rIdx++];
                else if(red[rIdx] > blue[bIdx]) {
                    seq[i] = red[rIdx++];
                }
                else {
                    seq[i] = blue[bIdx++];
                }
            }

            int temp = seq[0];
            max = Math.max(0, temp);
            for(int i=1;i<r+b;i++) {
                temp += seq[i];
                max = Math.max(max, temp);
            }

            bw.write(max+"\n");
        }
        bw.flush();
    }
}
