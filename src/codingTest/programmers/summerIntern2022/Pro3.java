package codingTest.programmers.summerIntern2022;

import java.util.HashMap;

public class Pro3 {
    HashMap<Character,int[]> keyPos;
    static int[] leftPos;
    static int[] rightPos;
    public int[] solution(String line) {
        init();
        int[] answer = new int[line.length()];

        for (int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);
            int[] pos = keyPos.get(key);
            if (typing(pos) == 0) {
                leftPos = pos;
                answer[i] = 0;
            } else {
                rightPos = pos;
                answer[i] = 1;
            }
        }

        return answer;
    }

    public void init() {
        leftPos = new int[] {1,0};
        rightPos = new int[] {1,9};
        keyPos = new HashMap<>();
        keyPos.put('1',new int[] {0,0});
        keyPos.put('2',new int[] {0,1});
        keyPos.put('3',new int[] {0,2});
        keyPos.put('4',new int[] {0,3});
        keyPos.put('5',new int[] {0,4});
        keyPos.put('6',new int[] {0,5});
        keyPos.put('7',new int[] {0,6});
        keyPos.put('8',new int[] {0,7});
        keyPos.put('9',new int[] {0,8});
        keyPos.put('0',new int[] {0,9});
        keyPos.put('Q',new int[] {1,0});
        keyPos.put('W',new int[] {1,1});
        keyPos.put('E',new int[] {1,2});
        keyPos.put('R',new int[] {1,3});
        keyPos.put('T',new int[] {1,4});
        keyPos.put('Y',new int[] {1,5});
        keyPos.put('U',new int[] {1,6});
        keyPos.put('I',new int[] {1,7});
        keyPos.put('O',new int[] {1,8});
        keyPos.put('P',new int[] {1,9});
    }

    public int typing(int[] pos) {
        int leftDis = distance(pos, leftPos);
        int rightDis = distance(pos, rightPos);
        int hDisLeft = hDistance(pos, leftPos);
        int hDisRight = hDistance(pos, rightPos);

        if (leftDis < rightDis)
            return 0;
        else if (leftDis > rightDis)
            return 1;
        else {
            if (hDisLeft < hDisRight)
                return 0;
            else if (hDisLeft > hDisRight)
                return 1;
            else {
                if (pos[1] <= 4)
                    return 0;
                else
                    return 1;
            }
        }
    }

    public int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int hDistance(int[] p1, int[] p2) {
        return Math.abs(p1[1] - p2[1]);
    }
}
