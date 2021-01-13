import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        Gson gson = new GsonBuilder().create();
        Test1 t1 = new Test1(5);
        Test1 t2 = new Test1(5);
        Test1 t3 = new Test1(5);

        ArrayList<Test1> arr = new ArrayList<>();
        arr.add(t1);
        arr.add(t2);
        arr.add(t3);
        StringBuilder sb = new StringBuilder();
        sb.append("{\"commands\":");
        String j = gson.toJson(arr);
        sb.append(j);
        sb.append("}");
        System.out.println(sb.toString());
    }
}

class Test1 {
    public int id;
    public int[] num;

    public Test1(int id) {
        this.id = id;
        num = new int[0];
    }
}
