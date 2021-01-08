package codingTest.codeforce.round692;

import java.io.*;

public class Program_2 {
    public static long maxNum;
    public static String str;
    public static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++) {
             str = br.readLine();
            num = new int[str.length()];
            long n = Long.parseLong(str);
            maxNum = n;

            for(int j=0;j<num.length;j++) {
                num[j] = Character.getNumericValue(str.charAt(j));
            }
            fair(n);

            bw.write(maxNum+"");
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    public static void fair(long n) {
        int i = 0;
        long number = n;
        while(i<num.length) {
            if(num[i] == 0) {
                i++;
                continue;
            }
            if(number%num[i] != 0) {
                number++;
                str = String.valueOf(number);
                for(int j=0;j<num.length;j++) {
                    num[j] = Character.getNumericValue(str.charAt(j));
                }
                i=0;
                continue;
            }
            i++;
        }
        if(maxNum < number)
            maxNum = number;
    }
}
