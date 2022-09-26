package codingTest.kakao.recruit2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pro1 {

    public static void main(String[] args) {
        Pro1 pro1 = new Pro1();

        pro1.solution("2022.05.19",new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});

    }
    static final int MAX_MONTH = 12;
    static final int MAX_DAY = 28;
    static HashMap<Character, Integer> types;

    public int[] solution(String today, String[] terms, String[] privacies) {
        Date todayDate = new Date(today);
        types = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i]);
            char type = st.nextToken().charAt(0);
            int month = Integer.parseInt(st.nextToken());
            types.put(type, month);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            String date = st.nextToken();
            char type = st.nextToken().charAt(0);

            Date curr = new Date(date);
            curr.addPeriod(type);
            if (curr.isExpired(todayDate)) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    static class Date {
        public int year;
        public int month;
        public int day;

        public Date(String date) {
            this.year = Integer.parseInt(date.substring(0, 4));
            this.month = Integer.parseInt(date.substring(5, 7));
            this.day = Integer.parseInt(date.substring(8));
        }

        public void addPeriod(char type) {
            int addM = types.get(type);
            this.month += addM;

            if (this.month > MAX_MONTH) {   //12월 넘어가면
                this.year += this.month / MAX_MONTH;
                this.month %= MAX_MONTH;
            }

            if (this.day == 1) {
                this.day = MAX_DAY;
                this.month--;
            } else
                this.day--;

        }

        public boolean isExpired(Date today) {
            if (this.year < today.year) //오늘날짜보다 년도가 작으면
                return true;

            if (this.month < today.month) //오늘날짜보다 월이 작으면
                return true;

            if (this.day < today.day)   //오늘날짜보다 일이 작으면
                return true;

            return false;
        }
    }
}



/*
11 + 26 = 37
37 / 12 = 1

today 2022.05.19

this 2022.05.18

7 + 20 = 27
*/
