package codingTest.kakao.intern2022;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Pro3 {
    static int maxAlp, maxCop;

    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        List<Problem> problemList = new ArrayList<>();


        return answer;
    }

    static class Problem implements Comparable<Problem>{
        int alpReq;
        int copReq;
        int alpRwd;
        int copRwd;
        int cost;

        public Problem(int alpReq, int copReq, int alpRwd, int copRwd, int cost) {
            this.alpReq = alpReq;
            this.copReq = copReq;
            this.alpRwd = alpRwd;
            this.copRwd = copRwd;
            this.cost = cost;
        }


        @Override
        public int compareTo(Problem o) {
            return (this.alpReq + this.copReq) - (o.alpReq + o.copReq);
        }
    }
}

/*
max 10 11
start 0 0

공부하면 21만큼 필요

3차원 DP





 */