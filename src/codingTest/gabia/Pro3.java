package codingTest.gabia;

public class Pro3 {
    public static void main(String[] args) {
        Pro3 pro3 = new Pro3();

        int result = pro3.solution(new int[]{2,5,3,8,1}, 3, 11);
        System.out.println(result);
    }

    private static int K, T;
    private static int result;
    private static int[] array;

    public int solution(int[] arr, int k, int t) {
        K = k;
        T = t;
        result = 0;
        array = arr;

        combi(0, new boolean[array.length], 0);

        return result;
    }

    public void combi(int cnt, boolean[] v, int idx) {
        if (idx == array.length) {
            if (cnt >= K) {
                int sum = 0;
                for (int i = 0; i < array.length; i++) {
                    if (v[i])
                        sum += array[i];

                }

                if (sum <= T)
                    result++;
            }

            return;
        }

        v[idx] = true;
        combi(cnt + 1, v, idx + 1);

        v[idx] = false;
        combi(cnt, v, idx + 1);
    }
}
