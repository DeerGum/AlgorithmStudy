package codingTest.tossbank;

public class Pro2 {
    public static void main(String[] args) {
        Pro2 pro2 = new Pro2();

        System.out.println(pro2.solution(new int[]{1,6},new int[]{3,5},1,2));
    }
    public int solution(int[] a, int[] b, int duration, int distance) {
        int answer = -1;
        boolean aFast = false;

        int aTogetherWorking = 0;
        int bTogetherWorking = 0;
        int aAloneWorking = 0;
        int bAloneWorking = 0;

        int aReturnWorking = 0;
        int bReturnWorking = 0;

        if (a[0] > b[0]) {  //a가 더 빠르면
            aAloneWorking = b[0] - a[0];
            int togetherWorkingDistance = distance - aAloneWorking;
            aTogetherWorking = togetherWorkingDistance / 2;
            bTogetherWorking = aTogetherWorking;
            aReturnWorking = aAloneWorking + aTogetherWorking;
            bReturnWorking = bAloneWorking + bTogetherWorking;
            if (togetherWorkingDistance % 2 != 0) { //남은 거리가 홀수이면
                int aSpare = a[1] - (a[0] + 2 * aReturnWorking);
                int bSpare = b[1] - (b[0] + 2 * bReturnWorking);
                if (aSpare > bSpare)
                    aReturnWorking++;
                else
                    bReturnWorking++;
            }
            if (a[0] + aReturnWorking * 2 + duration <= a[1] && b[0] + bReturnWorking * 2 + duration <= b[1])
                answer = a[0] + aAloneWorking + aTogetherWorking;
        } else {
            bAloneWorking = a[0] - b[0];
            int togetherWorkingDistance = distance - bAloneWorking;
            aTogetherWorking = togetherWorkingDistance / 2;
            bTogetherWorking = aTogetherWorking;
            aReturnWorking = aAloneWorking + aTogetherWorking;
            bReturnWorking = bAloneWorking + bTogetherWorking;
            if (togetherWorkingDistance % 2 != 0) { //남은 거리가 홀수이면
                int aSpare = a[1] - (a[0] + 2 * aReturnWorking);
                int bSpare = b[1] - (b[0] + 2 * bReturnWorking);
                if (aSpare > bSpare)
                    aReturnWorking++;
                else
                    bReturnWorking++;
            }
            if (a[0] + aReturnWorking * 2 + duration <= a[1] && b[0] + bReturnWorking * 2 + duration <= b[1])
                answer = a[0] + aAloneWorking + aTogetherWorking;
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