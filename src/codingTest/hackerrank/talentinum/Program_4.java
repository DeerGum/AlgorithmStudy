package codingTest.hackerrank.talentinum;

import java.util.*;

public class Program_4 {
    /*
     * Complete the 'order' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. UNWEIGHTED_INTEGER_GRAPH city
     *  2. INTEGER company
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */
    public static ArrayList<Integer>[] graph;
    public static boolean[] isVisited;
    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        graph = new ArrayList[cityNodes+1];
        isVisited = new boolean[cityNodes+1];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < graph.length; i++)
            graph[i] = new ArrayList<>();



        Iterator<Integer> fromItr = cityFrom.iterator();
        Iterator<Integer> toItr = cityTo.iterator();

        while(fromItr.hasNext()) {
            int from = fromItr.next();
            int to = toItr.next();

            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i < graph.length; i++)
            Collections.sort(graph[i]);

        q.add(company);
        isVisited[company] = true;

        while(!q.isEmpty()) {
            int pollItem = q.poll();
            for (int i = 0; i < graph[pollItem].size(); i++) {
                int toCity = graph[pollItem].get(i);
                if(!isVisited[toCity]) {
                    q.add(toCity);
                    isVisited[toCity] = true;
                }
            }
            if(pollItem != company)
                result.add(pollItem);
        }

        return result;
    }
}