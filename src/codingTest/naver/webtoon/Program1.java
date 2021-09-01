package codingTest.naver.webtoon;

import java.util.Arrays;
import java.util.Collections;

public class Program1 {
    public static void main(String[] args) {
        int[] prices = {13000, 88000, 10000};
        int[] discounts = {30, 20};
        solution(prices,discounts);
    }
    public static int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Integer[] priceList = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        Integer[] discountList = Arrays.stream(discounts).boxed().toArray(Integer[]::new);
        Arrays.sort(priceList, Collections.reverseOrder());
        Arrays.sort(discountList, Collections.reverseOrder());

        int couponIdx = 0;
        for (int price: priceList) {
            if(couponIdx < discountList.length) {
                double discount = discountList[couponIdx++] / 100.0;
                answer += price - (price * discount);
            }
            else
                answer += price;
        }
        return answer;
    }
}
