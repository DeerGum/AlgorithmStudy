package codingTest.kakao.intern2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Pro4 {
    static ArrayList<Node>[] graph;
    static HashMap<Integer, Integer> gateOrSummit;
    static boolean[] v;
    static boolean[] isSummits;
    static int minIntensity;
    static int minSummit;
    static int[] dp;

    public static void main(String[] args) {
        Pro4 p = new Pro4();
        p.solution(5, new int[][]{{1,3,10},{1,4,20},{2,3,4},{2,4,6},{3,5,20},{4,5,6}}, new int[]{1,2}, new int[]{5});
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        gateOrSummit = new HashMap<>();
        isSummits = new boolean[n];
        for (int i = 0; i < gates.length; i++) {
            int curr = gates[i] - 1;
            gateOrSummit.put(curr, 1);
        }

        for (int i = 0; i < summits.length; i++) {
            int curr = summits[i] - 1;
            gateOrSummit.put(curr, 2);
            isSummits[curr] = true;
        }

        for (int i = 0; i < paths.length; i++) {
            int from = paths[i][0] - 1;
            int to = paths[i][1] - 1;
            int weight = paths[i][2];
            graphInit(to, from, weight);
            graphInit(from, to, weight);
        }
        for (ArrayList list : graph)
            Collections.sort(list);

        minIntensity = 10000001;
        minSummit = -1;

        dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = -1;

        v = new boolean[n];
        for (int i = 0; i < gates.length; i++) {
            v[gates[i]-1] = true;
            dfs2(gates[i] - 1, 0);
            v[gates[i]-1] = false;
        }

        int[] answer = new int[]{minSummit + 1, minIntensity};
        return answer;
    }

    private void graphInit(int from, int to, int weight) {
        if (gateOrSummit.get(to) != null) {
            if (gateOrSummit.get(to) == 1)
                graph[from].add(new Node(from, to, weight, true, false));
            else
                graph[from].add(new Node(from, to, weight, false, true));
        } else
            graph[from].add(new Node(from, to, weight));
    }

    public void dfs(int curr, int maxIntensity) {

        if (isSummits[curr]) {
            if (maxIntensity < minIntensity) {
                minIntensity = maxIntensity;
                minSummit = curr;
            } else if (maxIntensity == minIntensity) {
                minSummit = Math.min(minSummit, curr);
            }
            return;
        }

        for (Node next : graph[curr]) {
            if (v[next.to] || next.isToGate)
                continue;

            v[next.to] = true;
            dfs(next.to, Math.max(maxIntensity, next.weight));
            v[next.to] = false;
        }

    }
    public int dfs2(int curr, int maxIntensity) {
        if (isSummits[curr]) {
            if (maxIntensity < minIntensity) {
                minIntensity = maxIntensity;
                minSummit = curr;
            } else if (maxIntensity == minIntensity) {
                minSummit = Math.min(minSummit, curr);
            }
            if (dp[curr] == -1)
                dp[curr] = maxIntensity;
            else
                dp[curr] = Math.min(dp[curr], maxIntensity);
            return maxIntensity;
        }

        for (Node next : graph[curr]) {
            if (v[next.to] || next.isToGate)
                continue;

            if (dp[next.to] != -1 && dp[next.to] < maxIntensity)
                continue;

            v[next.to] = true;
            int temp = dfs2(next.to, Math.max(maxIntensity, next.weight));
            if (dp[curr] == -1)
                dp[curr] = temp;
            else
                dp[curr] = Math.min(dp[curr], temp);
            v[next.to] = false;
        }

        return dp[curr];
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;
        boolean isToGate;
        boolean isToSummit;

        public Node(int from, int to, int weight, boolean isToGate, boolean isToSummit) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.isToGate = isToGate;
            this.isToSummit = isToSummit;
        }

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
/*
한 출입구에서 출발 -> 산봉우리 한 곳 방문 -> 들어왔던 출입구로 돌아옴


 */