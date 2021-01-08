package codingTest.codeforce.prevCode;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Program_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n;
        LinkedList<Integer> odd;
        LinkedList<Integer> even;
        int scoreA, scoreB;
        boolean turnAlice;
        for(int l=0;l<t;l++) {
            n = Integer.parseInt(br.readLine());

            odd = new LinkedList<>();
            even = new LinkedList<>();
            scoreA = 0;
            scoreB = 0;

            st = new StringTokenizer(br.readLine());
            for(int i =0;i<n;i++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp%2 == 0)
                    even.add(temp);
                else
                    odd.add(temp);
            }

            Collections.sort(even);
            Collections.sort(odd);
            turnAlice = true;
            while(!odd.isEmpty() && !even.isEmpty()) {
                int oddVal = odd.getLast();
                int evenVal = even.getLast();

                if(oddVal > evenVal) {
                    if(!turnAlice)
                        scoreB += oddVal;
                    odd.removeLast();
                }
                else if(oddVal == evenVal){
                    if(turnAlice) {
                        scoreA += evenVal;
                        even.removeLast();
                    }
                    else {
                        scoreB += oddVal;
                        odd.removeLast();
                    }
                }
                else {
                    if(turnAlice)
                        scoreA += evenVal;
                    even.removeLast();
                }
                turnAlice = !turnAlice;
            }

            while(!odd.isEmpty()) {
                int oddVal = odd.removeLast();
                if(!turnAlice)
                    scoreB += oddVal;
                turnAlice = !turnAlice;
            }

            while(!even.isEmpty()) {
                int evenVal = even.removeLast();
                if(turnAlice)
                    scoreA += evenVal;
                turnAlice = !turnAlice;
            }

            if(scoreA > scoreB)
                bw.write("Alice");
            else if(scoreA == scoreB)
                bw.write("Tie");
            else
                bw.write("Bob");
            bw.newLine();
        }
        bw.flush();
    }
}
