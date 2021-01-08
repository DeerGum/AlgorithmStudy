package codingTest.midasit;

public class Program2 {
    public int solution(int[][] board) {
        int answer = 0;



        int n = board.length;
        boolean[] used = new boolean[n];
        int[] cache = new int[n];
        for(int i=0;i<n;i++)
            cache[i] = -1;
        int index;
        int temp;
        int cahedIndex = 0;
        for(int i=0;i<n;i++) {
            temp = board[i][0];
            index = 0;
            for(int j=1;j<n;j++) {
                if (!used[i] && board[i][j] > temp) {
                    temp = board[i][j];
                    index = j;
                }
            }
            used[index] = true;
            cache[cahedIndex++] = index;
            answer += temp;
        }
        return answer;
    }

    public boolean isValid() {
        return false;
    }


    private class Rook {
        public int value;
        public int[] use;

        public Rook(int value, int[] use) {
            this.value = value;
            this.use = use;
        }
    }


}
