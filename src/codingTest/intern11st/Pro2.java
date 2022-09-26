package codingTest.intern11st;

public class Pro2 {
    public int solution(int[] A) {
        int K = A.length;
        int cnt = 0;
        int[] check = new int[K];   //0 : 스위치 off, 1 : 스위치 on(불 안들어옴), 2 : 스위치 on(불 들어옴)

        for (int i = 0; i < K; i++) {
            int curr = A[i] - 1;
            if (curr == 0 || check[curr-1] == 2) {  //첫번째 전구이거나 바로 앞 전구의 불이 켜진 경우
                cnt++;
                check[curr] = 2;
                for (int j = curr+1; j < K && check[j] == 1; j++) //뒤가 1이면 0을 만날때까지 2로 만들어줌
                    check[j] = 2;
            } else  //앞에 전구가 불이 안켜져있으므로 스위치만 on
                check[curr] = 1;
        }

        return cnt;
    }
}

/*
0 0 0 0 0
0 1 0 0 0
2 2 0 0 0 !
2 2 2 0 0 !
2 2 2 0 1
2 2 2 2 2 !



if 앞이 2이면
    자기도 2
    자기 뒤가 1이면 0을 만날때까지 2로 바꿔줌
else
    아니면 1



 */