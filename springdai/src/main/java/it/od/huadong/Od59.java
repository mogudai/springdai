package it.od.huadong;

import java.util.Arrays;
import java.util.Scanner;

//识图谱新词挖掘
public class Od59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String content = sc.next();
        String word = sc.next();

        System.out.println(getResult(content, word));
    }

    public static int getResult(String content, String word) {
        if (content.length() < word.length()) return 0;
        char[] tmp = word.toCharArray();
        // 目标排序
        Arrays.sort(tmp);
        String sorted_word = new String(tmp);
        int ans = 0;
        // 最大值
        int maxI = content.length() - word.length();
        int len = word.length();
        for (int i = 0; i <= maxI; i++) {
            //获取窗口
            char[] window = content.substring(i, i + len).toCharArray();
            Arrays.sort(window);

            if (sorted_word.equals(new String(window))) {
                ans++;
            }
        }
        return ans;
    }
}