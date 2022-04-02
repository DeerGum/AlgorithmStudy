package codingTest.gabia;

public class Pro5 {
    public int solution(int[] gold_prices) {
        int answer = 0;
        for (int i = 0; i < gold_prices.length - 2; i++) {
            int temp = gold_prices[i + 1] - gold_prices[i];
            int temp2 = gold_prices[i + 2] - gold_prices[i];
            if (temp > 0 && temp2 > 0) {
                if (temp > temp2) {
                    answer += temp;
                    i+=2;
                } else {
                    answer += temp2;
                    i+=3;
                }
            } else if (temp > 0) {
                answer += temp;
                i+=2;
            } else if (temp2 > 0) {
                answer += temp2;
                i+=3;
            }
        }

        return answer;
    }
}

/*
i를 기준으로 i + 3까지 봄
i + 1이 i보다 낮으면 안팜

역순으로 본다

팔 날을 정하고 팔 날보다 가격이 작은 날을 찾아서 차익을 비교한다.



 */