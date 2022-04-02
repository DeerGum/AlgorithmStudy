package codingTest.gabia;

public class Pro4 {
    public int solution(int[] estimates, int k) {
        int temp = 0;
        for (int i = 0; i < k; i++)
            temp += estimates[i];

        int answer = temp;

        for (int i = k; i < estimates.length; i++) {
            temp -= estimates[i - k];
            temp += estimates[i];

            answer = Math.max(temp, answer);
        }

        return answer;
    }
}
