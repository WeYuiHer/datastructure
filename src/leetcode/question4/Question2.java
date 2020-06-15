package leetcode.question4;

import java.util.Scanner;

public class Question2 {
    //IPv4,   IPv6,   Neither
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str.contains(".")){
            String[] split = str.split("\\.");
            if(split.length==4){
                for(int i=0;i<4;i++){
                    String s = split[i];
                    if(s.startsWith("0")){
                        System.out.println("Neither");
                        return;
                    }
                    int x = Integer.parseInt(s);
                    if(x>=255){
                        System.out.println("Neither");
                        return;
                    }
                }
                System.out.println("IPv4");
            }else{
                System.out.println("Neither");
                return;
            }
        }else if(str.contains(":")){
            String[] split = str.split(":");
            if(split.length!=8){
                System.out.println("Neither");
                return;
            }else{
                for(int i=0;i<8;i++){
                    String s = split[i];
                    if(s==null||s.length()==0||(s.startsWith("0")&&s.length()>1&&s.charAt(1)=='0')){
                        System.out.println("Neither");
                        return;
                    }
                    for(int j=0;j<s.length();j++){
                        char c = s.charAt(j);
                        if(!((c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z'))){
                            System.out.println("Neither");
                            return;
                        }
                    }
                }
                System.out.println("IPv6");
            }
        }else{
            System.out.println("Neither");
        }
    }

}
