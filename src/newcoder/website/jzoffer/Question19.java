package newcoder.website.jzoffer;


import java.util.Arrays;
import java.util.LinkedList;

/*
 * 例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * */
public class Question19 {

    public static String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return str;
        LinkedList<String> list = new LinkedList<>();
        int i = str.length() - 1;
        char[] chars = str.toCharArray();
        //System.out.println(Arrays.toString(chars));
        while (i >= 0) {
            char ch = chars[i];
            StringBuffer sb = new StringBuffer();
            while (i >= 0 && ch != ' ') {
                sb.insert(0, ch);
                // System.out.println("insert " +ch+"   " + sb.toString()+"  i = "+i);
                i--;
                if (i >= 0)
                    ch = chars[i];
            }
            list.add(new String(sb.toString()));
            StringBuffer sb2 = new StringBuffer();
            while (i >= 0 && ch == ' ') {
                sb2.append(' ');
                i--;
                if (i >= 0)
                    ch = chars[i];
            }
            list.add(new String(sb2.toString()));
        }
        StringBuffer ss = new StringBuffer();
        for (String s : list)
            ss.append(s);
        String ans = ss.toString();
        return ans;
    }

    public static void main(String[] args) {
        String s = ReverseSentence("student. a am I");
        System.out.println(s);
    }

}
