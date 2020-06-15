package leetcode.question;

public class Question383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || magazine.length() == 0)
            return ransomNote == null || ransomNote.length() == 0;
        int[] arr = new int[26];
        char[] chars = magazine.toCharArray();
        for (char ch : chars) {
            arr[ch - 'a']++;
        }
        chars = ransomNote.toCharArray();
        for (char ch : chars) {
            if (arr[ch - 'a'] == 0)
                return false;
            else
                arr[ch - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }

}
