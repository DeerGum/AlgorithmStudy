package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 2021 kakao blind recruitment
 * 메뉴 리뉴얼
 * 문제링크 https://programmers.co.kr/learn/courses/30/lessons/72411
 */
public class MenuRenewal {
    HashMap<String, Integer>[] hashMaps;    //메뉴 경우의 수 카운트
    int[] course;
    int[] maxCount; //코스요리 갯수별로 최대값

    public String[] solution(String[] orders, int[] course) {
        hashMaps = new HashMap[course.length];
        for (int i = 0; i < hashMaps.length; i++)
            hashMaps[i] = new HashMap<>();
        this.course = course;
        maxCount = new int[course.length];

        char[] order;

        for (int i = 0; i < orders.length; i++) {   //주문을 알파벳순으로 정렬
            order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
        }

        for (int i = 0; i < orders.length; i++) {   //주문 경우의 수 해쉬맵에 저장
            order = orders[i].toCharArray();
            for (int j = 0; j < course.length; j++) {
                courseCase(order, j, 0, 0,"");
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i=0;i<hashMaps.length;i++) {   //해쉬맵에 저장된 최대 주문값을 갖는 주문을 리스트에 저장
            int finalI = i;
            hashMaps[i].forEach((key, value) -> {
                    if (value == maxCount[finalI]) {
                        result.add(key);
                    }
            });
        }
        String[] answer = result.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }

    public void courseCase(char[] order, int courseIdx, int idx, int size, String str) {
        if (size == course[courseIdx]) { //재귀 탈출조건
            if (hashMaps[courseIdx].containsKey(str)) {
                int count = hashMaps[courseIdx].get(str);
                hashMaps[courseIdx].put(str,count+1);
                if (maxCount[courseIdx] < count+1)
                    maxCount[courseIdx] = count+1;
            }
            else
                hashMaps[courseIdx].put(str,1);
            return;
        }

        if (order.length < course[courseIdx])   //주문 갯수가 코스요리 갯수보다 작으면 리턴
            return;

        StringBuilder sb = new StringBuilder(str);
        for(int i = idx ;i < order.length; i++) {   //경우의 수 계산
            sb.append(order[i]);
            courseCase(order,courseIdx,i+1,size+1,sb.toString());
            sb.deleteCharAt(sb.length()-1);
        }
    }
}