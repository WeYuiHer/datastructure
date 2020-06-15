package hekui.leetcode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

/*
* 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
* */
public class Question6 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuffer[] sbs = new StringBuffer[numRows];
        int x = -1, plus = 1;
        int i = 0, len = s.length();
        for (int j = 0; j < numRows; j++) {
            sbs[j] = new StringBuffer();
        }
        while (i < len) {
            x += plus;
            if (x == numRows) {
                x = numRows - 2;
                // if(x<0)x=0;
                plus = -1;
            } else if (x == -1) {
                x = 1;
                plus = 1;
            }
            //  System.out.print(x);
            sbs[x].append(s.charAt(i));
            i++;
        }
        StringBuffer sb = new StringBuffer();
        for (i = 0; i < numRows; i++) {
            sb.append(sbs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = convert("ABCDEFG", 2);
        System.out.println();
        System.out.println(s);
    }
}
