package codingTest.streami;

public class Pro1 {

    public static void main(String[] args) {
        Pro1 p = new Pro1();
        System.out.println(p.solution(2, 1));
    }

    public int solution(int A, int B) {
        int low = 0;
        int high;
        if (B < A)
            high = A;
        else
            high = B;

        int maxSide = 0;
        int mid, side;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid <= 0) {
                break;
            }

            side = (A / mid) + (B / mid);
            if (side >= 4) {
                maxSide = Math.max(mid, maxSide);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxSide;
    }

}
/*
5

2
4


 */