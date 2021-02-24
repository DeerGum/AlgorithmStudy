package codingTest.codeforce.round700;

import java.io.*;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuffer temp;
        for (int i = 0; i < t; i++) {
            temp = new StringBuffer(br.readLine());
            boolean isAlice = true;
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if(isAlice) {
                    if(ch == 'a')
                        ch = 'b';
                    else
                        ch = 'a';
                }
                else {
                    if(ch == 'z')
                        ch = 'y';
                    else
                        ch = 'z';
                }
                temp.setCharAt(j,ch);
                isAlice = !isAlice;
            }

            bw.write(temp.toString()+"\n");
        }
        bw.flush();
    }
}
