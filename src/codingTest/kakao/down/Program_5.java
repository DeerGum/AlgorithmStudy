package codingTest.kakao.down;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Program_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    }

    static int[] node;
    ArrayList<Integer>[] e;
    static int[] childSheep;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        node = info;
        childSheep = new int[node.length];
        e = new ArrayList[node.length];
        for (int i = 0; i < e.length; i++)
            e[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            e[from].add(to);
            e[to].add(from);
        }

        int s = searchSheep(0,new boolean[node.length],0);
        System.out.println(s+" "+ Arrays.toString(childSheep));
        return answer;
    }

    public int searchSheep(int nodeNum, boolean[] v, int sheep) {
        if (e[nodeNum].size() == 1 && v[e[nodeNum].get(0)]) {   //리프노드
            if (node[nodeNum] == 0)
                sheep++;
            childSheep[nodeNum] = sheep;
            return sheep;
        }

        if (node[nodeNum] == 0)
            sheep++;
        v[nodeNum] = true;
        for (int nextNode:e[nodeNum]) {
            if (v[nextNode])
                continue;
            childSheep[nodeNum] += searchSheep(nextNode,v,sheep);
        }
        return childSheep[nodeNum];
    }

}

class Node implements Comparable<Node>{
    int type;
    int nodeNum;

    public Node(int type, int nodeNum, int childSheep) {
        this.type = type;
        this.nodeNum = nodeNum;
    }

    @Override
    public int compareTo(Node o) {
        return this.type - o.type;
    }
}
