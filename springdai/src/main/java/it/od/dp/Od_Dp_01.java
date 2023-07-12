package it.od.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Od_Dp_01 {
    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    // 算法入口
    public static int getResult(Integer[] arr) {
        int n = arr.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0] = Math.max(0, arr[0]);
            } else if (i < 3) {
                dp[i] = Math.max(0, dp[i - 1] + arr[i]);
            } else {
                dp[i] = Math.max(dp[i - 3], dp[i - 1] + arr[i]);
            }
        }

        return dp[n - 1];
    }
}
