package it.od.dp;

import java.util.Scanner;

public class Od_Dp_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(getResult(str));
    }

    public static int getResult(String str) {
        int total = str.length();
        int A = str.replaceAll("B", "").length(); // 字符串str中共有多少个A

        // 如果全B或全A，则直接返回0
        if (A == 0 || A == total) return 0;

        // 修改为全A或者全B的次数取最小值
        int ans = Math.min(A, total - A);

        int leftA = 0;
        for (int i = 0; i < total; i++) {
            if (str.charAt(i) == 'A') leftA++;
            ans = Math.min(i + 1 - leftA + A - leftA, ans);
        }

        return ans;
    }
}
