package leetcode.contest1;

/*
* 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
示例 1：
输入：text = "nlaebolko"
输出：1
示例 2：
输入：text = "loonbalxballpoon"
输出：2
示例 3：
输入：text = "leetcode"
输出：0
提示：
1 <= text.length <= 10^4
text 全部由小写英文字母组成
* */
public class Question1 {
    public static int maxNumberOfBalloons(String text) {
        if (text == null) return 0;
        String balloon = "balloon";
        char ch;
        int[] cnt = new int[5];
        //	int x = 0,y=0;

        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            switch (ch) {
                case 'b': {
                    cnt[0]++;
                    break;
                }
                case 'a': {
                    cnt[1]++;
                    break;
                }
                case 'l': {
                    cnt[2]++;
                    break;
                }
                case 'o': {
                    cnt[3]++;
                    break;
                }
                case 'n': {
                    cnt[4]++;
                    break;
                }
            }
        }
        int x = Math.min(Math.min(cnt[0], cnt[1]), cnt[4]);
        int y = Math.min(cnt[2], cnt[3]) / 2;
        //	balloon
        return Math.min(x, y);
    }

    public static void main(String[] args) {
        int n = maxNumberOfBalloons(null);
        System.out.println(n);
    }

}
