package codingTest.estsoft;

public class Pro3 {
    static boolean[][] times;

    public String solution(String noti_time, String[] do_not_disturb) {
        times = new boolean[24][60];

        for (int i = 0; i < do_not_disturb.length; i++)
            setTimes(do_not_disturb[i]);

        String answer = findNotiTime(noti_time);
        return answer;
    }

    private void setTimes(String time) {
        int startH = Integer.parseInt(time.substring(0, 2));
        int startM = Integer.parseInt(time.substring(3, 5));
        int endH = Integer.parseInt(time.substring(6, 8));
        int endM = Integer.parseInt(time.substring(9));

        int h = startH;
        int m = startM;

        while (h != endH || m != endM) {
            times[h][m] = true;
            m = (m + 1) % 60;
            if (m == 0)
                h = (h + 1) % 24;
        }
    }

    private String findNotiTime(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));

        if (isImpossible())
            return "impossible";

        while (times[h][m]) {
            m = (m + 1) % 60;
            if (m == 0)
                h = (h + 1) % 24;
        }

        return String.format("%02d:%02d",h,m);
    }

    private boolean isImpossible() {
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times[i].length; j++) {
                if (!times[i][j])
                    return false;
            }
        }
        return true;
    }
}

/*
2 2 : 3 0 ~ 2 3 : 4 0
0 1 2 3 4 5 6 7 8 9 10

 */