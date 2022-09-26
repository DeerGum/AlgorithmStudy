package codingTest.kakao.intern2022;

import java.util.LinkedList;
import java.util.Queue;

public class Pro2 {

//    public static void main(String[] args) {
//        Pro2 p = new Pro2();
//        p.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
//    }

    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int N = queue1.length;
        for (int i = 0; i < N; i++) {
            sum1 += queue1[i];
            q1.add(queue1[i]);
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }
        if ((sum1 + sum2) % 2 == 1)
            return -1;

        int answer = 0;
        while (answer <= 700000) {
            if (sum1 == sum2)
                return answer;
            else if (sum1 < sum2) {
                if (q2.isEmpty())
                    break;
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.poll());
                answer++;
            } else {
                if (q1.isEmpty())
                    break;
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q2.add(q1.poll());
                answer++;
            }
        }

        return -1;
    }
}
/*

1 2 1 2 = 6
1 10 1 2 = 14

1 2 1 2 1 = 7
10 1 2 = 13

1 2 1 2 1 10 = 17
1 2 = 3

2 1 2 1 10 = 16
1 2 1 = 4

1 2 1 10 = 14
1 2 1 2 = 6

2 1 10 = 13
1 2 1 2 1 = 7




 */