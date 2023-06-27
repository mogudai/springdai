package it.od;

import leetcode.editor.cn.maxProduct;

import java.util.Scanner;

public class Od150 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] split = next.split(",");
        int i = maxProduct(split);
        System.out.println(i);
    }

    public static int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            // 第一个字符
            String indexStr = words[i];
            int count = 0;
            for (int j = i + 1; j < words.length; j++) {
                // 下一个字符
                String nextStr = words[j];
                String[] strings = nextStr.split("");
                for (int k = 0; k < strings.length; k++) {
                    // 第一个字符是否包含下一个字符串中的字符
                    if (indexStr.contains(strings[k])) {
                        count++;
                    }
                }
                if (count == 0) {
                    int i1 = nextStr.length() * indexStr.length();
                    max= Math.max(i1,max);
                }
                count =0;
            }
        }
        return max;
    }
}
