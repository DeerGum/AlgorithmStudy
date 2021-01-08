package codingTest.codeforce.round693;

import java.io.*;
import java.util.StringTokenizer;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int w, h, n;
        int parsingPaper;
        for(int l=0;l<t;l++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            parsingPaper = 1;

            while(true) {
                if(w%2 == 0) {
                    parsingPaper *= 2;
                    w /= 2;
                }
                else if(h%2 == 0) {
                    parsingPaper *= 2;
                    h /= 2;
                }
                else {
                    break;
                }
            }

            if(parsingPaper >= n)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();

    }
}
