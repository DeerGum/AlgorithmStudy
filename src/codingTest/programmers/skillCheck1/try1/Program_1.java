package codingTest.programmers.skillCheck1.try1;

public class Program_1 {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        if(len == 4 || len == 6) {
            for(int i=0;i<len;i++) {
                if(!Character.isDigit(s.charAt(i)))
                    answer = false;
            }
        }
        else
            answer = false;

        return answer;
    }

}
