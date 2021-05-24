package codingTest.programmers.month_5;

public class Program_2 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        long num;
        long xor;
        long count;
        for (int i = 0; i < numbers.length; i++) {
            num = numbers[i];
            for (long j = num+1; j <= Long.MAX_VALUE; j++) {
                xor = num ^ j;
                count = countBit(xor);
                if(count <= 2) {
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }

    public long countBit(long num) {
        long count = 0;
        while(num > 0) {
            num &= num - 1;
            count++;
            if(count > 2)
                return 9999;
        }
        return count;
    }
}
