package codingTest.programmers.summerIntern2022;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pro2 {
    static HashMap<String,String> person;
    static HashMap<String,String> roomOwners;
    public String[] solution(String[] rooms, int target) {
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m;
        for (int i = 0; i < rooms.length; i++) {
            String str = rooms[i];
            m = p.matcher(str);
            System.out.println(m.group());
        }


        String[] answer = {};

        return answer;
    }

    public String[] parser(String str) {



        return null;
    }
}
