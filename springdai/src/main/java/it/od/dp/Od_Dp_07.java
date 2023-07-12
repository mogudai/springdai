package it.od.dp;

import java.util.Scanner;

public class Od_Dp_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(getResult(n, x, arr));
    }

    public static long getResult(int n, int x, int[] arr) {
        // 定义一个新数组
        int[] preSum = new int[n + 1];
        // 等于前一项和加前一项
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        int l = 0;
        int r = 1;
        long ans = 0;
        // 索引不越界 0，3,7,14
        while (r <= n) {
            // 右减左
            if (preSum[r] - preSum[l] >= x) {
                ans += n - r + 1;
                l++;
                r = l + 1;
            } else {
                r++;
            }
        }

        return ans;
    }
}
