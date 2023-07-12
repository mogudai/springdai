package it.od.dp;

import java.util.Scanner;

public class Od_Dp_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(getResult(lines[i]));
        }
    }

    public static String getResult(String str) {
        int n = str.length();

        // 初始化a数组
        long[] a = new long[n];
        if (n > 0) a[0] = 1;
        if (n > 1) a[1] = 2;
        if (n > 2) a[2] = 4;
        if (n > 3) {
            for (int i = 3; i < n; i++) {
                a[i] = a[i - 1] + a[i - 2] + a[i - 3];
            }
        }

        // 为字符串的每一位字符添加a[i]偏移量
        char[] cArr = str.toCharArray();
        for (int i = 0; i < n; i++) {
            cArr[i] = (char) ((a[i] + cArr[i] - 97) % 26 + 97);
        }
        return new String(cArr);
    }
}
