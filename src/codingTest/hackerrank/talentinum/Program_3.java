package codingTest.hackerrank.talentinum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Program_3 {
    /*
     * Complete the 'deviceNamesSystem' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY devicenames as parameter.
     */

    public static List<String> deviceNamesSystem(List<String> devicenames) {
        // Write your code here
        HashMap<String,Integer> names = new HashMap<>();
        Iterator<String> itr = devicenames.iterator();
        List<String> result = new LinkedList<>();

        while(itr.hasNext()) {
            String name = itr.next();
            if(names.containsKey(name)) {
                int deviceNum = names.get(name);
                names.put(name, ++deviceNum);
                result.add(name+deviceNum);
            }
            else {
                names.put(name, 0);
                result.add(name);
            }
        }

        return result;
    }
}
