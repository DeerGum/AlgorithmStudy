package codingTest.kakao.recruit2023;

public class Pro2 {

    public static void main(String[] args) {
        Pro2 pro2 = new Pro2();
        pro2.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
    }

    static int maxDeliLen;
    static int maxPickLen;
    static int deliCnt;
    static int pickCnt;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        maxDeliLen = n - 1;
        maxPickLen = n - 1;
        deliCnt = 0;
        pickCnt = 0;
        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i] > 0)
                deliCnt += deliveries[i];

            if (pickups[i] > 0)
                pickCnt += pickups[i];
        }

        while (deliCnt > 0 || pickCnt > 0) {
            int move = getMaxLen();
            if (deliCnt > 0) {
                delivery(cap, move, deliveries);
            }

            if (pickCnt > 0) {
                pickup(cap, move, pickups);
            }

            answer += (move + 1) * 2;
        }

        return answer;
    }

    public void delivery(int cap, int maxLen, int[] deliveries) {
        for (int i = maxLen; i >= 0; i--) {
            if (deliveries[i] > 0) {
                if (deliveries[i] >= cap) {
                    deliveries[i] -= cap;
                    deliCnt -= cap;
                    cap = 0;

                } else {
                    cap -= deliveries[i];
                    deliCnt -= deliveries[i];
                    deliveries[i] = 0;
                }
            }

            if (cap == 0) {
                if (deliveries[i] > 0) {
                    maxDeliLen = i;
                    break;
                }
            }
        }

    }

    public void pickup(int cap, int maxLen, int[] pickups) {
        for (int i = maxLen; i >= 0; i--) {
            if (pickups[i] > 0) {
                if (pickups[i] >= cap) {
                    pickups[i] -= cap;
                    pickCnt -= cap;
                    cap = 0;
                } else {
                    cap -= pickups[i];
                    pickCnt -= pickups[i];
                    pickups[i] = 0;
                }
            }

            if (cap == 0) {
                if (pickups[i] > 0) {
                    maxPickLen = i;
                    break;
                }
            }
        }

    }

    public int getMaxLen() {
        return (maxDeliLen > maxPickLen) ? maxDeliLen : maxPickLen;
    }

}
/*




 */