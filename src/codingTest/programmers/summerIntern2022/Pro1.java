package codingTest.programmers.summerIntern2022;

public class Pro1 {
    static int[] mise = {30, 80, 150,1000};
    static int[] chomise = {15, 35, 75,1000};

    public static void main(String[] args) {
        Pro1 p = new Pro1();
        p.solution(new int[][] {{80,35},{70,38},{100,41},{75,30},{160,80},{77,29},{181,68},{151,76}});
    }
    public int solution(int[][] atmos) {
        int useDay = 0;
        int mask = 0;

        for (int i = 0; i < atmos.length; i++) {
            int dust = atmos[i][0];
            int fineDust = atmos[i][1];
            if (dust > mise[1] || fineDust > chomise[1]) {  //마스크써야할때
                if (dust > mise[2] && fineDust > chomise[2]) {  //마스크 한번쓰고 폐기
                    if (useDay == 0)
                        mask++;
                    useDay = 0;
                } else {
                    if (useDay == 0)
                        mask++;
                    useDay = (useDay + 1) % 3;
                }
            } else {
                if (useDay != 0)
                    useDay = (useDay + 1) % 3;
            }
        }
        return mask;
    }
}
