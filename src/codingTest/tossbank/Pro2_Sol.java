package codingTest.tossbank;

public class Pro2_Sol {
    public static void main(String[] args) {
        Pro2_Sol pro2 = new Pro2_Sol();

        System.out.println(pro2.solution(new int[]{1,6},new int[]{3,5},1,2));
    }
    public int solution(int[] a, int[] b, int duration, int distance) {
        int answer=-1;
        int start = Math.max(a[0],b[0]);
        int end = Math.min(a[1],b[1]);
        if(start<end) {
            outer:
            for (int j = start; j <= end; j++) {
                for (int i = 0; i <= distance; i++) {
                    int commuteA=Math.abs(i-0);
                    int commuteB=Math.abs(i-distance);
                    if(commuteA+a[0]<=j&&commuteB+b[0]<=j){
                        if (j+ duration + commuteB <= b[1] && j + duration + commuteA <= a[1]) {
                            answer = j;
                            break outer;
                        }
                    }
                }
            }
        }
        return answer;
    }
}

/*
먼저 나올 수 있는 사람은 먼저 나오는게 이득
1

3 = 2*1 + 1*1

a가 먼저 걷는 시간 = 2
a,b 같이 걷는 시간 = dis - a가 먼저 걷는 시간 = 2 - 2 = 0

시작 시간 1 + 걷는 시간 2 = 3시

a 돌아가는 시간 = 2

b 돌아가는 시간 = 0


a가 먼저 걷는 시간 = 1
a,b 같이 걷는 시간 = (dis - a가 먼저 걷는 시간)/2 = 3 - 1 = 2 / 2 = 1

시작 시간 1 + 걷는 시간 2 = 3시

a 돌아가는 시간 = 같이 걷는 시간 + 먼저 걸은 시간

b 돌아가는 시간 = 같이 걷는 시간 + 먼저 걸은 시간

a가 먼저 걷는 시간 = 1
a,b 같이 걷는 시간 = (dis - a가 먼저 걷는 시간)/2 = 4 - 1 = 3 / 2 = 1



 */