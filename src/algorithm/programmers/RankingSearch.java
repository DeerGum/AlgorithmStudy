package algorithm.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 2021 카카오 공채
 * 순위 검색
 * 문제 링크 - https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
 */
public class RankingSearch {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        HashMap<String,Integer> set = new HashMap(800000);
        String lang, job, career, soulFood;
        int score;
        StringTokenizer st;
        StringBuilder sb;
        
        for(int i=0;i<info.length;i++) {
            st = new StringTokenizer(info[i]);
            sb = new StringBuilder();

            lang = st.nextToken();
            job = st.nextToken();
            career = st.nextToken();
            soulFood = st.nextToken();
            score = Integer.parseInt(st.nextToken());




        }

        return answer;
    }

    static void comb(int[] arr, boolean[] visited, int start, int n, int r, StringBuilder sb) {
        if(r == 0) {
            
            // print(arr, visited, n);

            return;
        } 
    
        for(int i=start; i<n; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r - 1, sb);
            visited[i] = false;
        }
    }

}

class Info {
    private String lang;
    private String job;
    private String career;
    private String soulFood;

    public Info(String lang, String job, String career, String soulFood) {
        this.lang = lang;
        this.job = job;
        this.career = career;
        this.soulFood = soulFood;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getSoulFood() {
        return soulFood;
    }

    public void setSoulFood(String soulFood) {
        this.soulFood = soulFood;
    }

    
}
