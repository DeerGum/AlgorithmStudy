package codingTest.tossbank;

public class Pro1 {
    public static void main(String[] args) {
        Pro1 pro1 = new Pro1();

        System.out.println(Integer.parseInt("08"));
    }
    public int solution(int k, int m, String[] names, int[] amounts) {
        int answer = 0;
        int cnt = 0;
        String prevName = "";
        String currName = "";
        for (int i = 0; i < names.length; i++) {
            currName = names[i].toLowerCase();

            if (prevName.equals(currName))
                cnt++;
            else {
                prevName = currName;
                cnt = 1;
            }

            if (amounts[i] >= m || (prevName.equals(currName) && cnt >= k))
                answer++;

        }
        return answer;
    }
}
