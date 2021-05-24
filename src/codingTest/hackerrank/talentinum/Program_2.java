package codingTest.hackerrank.talentinum;

import java.util.Iterator;
import java.util.List;

public class Program_2 {
    /*
     * Complete the 'widestGap' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY start
     *  3. INTEGER_ARRAY finish
     */
    public static int[] load;
    public static int widestGap(int n, List<Integer> start, List<Integer> finish) {
        // Write your code here
        load = new int[n+1];
        Iterator<Integer> sItr = start.iterator();
        Iterator<Integer> fItr = finish.iterator();

        while(sItr.hasNext()) {
            int startPos = sItr.next();
            int finishPos = fItr.next();

            for (int i = startPos; i <= finishPos; i++)
                load[i] = 1;
        }

        int max = 0;
        int count = 0;
        for (int i = 1; i < load.length; i++) {
            if(load[i] == 0)
                count++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }
}
