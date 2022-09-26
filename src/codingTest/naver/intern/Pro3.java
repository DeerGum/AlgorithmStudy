package codingTest.naver.intern;

import java.util.*;

public class Pro3 {
    private static Queue<Integer> valueParse;
    private static ArrayList<Node>[] graph;
    private static PriorityQueue<ArrayList> vertexSortByEdgeCnt;
    private static int N, M;
    private static int[] values;
    public int solution(int N, int[] A, int[] B) {
        valueParse = new LinkedList();
        graph = new ArrayList[N+1];
        vertexSortByEdgeCnt = new PriorityQueue(new ArrayListComparator());
        values = new int[N+1];
        this.N = N;
        this.M = A.length;

        for(int i = N; i > 0; i--) {
            valueParse.add(i);
            graph[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++) {
            int from = A[i];
            int to = B[i];

            graph[from].add(new Node(from, to));
            graph[to].add(new Node(to, from));
        }

        parseVertexValue();

        return edgeSum(A, B);
    }

    private void parseVertexValue() {
        for(int i = 1; i <= N; i++)
            vertexSortByEdgeCnt.add(graph[i]);

        while(!vertexSortByEdgeCnt.isEmpty()) {
            ArrayList<Node> curr = vertexSortByEdgeCnt.poll();

            if(curr.size() == 0)
                break;

            values[curr.get(0).from] = valueParse.poll();
        }
    }

    private int edgeSum(int[] A, int[] B) {
        int sum = 0;
        for(int i = 0; i < M; i++)
            sum += values[A[i]] + values[B[i]];

        return sum;
    }

    private static class ArrayListComparator implements Comparator<ArrayList> {
        @Override
        public int compare(ArrayList a1, ArrayList a2) {
            return a2.size() - a1.size();
        }
    }

    private static class Node {
        public int from;
        public int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
