package codingTest.programmers.month_4;

import java.util.ArrayList;

public class Program_3 {

    public static void main(String[] args){
        Program_3 p3 = new Program_3();

        long t = p3.solution(new int[] {-5,0,2,1,2},new int[][] {{0,1},{3,4},{2,3},{0,3}});
        System.out.println(t);
    }

    public static ArrayList<Integer>[] graph;
    public static boolean[] isVisited;
    public static int[] w;
    public static long count;
    public static long[] check;
    public long solution(int[] a, int[][] edges) {

        graph = new ArrayList[a.length];
        isVisited = new boolean[a.length];
        w = a;
        count = 0;
        check = new long[a.length];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList();

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        isVisited[0] = true;
        dfs(0);

        return count;
    }
    public void dfs(int node) {
        for (int i = 0; i < graph[node].size(); i++) {
            if (!isVisited[graph[node].get(i)]) {
                isVisited[graph[node].get(i)] = true;
                dfs(graph[node].get(i));
                check[node] += check[graph[node].get(i)];
                count += Math.abs(check[graph[node].get(i)]);
            }
        }
        check[node] += w[node]; //check 배열에 가중치 추가
        if (node == 0 && check[node] != 0)
            count = -1;

    }

}

