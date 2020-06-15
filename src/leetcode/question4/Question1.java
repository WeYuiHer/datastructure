package leetcode.question4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Question1 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        char[] nums = str.toCharArray();
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        helper(nums,0,"", map);
        System.out.println(list);
    }

    public static void helper(char[] nums,int cur,String s,HashMap<Character,char[]> map){
        if(cur==nums.length){
            list.add(s);
        }else{
            char num = nums[cur];
            for(char ch:map.get(num)){
                helper(nums, cur+1, s+ch, map);
            }
        }

    }

}
