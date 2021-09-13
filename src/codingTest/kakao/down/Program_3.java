package codingTest.kakao.down;

import java.io.*;
import java.util.*;

public class Program_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Program_3 p = new Program_3();
        p.solution(new int[]{180,5000,10,600},new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

    }

    static int baseTime;
    static int baseFee;
    static int extraTime;
    static int extraFee;
    static HashMap<String,String> record;
    static SortedMap<String,Integer> saveTime;
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        baseTime = fees[0];
        baseFee = fees[1];
        extraTime = fees[2];
        extraFee = fees[3];
        record = new HashMap<>();
        saveTime = new TreeMap<>();
        StringTokenizer st;
        for (int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String numberPlate = st.nextToken();
            String inOut = st.nextToken();

            if (inOut.equals("IN")) {
                record.put(numberPlate,time);
            } else {    //out
                String inTime = record.get(numberPlate);
                calTime(numberPlate, inTime, time);
                record.remove(numberPlate);
            }
        }

        for (String carNumber: record.keySet())
            calTime(carNumber,record.get(carNumber),"23:59");

        return calFee();
    }

    public void calTime(String numberPlate, String in, String out) {
        int inH = Integer.parseInt(in.substring(0,2));
        int inM = Integer.parseInt(in.substring(3));

        int outH = Integer.parseInt(out.substring(0,2));
        int outM = Integer.parseInt(out.substring(3));

        int h = outH - inH;
        int m = 0;
        if(outM >= inM) {
            m = outM-inM;
        } else {
            m = (outM+60)-inM;
            h--;
        }

        int parkingTime = 60*h + m;

        if (saveTime.containsKey(numberPlate)) {
            int time = saveTime.get(numberPlate);
            saveTime.put(numberPlate,time+parkingTime);
        } else
            saveTime.put(numberPlate,parkingTime);
    }

    public int[] calFee() {
        int[] result = new int[saveTime.size()];

        int idx = 0;
        for (int time : saveTime.values()) {
            if (time <= baseTime) {
                result[idx++] = baseFee;
            } else {
                result[idx++] = baseFee + (int)Math.ceil(((double) time - baseTime)/extraTime) * extraFee;
            }
        }
        return result;
    }
}

/*

50

15

-35

 */