package codingTest.nhn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020 NHN 그룹사 신입 개발자 공개채용
 * 코딩테스트 1번문제
 */
class TowelSpinningGame {
    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
        char[] players = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int[] taggerCount = new int[26];
        char gameTagger = players[0];
        char[] gamePlayers = Arrays.copyOfRange(players,1,numOfAllPlayers);
        int cursor = 0;
        taggerCount[0]++;   //술래 카운트

        for(int k=0;k<numOfGames;k++) {
            cursor = transIndex(cursor,numOfMovesPerGame[k],gamePlayers.length);    //술래 이동
            //잡힌 플레이어가 퀵플레이어가 아니면 술래 변경
            if(!isQuickPlayer(gamePlayers[cursor],namesOfQuickPlayers)) {
                char temp = gamePlayers[cursor];
                gamePlayers[cursor] = gameTagger;
                gameTagger = temp;
            }
            taggerCount[gameTagger-65]++;
        }

        for(int i=0;i<gamePlayers.length;i++)
            System.out.println(gamePlayers[i]+" "+taggerCount[gamePlayers[i]-65]);

        System.out.println(gameTagger+" "+taggerCount[gameTagger-65]);
    }

    private static Boolean isQuickPlayer(char player, char[] namesOfQuickPlayers) {
        for(int i=0;i<namesOfQuickPlayers.length;i++) {
            if(player==namesOfQuickPlayers[i])
                return true;
        }
        return false;
    }

    private static int transIndex(int cursor, int moveIndex, int arrSize) {
        if(moveIndex>0) {
            for(int i=0;i<moveIndex;i++) {
                cursor++;
                if(cursor == arrSize)
                    cursor = 0;
            }
        }
        else {
            for(int i=0;i<-moveIndex;i++) {
                cursor--;
                if(cursor == -1)
                    cursor = arrSize-1;
            }
        }
        return cursor;

    }

    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for(int i = 0; i < inputData.numOfGames ; i++){
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }
}