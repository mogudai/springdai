package it.od.huisu;

import java.util.LinkedList;
import java.util.Scanner;

public class Od100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 获取数组
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(matrix, n));
    }

    public static int getResult(int[][] matrix, int n) {
        // 标记数组
        boolean[] used = new boolean[n];
        // 路径索引
        LinkedList<Integer> path = new LinkedList<>();
        // 初始化最大值
        int[] ans = {Integer.MAX_VALUE};
        // 递归开始
        dfs(n, used, path, ans, matrix);

        return ans[0];
    }

    public static void dfs(
            int n, boolean[] used, LinkedList<Integer> path, int[] ans, int[][] matrix) {
        // 满足条件 除开自己
        if (path.size() == n - 1) {
            // 从第一个基站到下个基站的累加值
            int dis = matrix[0][path.get(0)];
            // 计算路径累加值
            for (int i = 0; i < path.size() - 1; i++) {
                int p = path.get(i);
                int c = path.get(i + 1);
                dis += matrix[p][c];
            }
            // 获取
            dis += matrix[path.getLast()][0];
            // 记录最小值
            ans[0] = Math.min(ans[0], dis);
            return;
        }
        // 循环
        for (int i = 1; i < n; i++) {
            // 这一行是否标记
            if (!used[i]) {
                // 添加路径索引
                path.push(i);
                // 标记
                used[i] = true;
                // 递归
                dfs(n, used, path, ans, matrix);
                // 解除标记
                used[i] = false;
                // 移除第一个
                path.pop();
            }
        }
    }
}