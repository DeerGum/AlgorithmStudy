package codingTest.programmers.grap;

public class Program3 {
    static int N;
    static char[][] board;
    static int count;

    public static void main(String[] args) {
        Program3 p = new Program3();
        int temp = p.solution("BAB", new String[]{"ZZBZ", "BAZB", "XBXB", "XBAX"});
        System.out.println(temp);
    }
    public int solution(String word, String[] cards) {
        count = 0;
        N = cards.length;
        board = new char[N][N];
        for (int i = 0; i < N; i++)
            board[i] = cards[i].toCharArray();

        search(word, 0, 0, new boolean[N], new boolean[word.length()]);

        return count;
    }

    public void search(String word, int row, int idx, boolean[] visitedCol, boolean[] wordUse) {
        if (idx == word.length()) {
            count++;
            return;
        }

        if (row >= N)
            return;

        for (int i = 0; i < N; i++) {
            if (visitedCol[i])
                continue;
            int findIdx = isFind(word, board[row][i], wordUse);
            if (findIdx >= 0) {
                visitedCol[i] = true;
                wordUse[findIdx] = true;
                search(word, row+1, idx+1, visitedCol, wordUse);
                wordUse[findIdx] = false;
                visitedCol[i] = false;
            }
        }
        search(word, row+1, idx, visitedCol, wordUse);
    }

    public int isFind(String word, char c,boolean[] wordUse) {
        for (int i = 0; i < word.length(); i++) {
            if (!wordUse[i] && word.charAt(i) == c)
                return i;
        }
        return -1;
    }
}
