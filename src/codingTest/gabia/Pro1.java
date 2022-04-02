package codingTest.gabia;

public class Pro1 {
    public int solution(int mod1, int mod2, int max_range) {
        int modResult = max_range / mod1;
        int lcm = lcm(mod1, mod2);

        int answer = modResult - (max_range / lcm);

        return answer;    //mod1이 mod2의 배수인 경우 0
    }

    private int gcd(int n1, int n2) {
        while (n2 != 0) {
            int temp = n1 % n2;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }

    private int lcm(int n1, int n2) {
        return n1 * n2 / gcd(n1, n2);
    }
}
/*
4 3 20

20/4 = 5
20/3 = 6

8 4

4 8

12 4




 */