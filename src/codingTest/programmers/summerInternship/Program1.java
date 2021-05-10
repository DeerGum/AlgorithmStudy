package codingTest.programmers.summerInternship;

import java.util.*;

public class Program1 {
    public int[] solution(String code, String day, String[] data) {
        String price, targetCode, time;
        ArrayList<int[]> result = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < data.length; i++) {

            st = new StringTokenizer(data[i]);
            price = st.nextToken().substring(6);
            targetCode = st.nextToken().substring(5);
            time = st.nextToken().substring(5);

            if(code.equals(targetCode) && day.equals(time.substring(0,8))) {
                result.add(new int[]{Integer.parseInt(time),Integer.parseInt(price)});

            }
        }
        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<Integer> r = new ArrayList<>();
        for(int[] n : result)
            r.add(n[1]);
        return r.stream().mapToInt(i->i).toArray();
    }
}
