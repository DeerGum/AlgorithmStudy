package codingTest.programmers.grap;

import java.util.*;

public class Program2 {
    static Map<String, String> grade;
    static Map<String, Integer> gradeOrder;
    static String[] gradeTable = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D+","D0","D-","F"};

    public static void main(String[] args) {
        Program2 p = new Program2();
        p.solution(new String[]{"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"});
    }

    public String[] solution(String[] grades) {
        String[] answer = {};
        StringTokenizer st;
        grade = new LinkedHashMap<>();
        gradeOrder = new LinkedHashMap<>();
        for (int i = 0; i < gradeTable.length; i++)
            gradeOrder.put(gradeTable[i], i);

        for (int i = 0; i < grades.length; i++) {
            st = new StringTokenizer(grades[i]);
            String id = st.nextToken();
            String getGrade = st.nextToken();
            if (!grade.containsKey(id)) {   //학정번호가 해쉬맵에 없으면
                grade.put(id,getGrade);
            } else {    //학정번호가 이미 해쉬맵에 있으면
                grade.put(id, maxGrade(grade.get(id),getGrade));    //높은 성적 삽입
            }

        }

        answer = new String[grade.size()];
        List<Map.Entry<String, String>> entries = new LinkedList<>(grade.entrySet());
        Collections.sort(entries, (o1,o2) -> compare(o1.getValue(), o2.getValue()) );

        int idx = 0;
        for (Map.Entry<String, String> entry : entries) {
            answer[idx++] = entry.getKey()+" "+entry.getValue();
        }

        return answer;
    }

    public String maxGrade(String grade1, String grade2) {
        if (gradeOrder.get(grade1) <= gradeOrder.get(grade2))
            return grade1;
        else
            return grade2;
    }

    public int compare(String grade1, String grade2) {
        if (gradeOrder.get(grade1) < gradeOrder.get(grade2))
            return -1;
        else
            return 1;
    }
}
