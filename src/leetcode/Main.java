package leetcode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        TreeMap<Character, Integer> map = new TreeMap<>();
        while ((str = sc.nextLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        Set<Character> set = map.keySet();
        for (char key : set)
            System.out.print(key + map.get(key));
    }
}
