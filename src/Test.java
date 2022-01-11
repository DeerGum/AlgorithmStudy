import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    static String strUrl = "http://13.125.222.176/quiz";
    static String addUrl = "/jordan";
    static Gson gson = new Gson();

    public static void main(String[] args) {
        try {
            URL url = new URL(strUrl + addUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("nickname", "서울4반황정준");
            jsonObject.addProperty("yourAnswer", "kubernetes");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            bw.write(gson.toJson(jsonObject));
            bw.close();

            int responseCode = con.getResponseCode();
            if (responseCode == 403) {
                System.out.println("403:: 닉네임을 적지 않음");
            } else if (responseCode == 500) {
                System.out.println("500:: 서버 에러");
            } else if (responseCode == 600) {
                System.out.println("600:: 오답");
            } else { // 성공 후 응답 JSON 데이터받기
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                System.out.println(sb.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

/*
1 = 1
2 = 8
3 = 27
4 = 64
5 = 125
6 = 216


 */