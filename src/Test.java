import java.math.BigInteger;
import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        String[] temp = {"ABC","BCDE","BDE","CDEFG","ACDS"};
        String temp2 = "ASDF";
        Arrays.sort(temp);
        int n = 3;
        

        System.out.println(temp2.substring(0,4));

    }
    public static void test(String str) {
        str = "hello";
    }

    public int solve(String s) {
        int result = 0;
        boolean prevNum = false;
        int first = -1;
        int end = -1;
        for(int i=0;i<s.length();i++) {
            char c =s.charAt(i);
            if (Character.isDigit(c)) {
                if (!prevNum) {
                    first = i;
                    prevNum = true;
                }
                end = i;
            }
            else {
                if (prevNum) {
                    prevNum = false;
                    result += Integer.parseInt(s.substring(first,end+1));
                }
            }
        }
        if (prevNum) {
            prevNum = false;
            result += Integer.parseInt(s.substring(first,end+1));
        }

        return result;
    }

}

/*
1 = 1
2 = 8
3 = 27
4 = 64
5 = 125
6 = 216


 */