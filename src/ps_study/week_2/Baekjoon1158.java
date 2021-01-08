package ps_study.week_2;

import java.io.*;
import java.util.*;

public class Baekjoon1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input =  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        int temp = 0;

        LinkedList<Integer> list = new LinkedList<>();
        ListIterator<Integer> cursor;

        for(int i=0;i<n;i++)
            list.add(i+1);
        cursor = list.listIterator();

        bw.write("<");
        while(!list.isEmpty()) {
            for(int i=0;i<k;i++) {
                if(!cursor.hasNext())
                    cursor = list.listIterator();
                temp = cursor.next();
            }
            cursor.remove();
            bw.write(String.valueOf(temp));
            if(!list.isEmpty())
                bw.write(", ");
            else
                bw.write(">\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
