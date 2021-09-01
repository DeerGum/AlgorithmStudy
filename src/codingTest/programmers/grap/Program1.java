package codingTest.programmers.grap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Program1 {
    static boolean hasLogin, hasAdd;
    static HashMap<String, String> userInfo;
    static Queue<String> shoopingBasket;
    public boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = new boolean[actions.length];
        StringTokenizer st;
        userInfo = new HashMap<>();
        shoopingBasket = new LinkedList<>();
        for (int i = 0; i < infos.length; i++) {
            st = new StringTokenizer(infos[i]);
            String id = st.nextToken();
            String password = st.nextToken();
            userInfo.put(id, password);
        }
        hasLogin = false;
        hasAdd = false;

        for (int i = 0; i < actions.length; i++) {
            answer[i] = action(actions[i]);
        }
        return answer;
    }

    public boolean action(String command) {
        StringTokenizer cmd = new StringTokenizer(command);
        boolean result = false;
        switch (cmd.nextToken()) {
            case "LOGIN":
                String userid = cmd.nextToken();
                String password = cmd.nextToken();
                result = login(userid, password);
                break;
            case "ADD":
                String foodId = cmd.nextToken();
                result = add(foodId);
                break;
            case "ORDER":
                result = order();
                break;
        }
        return result;
    }

    public boolean login(String userId, String password) {
        if (hasLogin)   //이미로그인했으면 거부
            return false;

        if (userInfo.containsKey(userId) && userInfo.get(userId).equals(password)) {    //유효하면 로그인 허용
            hasLogin = true;
            return true;
        } else {    //유효하지 않으면 로그인 거부
            return false;
        }
    }

    public boolean add(String foodId) {
        if (hasLogin) { //로그인한 유저라면 허용
            shoopingBasket.offer(foodId);
            return true;
        } else {    //로그인하지 않았으면 거부
            return false;
        }
    }

    public boolean order() {
        if (!shoopingBasket.isEmpty()) {    //장바구니에 음식이 있으면 허용하고 장바구니 비움
            shoopingBasket = new LinkedList<>();
            return true;
        } else {    //장바구니에 담은 음식이 없으면 거부
            return false;
        }
    }
}
