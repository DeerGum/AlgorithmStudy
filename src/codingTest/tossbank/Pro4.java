package codingTest.tossbank;

public class Pro4 {
    public static void main(String[] args) {
        Pro4 pro4 = new Pro4();

        pro4.solution("2021:04:12:16:08:35", new String[]{"19:00:00:00"});
    }
    public int[] solution(String s, String[] times) {
        boolean isPass = true;
        Time origin = Time.of(s);
        Time temp = Time.of(s);

        int prevDay;
        for (int i = 0; i < times.length; i++) {
            prevDay = temp.day;
            temp.add(times[i]);
            if (temp.day < prevDay) {
                if (temp.day + 30 - prevDay > 1)
                    isPass = false;
            } else if (temp.day - prevDay > 1)
                isPass = false;


        }

        int result = origin.subDay(temp);
        int[] answer;
        if (isPass)
            answer = new int[]{1, result};
        else
            answer = new int[]{0, result};

        return answer;
    }
}

class Time {
    int year;
    int month;
    int day;
    int hour;
    int min;
    int second;

    public static Time of(String time) {
        Time t = new Time();

        t.year = Integer.parseInt(time.substring(0,4));
        t.month = Integer.parseInt(time.substring(5,7));
        t.day = Integer.parseInt(time.substring(8,10));
        t.hour = Integer.parseInt(time.substring(11,13));
        t.min = Integer.parseInt(time.substring(14,16));
        t.second = Integer.parseInt(time.substring(17,19));

        return t;
    }

    public void add(String target) {
        int day = Integer.parseInt(target.substring(0,2));
        int hour = Integer.parseInt(target.substring(3,5));
        int min = Integer.parseInt(target.substring(6,8));
        int second = Integer.parseInt(target.substring(9,11));

        int temp = this.second + second;
        if (temp > 59) {
            this.min++;
            temp %= 60;
        }
        this.second = temp;

        temp = this.min + min;
        if (temp > 59) {
            this.hour++;
            temp %= 60;
        }
        this.min = temp;

        temp = this.hour + hour;
        if (temp > 23) {
            this.day++;
            temp %= 24;
        }
        this.hour = temp;

        temp = this.day + day;
        if (temp > 30) {
            this.month += temp / 30;
            temp %= 30;
        }
        this.day = temp;

        if (this.month > 12) {
            this.year++;
            this.month %= 12;
        }

        System.out.println("더한 후 = "+this);
    }

    public int subDay(Time next) {
        System.out.println(next);
        System.out.println(this);

        int result = 0;
        if (next.day - this.day < 0) {
            next.month--;
            next.day += 30;
        }
        result += next.day - this.day;

        if (next.month - this.month < 0) {
            next.year--;
            next.month += 12;
        }
        result += (next.month - this.month) * 30;

        result += (next.year - this.year) * 360;

        return result + 1;
    }

    @Override
    public String toString() {
        return  year +
                ":" + month +
                ":" + day +
                ":" + hour +
                ":" + min +
                ":" + second;
    }
}
/*
2021:04:12 :  1  6  :  0  8  :  3  5
0123456789 10 11 12 13 14 15 16 17 18

01:06:30:0 0
0123456789 10

18초 + 51초 = 9초 (69초)

10일 + 22일 = 32일

2021 04 14 23 60 00
2021 04 12 16 08 35
 */