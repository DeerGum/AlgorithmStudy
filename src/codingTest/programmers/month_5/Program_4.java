package codingTest.programmers.month_5;

import java.util.ArrayList;
import java.util.Arrays;

public class Program_4 {
    public static void main(String[] args) {
        Program_4 p = new Program_4();
        int[] v = {1,10,100,1000,10000};
        int[][] e = {{1,2},{1,3},{2,4},{2,5}};
        int[][] q = {{1,-1},{2,-1},{3,-1},{4,-1},{5,-1},{4,1000},{1,-1},{2,-1},{3,-1},{4,-1},{5,-1},{2,1},{1,-1},{2,-1},{3,-1},{4,-1},{5,-1}};
        long[] result = p.solution(v,e,q);
        System.out.println(Arrays.toString(result));
    }
    public static int[] depths;
    public static int[] value;
    public static boolean[] isVisited;
    public static int[] parents;
    public static ArrayList<Integer>[] tree;
    public static long sum;
    public long[] solution(int[] values, int[][] edges, int[][] queries) {
        ArrayList<Long> answer = new ArrayList<>();
        tree = new ArrayList[values.length];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new ArrayList<>();
        value = values;
        depths = new int[values.length];
        isVisited = new boolean[values.length];
        parents = new int[values.length];
        int from, to;
        for (int i = 0; i < edges.length; i++) {
            from = edges[i][0] -1;
            to = edges[i][1] -1;

            tree[from].add(to);
            tree[to].add(from);

        }
        isVisited[0] = true;
        dfs1(0,1);
        int u,w;
        for (int i = 0; i < queries.length; i++) {
            u = queries[i][0];
            w = queries[i][1];

            if(w == -1) {
                sum = 0;
                isVisited = new boolean[values.length];
                isVisited[u-1] = true;
                query1(u-1,depths[u-1]);
                answer.add(sum);
            }
            else {
                query2(u-1,u-1,w);
            }
        }


        Long[] result = answer.toArray(new Long[answer.size()]);
        return Arrays.stream(result).mapToLong(i->i).toArray();
    }

    public void dfs1(int node, int depth) {
        int child;
        depths[node] = depth;
        for (int i = 0; i < tree[node].size(); i++) {
            child = tree[node].get(i);
            if(!isVisited[child]) {
                isVisited[child] = true;
                parents[child] = node;
                dfs1(child, depth + 1);
            }
        }
    }

    public void query1(int node, int parentsDepth) {
        int child;
        sum += value[node];
        for (int i = 0; i < tree[node].size(); i++) {
            child = tree[node].get(i);
            if(!isVisited[child] && depths[child] >= parentsDepth) {
                isVisited[child] = true;
                query1(child, parentsDepth);
            }
        }
    }

    public void query2(int node, int u, int w) {
        int parent;
        if(node != 0) {
            int parentsValue = value[parents[node]];
            value[node] = parentsValue;
        }
        else {  //루트노드
            value[node] = w;
            return;
        }

        for (int i = 0; i < tree[node].size(); i++) {
            parent = tree[node].get(i);
            if(depths[parent] < depths[node]) {

                query2(parent, u, w);
            }
        }
    }
}
