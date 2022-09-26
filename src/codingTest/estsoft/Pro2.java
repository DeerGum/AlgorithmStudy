package codingTest.estsoft;

import java.util.LinkedList;
import java.util.Queue;

public class Pro2 {
    public int[] solution(int[] queue) {
        Queue<Integer> q = new LinkedList<>();
        int[] nums = new int[4];
        int same = queue.length / 3;

        for (int i = 0; i < queue.length; i++) {
            q.add(queue[i]);
            nums[queue[i]]++;
        }

        int[] answer = new int[3];

        while (true) {
            int peek = q.peek();
            int next = minNum(nums, same);
            if (next == 0)
                break;

            if (nums[peek] <= same) {
                q.poll();
                q.add(peek);
                answer[peek - 1]++;
            } else {
                q.poll();
                q.add(next);
                nums[peek]--;
                nums[next]++;
                answer[next - 1]++;
            }
        }

        return answer;
    }

    private int minNum(int[] nums, int same) {
        int num = 0;
        int cnt = 300001;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < cnt) {
                num = i;
                cnt = nums[i];
            }
        }
        if (cnt == same)
            return 0;
        else
            return num;
    }
}
/*
1 3 2 2 2 2

3 2 2 2 2 3
2 2 2 2 3 3
2 2 2 3 3 1
2 2 3 3 1 1

2 2 1 3 2 2

2 1 3 2 2 1
1 3 2 2 1 3


 */