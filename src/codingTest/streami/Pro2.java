package codingTest.streami;

public class Pro2 {
    public int solution(String S, int[] C) {
        int N = S.length();
        boolean[] isDelete = new boolean[N];

        int cost = 0;
        char prevC = S.charAt(0);
        int prevIdx = 0;
        char currC;
        for (int i = 1; i < N; i++) {
            currC = S.charAt(i);

            if (prevC == currC) {
                if (C[i] < C[prevIdx])
                    cost += C[i];
                else {
                    cost += C[prevIdx];
                    prevIdx = i;
                }
            } else {
                prevC = currC;
                prevIdx = i;
            }
        }

        return cost;
    }
}
