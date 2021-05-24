package codingTest.hackerrank.talentinum;

public class Program_1 {
    public static void main(String[] args) {
        System.out.println(ways(842,91));
    }
    /*
     * Complete the 'ways' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER total
     *  2. INTEGER k
     */
    public static int[] dp;
    public static int ways(int total, int k) {
        // Write your code here
        dp = new int[total+1];

        dp[0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(i <= j) {
                    dp[j] = (dp[j] + dp[j-i]) % 1000000007;
                }
            }
        }

        return dp[total];
    }
}
