package codingTest.nts;

import java.io.*;

/**
 * 카멜 -> 스네이크
 * 스네이크 -> 카멜
 */
public class Project2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        str = br.readLine();


    }

    public static String stringChange(String str) {
        StringBuilder sb = new StringBuilder(str);

        if (isSnake(str)) { //스네이크 -> 카멜 변환
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '_') {
                    sb.setCharAt(i+1,Character.toUpperCase(sb.charAt(i+1)));
                    sb.deleteCharAt(i);
                }
            }

        }

        else {  //카멜 -> 스네이크 변환 stringBuilder
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isUpperCase(sb.charAt(i))) {
                    sb.setCharAt(i,Character.toLowerCase());
                    String sub = sb.substring(i);
                    sb.delete(i,sb.length()-1);

                    sb.append('_');
                    sb.append(sub);

                }


            }
        }



        return "";
    }

    public static boolean isSnake(String str) {
        if (str.contains("_"))
            return true;
        else
            return false;
    }
}
