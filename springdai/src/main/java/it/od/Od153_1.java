package it.od;

import java.util.LinkedList;
import java.util.Scanner;

public class Od153_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.next()));
    }

    private static int getResult(String str) {
        // 初始化
        int maxLen = -1;
        boolean hasLetter = false;
        // 初始化左右
        int l = 0, r = 0;
        // 标记
        LinkedList<Integer> letterIdx = new LinkedList<>();

        while (r < str.length()) {
            // 右索引值
            char c = str.charAt(r);
            // 是字母
            if (isLetter(c)) {
                hasLetter = true;
                letterIdx.add(r);
                // 字母所以满足要求
                if (letterIdx.size() > 1) {
                    // 挪动左索引位置
                    l = letterIdx.removeFirst() + 1;
                }
                // 左右索引相等 右索引滑动
                if (r == l) {
                    r++;
                    continue;
                }
            }
            //  获取最大值
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        if (!hasLetter) return -1;
        return maxLen;
    }

    public static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}