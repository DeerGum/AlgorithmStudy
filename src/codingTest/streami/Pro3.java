package codingTest.streami;

public class Pro3 {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        int[] C = new int[N];

        int min = 100001;
        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                C[i] = A[i];
            } else if (A[i] < B[i]) {
                C[i] = B[i];
                min = Math.min(min, A[i]);
            } else {    //A[i] > B[i]
                C[i] = A[i];
                min = Math.min(min, B[i]);
            }
        }

        if (min == 100001)
            min = 3;

        return min;
    }
}

/*
3
x
x
3
3


x
x



 */