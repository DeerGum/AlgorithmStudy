package codingTest.nhn.commerce_2021;

import java.io.*;
import java.util.*;

public class Program_4 {
    static int N, M, G;
    static int X, S, T; // 중력장 행성, 출발 행성, 도착 행성
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] reverse;
    static HashMap<Integer,Integer>[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        reverse = new ArrayList[N+1];
        weight = new HashMap[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
            weight[i] = new HashMap<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            reverse[to].add(from);
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dfs(X, G);
        reverseDfs(X, 1);
        search();

        bw.write(-1+"\n");
        bw.close();
    }

    public static void dfs(int start, int g) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] v = new boolean[N+1];
        q.offer(new int[]{start, g});
        v[start] = true;

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int curr = item[0];
            int currW = item[1];
            if (currW < 1)
                currW = 1;

            for (int next : graph[curr]) {
                if (v[next])
                    continue;

                if (weight[curr].containsKey(next)) {
                    int w = weight[curr].get(next);
                    weight[curr].put(next, Math.min(w, g));
                } else
                    weight[curr].put(next,g);

                q.offer(new int[]{next, currW - 1});
                v[next] = true;
            }
        }
    }

    public static void reverseDfs(int start, int g) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] v = new boolean[N+1];
        q.offer(new int[]{start, g});
        v[start] = true;

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int curr = item[0];
            int currW = item[1];
            if (currW > G)
                currW = G;

            for (int next : graph[curr]) {
                if (v[next])
                    continue;

                if (weight[curr].containsKey(next)) {
                    int w = weight[curr].get(next);
                    weight[curr].put(next, Math.min(w, g));
                } else
                    weight[curr].put(next,g);

                q.offer(new int[]{next, currW + 1});
                v[next] = true;
            }
        }
    }

    public static void search() {

    }
}

class Node {
    public int w;
    public int to;

    public Node(int to) {
        this.to = to;
        this.w = 0;
    }
}
