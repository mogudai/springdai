package it.od.huadong;

import java.util.Scanner;
//滑动窗口最大和
public class huadong_2 {
    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        System.out.println(getResult(n, arr, m));
    }

    // 算法入口
    public static int getResult(int n, int[] arr, int m) {
        int sum = 0;
        for (int i = 0; i < m; i++) { // 初始滑窗内部和
            sum += arr[i];
        }

        int ans = sum;

        for (int i = 1; i <= n - m; i++) {
            sum += arr[i + m - 1] - arr[i - 1]; // 基于初始滑窗进行差异求和，避免O(n)求和
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}