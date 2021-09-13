package codingTest.kakao.down;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Program_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    }

    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String>[] userReport = new HashSet[id_list.length];
        HashMap<String, Integer> userIdx = new HashMap<>(id_list.length);

        for (int i = 0; i < id_list.length; i++) {
            userIdx.put(id_list[i],i);
            userReport[i] = new HashSet<>();
        }
        
        StringTokenizer st;
        for (int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            int toIdx = userIdx.get(to);

            userReport[toIdx].add(from);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < userReport.length; i++) {
            if (userReport[i].size() >= k) {
                for (String userName: userReport[i])
                    answer[userIdx.get(userName)]++;
            }
        }

        return answer;
    }
}
