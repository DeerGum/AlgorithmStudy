import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        String test = "123tsea@!@#$%@!,-.._";
        test = test.replaceAll("[^0-9a-z-_.]+","");
        test = test.replaceAll("[..]+",".");
        System.out.println(test);

        String test2 = "12345";
        System.out.println(test2.replaceFirst(".$",""));

        String test3 = "-123";
        int temp = Integer.valueOf(test3);
        System.out.println(temp);
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
