package codingTest.intern11st;

public class Pro1 {
    public int solution(int A, int B) {
        String a = String.valueOf(A);
        String b = String.valueOf(B);

        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == a.charAt(0)) {
                boolean isSame = false;
                for (int j = 0; j < a.length() && i+j < b.length(); j++) {
                    if (a.charAt(j) != b.charAt(i+j))
                        break;

                    if (j == a.length()-1)
                        isSame = true;
                }
                if (isSame)
                    return i;
            }
        }
        return -1;
    }
}
