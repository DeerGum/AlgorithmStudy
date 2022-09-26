package codingTest.naver.intern;

public class Pro1 {
    int solution(int N) {
        int largest = N; //원래는 0이었음
        int shift = 0;
        int temp = N;
        for (int i = 1; i < 30; ++i) {
            int index = (temp & 1);
            temp = ((temp >> 1) | (index << 29));
            if (temp > largest) {
                largest = temp;
                shift = i;
            }
        }
        return shift;
    }
}
/*
입력으로 30비트의 unsigned 정수가 들어옴
버그를 찾아서 수정하라


 */