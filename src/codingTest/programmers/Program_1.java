package codingTest.programmers;

public class Program_1 {
    public String solution(int n, int[][] delivery) {
        String[] check = new String[n];
        for(int i=0;i<n;i++)
            check[i] = "?";

        for(int i=0;i<delivery.length;i++) {
            if(delivery[i][2] == 1) {
                check[delivery[i][0]-1] = "O";
                check[delivery[i][1]-1] = "O";
            }
        }

        for(int i=0;i<delivery.length;i++) {
            if(delivery[i][2] == 0) {
                if(check[delivery[i][0]-1].equals("O"))
                    check[delivery[i][1]-1] = "X";
                else if(check[delivery[i][1]-1].equals("O"))
                    check[delivery[i][0]-1] = "X";
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append(check[i]);

        return sb.toString();
    }
}
