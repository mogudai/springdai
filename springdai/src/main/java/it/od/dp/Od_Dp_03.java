package it.od.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Od_Dp_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    public static int getResult(Integer[] arr) {
        int n = arr.length;

        // dp[i]表示：第i时刻可得的正向分
        int[] dp = new int[n];
        dp[0] = arr[0];

        // delay[i]表示：第i时刻被扣除的负向分
        int[] delay = new int[n];
        delay[0] = 0;

        // score[i]表示：第i时刻最终得分
        int[] score = new int[n];
        score[0] = arr[0];

        for (int i = 1; i < n; i++) {
            // 正向得分
            dp[i] = Math.min(100, dp[i - 1] + arr[i]); // 最多上报100条
            // 负向得分
            delay[i] = delay[i - 1] + dp[i - 1];
            // 总得分
            score[i] = dp[i] - delay[i];

            // 达到100条时必须上报，此时完成首次上报，结束循环
            if (dp[i] >= 100) break;
        }

        return Arrays.stream(score).max().getAsInt();
    }
}
