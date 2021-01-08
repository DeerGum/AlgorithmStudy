package codingTest.codeforce.round694;

import java.io.*;
import java.util.*;

public class Program_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<S> arr;

        for(int test=0;test<t;test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new ArrayList<>();
            int sum = 0;
            for(int i=0;i<n;i++) {
                int temp = Integer.parseInt(st.nextToken());
                S tempS = new S(temp, 1);
                arr.add(tempS);
                sum += temp;
            }

            int idx = 0;
            while(idx < arr.size()) {
                S temp = arr.get(idx++);
                if(temp.value%x == 0) {
                    int tmp = temp.value/x;
                    sum += (tmp) * ((int)Math.pow(x, temp.r));
                    S next = new S(tmp, temp.r+1);
                    arr.add(next);
                }
                else
                    break;
            }
            bw.write(sum+"\n");
        }
        bw.flush();
    }
}

class S {
    int value;
    int r;

    public S(int value, int r) {
        this.value = value;
        this.r = r;
    }
}
