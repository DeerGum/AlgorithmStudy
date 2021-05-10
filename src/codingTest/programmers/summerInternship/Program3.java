package codingTest.programmers.summerInternship;

public class Program3 {
    public static void main(String[] args) {
        Program3 p = new Program3();
        int[][] input = {{6,3,2,7,3},{7,2,1,6,8},{8,9,8,4,9},{7,9,2,7,1},{6,3,6,8,4}};
        System.out.println(p.solution(input,5,2));

    }
    public static int[][] map;
    public static int max;
    public int solution(int[][] maps, int p, int r) {
        map = maps;
        max = map.length+1;
        int result = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                result = Math.max(result,search(i,j,p,r));
            }
        }
        return result;
    }

    public int search(int row, int col, int p, int r) {
        int half = r/2;
        int result = 0;

        for (int i = row-half; i < row+half; i++) {
            for (int j = col-half; j < col+half; j++) {
                if(i < 0 || i >= map.length|| j < 0 || j >= map[i].length) //범위를 벗어나면
                    continue;
                int temp = Math.abs(i-row)+Math.abs(j-col);
                if(i < row && j < col) {    //2사분면
                    if(temp == half+1 && (map[i][j] - p/2) <= 0) { //경계선
                        result++;
                    }
                    else if(temp < half+1 && (map[i][j] - p) <= 0) {
                        result++;
                    }
                }
                else if(i >= row && j >= col) { //4사분면
                    if(temp == half-1 && (map[i][j] - p/2) <= 0) { //경계선
                        result++;
                    }
                    else if(temp < half-1 && (map[i][j] - p) <= 0) {
                        result++;
                    }
                }
                else {  //1, 3사분면
                    if(temp == half && (map[i][j] - p/2) <= 0) { //경계선
                        result++;
                    }
                    else if(temp < half && (map[i][j] - p) <= 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
