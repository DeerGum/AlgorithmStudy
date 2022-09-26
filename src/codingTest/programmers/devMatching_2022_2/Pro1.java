package codingTest.programmers.devMatching_2022_2;

public class Pro1 {
    public static void main(String[] args) {
        Pro1 pro1 = new Pro1();
        pro1.solution(new int[]{3, 2, 3, 6, 4, 5});
    }

    public int solution(int[] grade) {
        int answer = 0;

        int n1, n2;
        for (int i = grade.length - 1; i > 0; i--) {
            n1 = grade[i - 1];
            n2 = grade[i];

            while (n1 > n2) {
                n1--;
                answer++;
            }

            grade[i - 1] = n1;
        }

        return answer;
    }
}

/*
a b 비교

if a > b
    while(a != b)
        a--

5 4 3 6
4 4 3 6
3 3 3 6



 */
