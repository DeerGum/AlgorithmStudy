package algorithm.BinarySearch;

/**
 * ASCII String to Integer
 * 아스키코드 문자열 숫자로 변환 문제
 * 문제주소 - https://binarysearch.com/problems/ASCII-String-to-Integer
 */
public class StringtoInteger {
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
