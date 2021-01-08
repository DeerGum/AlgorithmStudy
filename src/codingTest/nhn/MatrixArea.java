package codingTest.nhn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 2020 NHN 그룹사 신입 개발자 공개채용
 * 코딩테스트 연습문제
 */
class MatrixArea {
    private static void solution(int sizeOfMatrix, int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        for(int i=0;i<sizeOfMatrix;i++) {
            for(int j=0;j<sizeOfMatrix;j++) {
                if(matrix[i][j]==1) {
                    count = dfs(i,j,matrix,count);
                    result.add(count);
                    count = 0;
                }
            }
        }
        if(!result.isEmpty()) {
            Collections.sort(result);
            System.out.println(result.size());
            for (Integer integer : result) System.out.print(integer + " ");
        }
        else
            System.out.println(0);
    }

    private static int dfs(int row, int col, int[][] matrix, int count) {
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        count++;
        matrix[row][col] = -1;
        for(int k=0;k<dir.length;k++) {
            int r = row+dir[k][0];
            int c = col+dir[k][1];

            if(r >= matrix.length || r < 0 || c < 0 || c >= matrix.length)
                continue;
            if(matrix[r][c] == -1 || matrix[r][c] == 0)
                continue;
            //matrix[r][c] == 1
            count = dfs(r,c,matrix,count);
        }
        return count;
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);

    }
}