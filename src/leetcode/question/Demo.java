package leetcode.question;

import java.io.*;

public class Demo {

    public static void main(String[] args) throws IOException {
        //输入
        File inPath = new File("e://in.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inPath)));
        String line = "";
        int num;
        //输出
        File outPath = new File("e://out.txt");
        if (!outPath.exists())
            outPath.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath)));
        while ((line = reader.readLine()) != null) {
            num = Integer.parseInt(line);
            System.out.println(num);
            writer.write(line + "\n");
        }
        reader.close();
        writer.close();
    }


}
