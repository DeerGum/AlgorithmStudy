package codingTest.codeforce.aprilFoolsDay2021;

import java.io.*;

public class Program_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean isFibo = true;
        if (str.length() < 3)
            isFibo = true;
        else {
            char c1,c2;
            char temp;
            for (int i = 2; i < str.length(); i++) {
                c1 = str.charAt(i-2);
                c2 = str.charAt(i-1);
                temp = ((c1 + c2 - 65) < 91)?(char)(c1 + c2 - 65):(char)(c1 + c2 -91);
                if (temp != str.charAt(i)) {
                    isFibo = false;
                    break;
                }
            }
        }
        if (isFibo)
            bw.write("YES\n");
        else
            bw.write("NO\n");
        bw.flush();

    }
}

/*
A B C D E F G H I J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
0 1 2 3 4 5 6 7 8 9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

220 - 97 = 123
123 - 26 = 97

 */


