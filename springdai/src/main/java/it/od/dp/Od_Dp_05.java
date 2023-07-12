package it.od.dp;

import java.util.Scanner;

    public class Od_Dp_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getResult(n));
    }

    public static int getResult(int n) {
        int[] dp = new int[n + 1];

        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 1;
        if (n >= 3) dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }

        return dp[n];
    }
}
