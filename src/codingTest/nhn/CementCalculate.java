package codingTest.nhn;

import java.util.Scanner;

/**
 * 2020 NHN 그룹사 신입 개발자 공개채용
 * 코딩테스트 2번문제
 */
class CementCalculate {
    private static void solution(int day, int width, int[][] blocks) {
        int[] work = new int[width];
        int leftPos, rightPos, cement = 0;
        for(int i=0;i<day;i++) {
            for(int j=0;j<width;j++) //블럭 쌓음
                work[j] += blocks[i][j];

            for(int j=1;j<width-1;j++) {
                leftPos = j-1;
                rightPos = j+1;

                while(true) {
                    if(leftPos-1<0)
                        break;

                    if(work[leftPos]<=work[leftPos-1])
                        leftPos--;
                    else
                        break;
                }
                while(true) {
                    if(rightPos+1>=width)
                        break;

                    if(work[rightPos]<=work[rightPos+1])
                        rightPos++;
                    else
                        break;
                }
                if(work[j]<work[leftPos] && work[j]<work[rightPos]) {
                    if (work[leftPos] > work[rightPos]) {  //더 작은 쪽만큼 시멘트 채움
                        cement += work[rightPos] - work[j]; //시멘트 갯수
                        work[j] = work[rightPos];
                    } else {
                        cement += work[leftPos] - work[j];
                        work[j] = work[leftPos];
                    }
                }
            }

        }
        System.out.println(cement);

    }


    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}
