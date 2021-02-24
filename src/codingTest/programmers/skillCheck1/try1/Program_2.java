package codingTest.programmers.skillCheck1.try1;

/**
 * 2021 Kakao Blind Recruitment
 * 신규 아이디 추천
 * 문제 링크 https://programmers.co.kr/learn/courses/30/lessons/72410
 */
public class Program_2 {
    public static void main(String[] args) {
        String input = "z-+.^.";
        String result = solution(input);
        System.out.println(result);
    }

    public static String solution(String new_id) {
        int len;

        new_id = new_id.toLowerCase();  //소문자로 변경
        new_id = new_id.replaceAll("[^0-9a-z-_.]+",""); //알파벳 숫자, -, _, . 제외한 문자제거
        new_id = new_id.replaceAll("[..]+",".");    //2번이상 연속된 마침표는 하나로 치환

        if(new_id.charAt(0) == '.') //처음에 . 이 있으면 제거
            new_id = new_id.substring(1);

        len = new_id.length();
        if (len > 0 && new_id.charAt(len-1) == '.') //마지막에 . 이 있으면 제거
            new_id = new_id.replaceFirst(".$","");

        if (new_id.length() == 0)   //빈문자열이면 a를 대입
            new_id = "a";

        if (new_id.length() >= 16) {    //길이가 16자 이상이면 15자로 자름
            new_id = new_id.substring(0,15);
            if (new_id.charAt(new_id.length()-1) == '.')    //만약 자르고 끝에 . 이 남으면 제거
                new_id = new_id.replaceFirst(".$","");
        }

        while(new_id.length() < 3) {    //길이가 2자 이하이면 마지막 문자를 길이가 3이 될때까지 이어 붙임
            new_id += new_id.charAt(new_id.length()-1);
        }

        return new_id;
    }
}
