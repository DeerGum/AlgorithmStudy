package ps_study.week_12;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Elevator {
    public static URL url = null;

    public static void main(String[] args) throws MalformedURLException, IOException {
        url = new URL("http://localhost:8000");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");


    }

}
