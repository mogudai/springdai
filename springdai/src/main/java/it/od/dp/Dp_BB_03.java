package it.od.dp;

import java.util.Scanner;

public class Dp_BB_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(getResult(n, arr));
    }

    public static int getResult(int n, int[] arr) {
        int bag = 1474560 / 512; // 背包承重（块）

        int[][] dp = new int[n + 1][bag + 1];

        for (int i = 1; i <= n; i++) {
            int weight = (int) Math.ceil(arr[i - 1] / 512.0); // 物品的重量（块）
            int worth = arr[i - 1]; // 物品的价值（字节）
            for (int j = 0; j <= bag; j++) {
                if (weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + worth);
                }
            }
        }

        return dp[n][bag];
    }
}
