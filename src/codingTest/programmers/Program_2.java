package codingTest.programmers;

public class Program_2 {
    public static String solution(String encrypted_text, String key, int rotation) {
        String[] str = new String[key.length()];
        for(int i=0;i<key.length();i++)
            str[i] = encoding(encrypted_text.charAt(i),(char)(key.charAt(i)-'`'));

        if(rotation>0) {
            for(int i=0;i<rotation;i++) {
                String temp = str[str.length-1];
                for(int j=str.length-1;j>=0;j--) {
                    if(j != 0)
                        str[j] =str[j-1];
                    else
                        str[j] = temp;
                }
            }
        }
        else {
            for(int i=0;i<=-rotation;i++) {
                String temp = str[0];
                for(int j=0;j<str.length;j++) {
                    if(j < str.length-1)
                        str[j] =str[j+1];
                    else
                        str[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String c : str)
            sb.append(c);

        return sb.toString();
    }

    public static String encoding(char c, int key) {
        //96 ~ 122
        char temp = (char)(c + key);
        if(temp > 122) {
            return Character.toString((char)(temp - 26));
        }
        else {
            return Character.toString(temp);
        }
    }

    public static void main(String[] args) {
        String temp = solution("qyyigoptvfb","abcdefghijk",3);
        System.out.println(temp);
    }
}
