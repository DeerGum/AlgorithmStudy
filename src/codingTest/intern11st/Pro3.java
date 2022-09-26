package codingTest.intern11st;

import java.util.*;

public class Pro3 {
    public static void main(String[] args) {
        Pro3 pro3 = new Pro3();
        String str = pro3.solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11");
        System.out.println(str);
    }
    public String solution(String S) {
        String[] input = S.split("\\n");
        int M = input.length;
        ArrayList<Photo> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input[i], ",");
            String[] tmp = st.nextToken().trim().split("\\.");
            String name = tmp[0];
            String extension = tmp[1];
            String city = st.nextToken().trim();
            String dateTime = st.nextToken().trim();

            Photo photo = new Photo(name, extension, city, dateTime);
            list.add(photo);
        }

        HashSet<String> citys = new HashSet<>();    //도시이름 set
        for (Photo p : list)
            citys.add(p.city);

        String[] cityNames = new String[citys.size()];  //도시이름 배열
        citys.toArray(cityNames);

        HashMap<String, Integer> nameToIdx = new HashMap<>();   //도시 이름을 key로 도시이름배열의 인덱스를 저장하는 해쉬맵
        for (int i = 0; i < citys.size(); i++)
            nameToIdx.put(cityNames[i], i);

        PriorityQueue<Photo>[] task = new PriorityQueue[citys.size()];
        for (int i = 0; i < citys.size(); i++)
            task[i] = new PriorityQueue<>();

        for (Photo p : list)    //task 우선순위큐에 도시별로 사진 넣음
            task[nameToIdx.get(p.city)].add(p);

        for (int i = 0; i < task.length; i++) {
            int photoCnt = task[i].size();
            int digitLen = String.valueOf(photoCnt).length();
            int number = 1;
            while (!task[i].isEmpty()) {
                Photo curr = task[i].poll();
                curr.name = String.format("%s%0" + digitLen + "d", curr.city, number++);    //사진 이름 수정
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Photo p : list)
            sb.append(p.name+"."+p.extension+"\n");

        return sb.toString();
    }

    static class Photo implements Comparable<Photo> {
        String name;
        String extension;
        String city;
        String dateTime;

        public Photo(String name, String extension, String city, String dateTime) {
            this.name = name;
            this.extension = extension;
            this.city = city;
            this.dateTime = dateTime;
        }

        @Override
        public int compareTo(Photo o) {
            return this.dateTime.compareTo(o.dateTime);
        }
    }
}
