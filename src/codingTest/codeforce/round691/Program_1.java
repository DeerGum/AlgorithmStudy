package codingTest.codeforce.round691;

import java.io.*;

public class Program_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int[][] cards;

        int[] values;
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(br.readLine());
            cards = new int[2][n];
            values = new int[n];
            String str;
            for(int j=0;j<2;j++) {
                str = br.readLine();
                for(int k=0;k<n;k++) {
                    cards[j][k] = Character.getNumericValue(str.charAt(k));
                }
            }

            int redWin = 0;
            int blueWin = 0;

            for(int j=0;j<n;j++) {
                values[j] = cards[0][j] - cards[1][j];
                if(values[j] > 0)
                    redWin++;
                else if(values[j] < 0)
                    blueWin++;
            }


            if(redWin > blueWin)
                bw.write("RED");
            else if (redWin == blueWin)
                bw.write("EQUAL");
            else
                bw.write("BLUE");
            bw.newLine();
        }
        bw.flush();
    }
}
