package codingTest.programmers.grap;

import java.util.*;

public class Program2_2 {

    public static void main(String[] args) {
        Program2_2 p = new Program2_2();
        p.solution(new String[]{"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"});
    }
    class Grade implements Comparable<Grade>{
        public String grade;
        public int n;
        public Grade(String grade, int n){
            this.grade = grade;
            this.n = n;
        }

        @Override
        public int compareTo(Grade o) {
            if (gradeOrder.get(this.grade) < gradeOrder.get(o.grade))
                return -1;
            else if (gradeOrder.get(this.grade) == gradeOrder.get(o.grade))
                return this.n - o.n;
            else
                return 1;
        }
    }
    static Map<String, Grade> gradeMap;
    static Map<String, Integer> gradeOrder;
    static String[] gradeTable = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D+","D0","D-","F"};

    public String[] solution(String[] grades) {
        String[] answer = {};
        StringTokenizer st;
        gradeMap = new LinkedHashMap<>();
        gradeOrder = new LinkedHashMap<>();
        for (int i = 0; i < gradeTable.length; i++)
            gradeOrder.put(gradeTable[i], i);

        for (int i = 0; i < grades.length; i++) {
            st = new StringTokenizer(grades[i]);
            String id = st.nextToken();
            String getGrade = st.nextToken();
            if (!gradeMap.containsKey(id)) {   //학정번호가 해쉬맵에 없으면
                gradeMap.put(id,new Grade(getGrade, i));
            } else {    //학정번호가 이미 해쉬맵에 있으면
                gradeMap.put(id, new Grade(maxGrade(gradeMap.get(id).grade ,getGrade), gradeMap.get(id).n)); //높은 성적 삽입
            }

        }

        answer = new String[gradeMap.size()];
        List<Map.Entry<String, Grade>> entries = new LinkedList<>(gradeMap.entrySet());
        Collections.sort(entries, (o1,o2) -> o1.getValue().compareTo(o2.getValue()) );

        int idx = 0;
        for (Map.Entry<String, Grade> entry : entries) {
            answer[idx++] = entry.getKey()+" "+entry.getValue().grade;
        }

        return answer;
    }

    public String maxGrade(String grade1, String grade2) {
        if (gradeOrder.get(grade1) <= gradeOrder.get(grade2))
            return grade1;
        else
            return grade2;
    }
}


