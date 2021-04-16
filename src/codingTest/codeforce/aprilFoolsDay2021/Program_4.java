package codingTest.codeforce.aprilFoolsDay2021;

import java.io.*;
import java.util.StringTokenizer;

public class Program_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n1, n2;
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());

        int result = n1 / n2;
        boolean isYes = true;
        if (result == 0)
            isYes = true;
        else if (result % 2 == 0)
            isYes = true;
        else
            isYes = false;

        if (isYes)
            bw.write("YES\n");
        else
            bw.write("NO\n");
        bw.flush();
    }
}
/*
2 / 3 = 0
Y

3 / 2 = 1
N

33 / 16 = 2
Y

26 / 5 = 5
N

 */