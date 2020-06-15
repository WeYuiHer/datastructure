package newcoder.website.jzoffer;

/*
 * 请实现一个函数，
 * 将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * */
public class ReplaceSpace {

    public static String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                str.insert(i, "%20");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = replaceSpace(new StringBuffer("We are happy"));

        System.out.println(s);

    }

}
