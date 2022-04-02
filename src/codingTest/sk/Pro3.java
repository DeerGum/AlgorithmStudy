package codingTest.sk;

public class Pro3 {
    public static void main(String[] args) {
        Pro3 pro3 = new Pro3();

        int test = pro3.solution(2,2,new int[][]{{1,1},{2,2}});
        System.out.println(test);
    }
    static final int MOD = 10000019;
    public int solution(int w, int h, int[][] diagonals) {
        int[][] map = new int[h+1][w+1];

        for(int i = 0; i < h; i++)
            map[i][0] = 1;

        for(int i = 0; i < w; i++)
            map[0][i] = 1;

        for(int i = 1; i < h; i++) {
            for(int j = 1; j < h; j++) {
                map[i][j] = (map[i-1][j] + map[i][j-1]);
            }
        }

        int answer = map[h-1][w-1] % MOD * diagonals.length;


        return answer;
    }
}
