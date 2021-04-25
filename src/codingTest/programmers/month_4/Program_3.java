package codingTest.programmers.month_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Program_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Program_3 p3 = new Program_3();

        long t = p3.solution(new int[] {-5,0,2,1,2},new int[][] {{0,1},{3,4},{2,3},{0,3}});
        System.out.println(t);
    }

    public static Tree[] graph;
    public long solution(int[] a, int[][] edges) {
        long answer = 0;

        long temp = 0;
        for (int i = 0; i < a.length; i++)
            temp += a[i];
        if (temp != 0)
            return -1;

        graph = new Tree[a.length];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new Tree(a[i]);

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].egde.add(edges[i][1]);
            graph[edges[i][1]].egde.add(edges[i][0]);
        }

        for (int i = 0; i < graph.length; i++) {
            if (!graph[i].egde.isEmpty() && !graph[i].isVisited) {
                answer += zeroSum(i, graph[i].egde.get(0));
                graph[graph[i].egde.get(0)].egde.remove((Integer)i);
                graph[i].egde.remove(0);
            }
        }

        return answer;
    }

    public long zeroSum(int index, int target) {
        long count = 0;
        while(graph[index].weight != 0) {
            if (graph[index].weight < 0) {
                graph[index].weight++;
                graph[target].weight--;
            }
            else {
                graph[index].weight--;
                graph[target].weight++;
            }
            count++;
        }
        graph[index].isVisited = true;
        return count;
    }


}

class Tree {
    public ArrayList<Integer> egde;
    public int weight;
    public boolean isVisited;

    public Tree(int weight) {
        this.weight = weight;
        this.egde = new ArrayList<>();
        this.isVisited = false;
    }

}
