package it.od.zhan;

import java.util.LinkedList;
import java.util.Scanner;

public class zhan_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getResult(str));
    }

    public static String getResult(String str) {
        // Java可以使用StringBuilder模拟栈
        StringBuilder sb = new StringBuilder();

        // idxs记录要被重复的子串的起始位置
        LinkedList<Integer> idxs = new LinkedList<>();
        // nums记录要被重复的子串的重复次数，和idxs对应
        LinkedList<Integer> nums = new LinkedList<>();
        // tmpRepeatCount记录重复次数的的字符组成
        StringBuilder tmpRepeatCount = new StringBuilder();

        // 遍历输入的字符串
        for (int i = 0; i < str.length(); i++) {
            // c是当前正在遍历的字符
            char c = str.charAt(i);

            if (c == '[') {
                // 此时tmpRepeatCount已记录完当前重复子串对应的重复次数的所有字符
                int repeatCount = Integer.parseInt(tmpRepeatCount.toString());
                nums.add(repeatCount);
                tmpRepeatCount = new StringBuilder();

                // 记录要被重复的子串的起始位置
                idxs.add(sb.length());
            } else if (c == ']') {
                // 需要被重复的子串在栈中的起始位置
                int start = idxs.removeLast();
                // 需要被重复的次数
                int repeatCount = nums.removeLast();
                // 需要被重复的子串
                String repeatStr = sb.substring(start);

                // 重复后的新串
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < repeatCount; j++) tmp.append(repeatStr);

                // 替换对应子串为重复后的新串
                sb.replace(start, sb.length(), tmp.toString());
            } else if (c >= '0' && c <= '9') {
                tmpRepeatCount.append(c);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}