package codingTest.estsoft;

public class Pro1 {
    public int solution(int[][] histogram) {
        int answer = 1;
        int rowLen = histogram.length;
        int colLen = histogram[0].length;

        for (int c = 0; c < colLen; c++) {
            int damageCnt = 0;
            boolean findDamage = false;
            for (int r = 0; r < rowLen; r++) {
                if (histogram[r][c] == 2) {
                    findDamage = true;
                    damageCnt++;
                } else if (histogram[r][c] == 0) {
                    if (findDamage) {
                        damageCnt = 0;
                        break;
                    }
                } else // histogram[r][c] == 1
                    break;
            }
            if (damageCnt != 0)
                answer *= damageCnt + 1;
        }

        return answer;
    }
}
/*


 */