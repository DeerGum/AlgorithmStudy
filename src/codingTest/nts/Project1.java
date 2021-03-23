package codingTest.nts;

import java.io.*;

public class Project1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputString, compareString;

        inputString = br.readLine();
        compareString = br.readLine();

        boolean result = lotationString(inputString,compareString);
        bw.write(result+"\n");
        bw.flush();

    }

    public static boolean lotationString(String str1, String str2) {
        StringBuilder sb = new StringBuilder(str1);

        if (str1.length() != str2.length())
            return false;

        for (int i = 0; i < str1.length(); i++) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            if (sb.toString().equals(str2))
                return true;
        }

        return false;
    }
}
