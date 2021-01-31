package codingTest.programmers.skillCheck1.try1;

/**
 * 2021 Kakao Blind Recruitment
 * 신규 아이디 추천
 */
public class Program_2 {
    public static void main(String[] args) {
        String input = "z-+.^.";
        String result = solution(input);
        System.out.println(result);
    }
    public static String solution(String new_id) {
        String answer = "";
        int len = new_id.length();

        new_id = new_id.toLowerCase();  //소문자 치환
        new_id = new_id.replaceAll("[^0-9a-z-_.]+","");
        new_id = new_id.replaceAll("[..]+",".");

        if(new_id.charAt(0) == '.')
            new_id = new_id.substring(1);

        len = new_id.length();
        if (len > 0 && new_id.charAt(len-1) == '.')
            new_id = new_id.replaceFirst(".$","");

        if (new_id.length() == 0)
            new_id = "a";

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0,15);
            if (new_id.charAt(new_id.length()-1) == '.')
                new_id = new_id.replaceFirst(".$","");
        }

        while(new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length()-1);
        }

        return new_id;
    }
}
