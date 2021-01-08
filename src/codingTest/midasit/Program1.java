package codingTest.midasit;

public class Program1 {

    public static int solution(int[] openA, int[] closeB) {
        int count = 0;
        boolean isOpen = false;
        int indexA = 0, indexB = 0;
        for(int i=1;i<closeB[closeB.length-1];i++) {

            if(indexA < openA.length && openA[indexA] == i) {
                isOpen = true;
                indexA++;
            }
            if(indexB < closeB.length &&closeB[indexB] == i) {
                isOpen = false;
                indexB++;
            }
            if(isOpen)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {3,5,7};
        int[] B = {4,10,12};

        System.out.println(solution(A,B));
    }
}
