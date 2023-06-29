package it.od.huisu;

import java.util.Scanner;

public class HuiSu_1_1 {
    //
    static String[] matrix;
    // 目标单词
    static String word;
    // 二维数组
    static int n;
    static int m;
    // 标记
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        word = sc.next();

        matrix = new String[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.next();
        }

        System.out.println(getResult());
    }

    public static String getResult() {
        // 初始化标记
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0)) {
                    return (i + 1) + "" + (j + 1);
                }
            }
        }
        return "NO";
    }

    private static boolean dfs(int i, int j, int k) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || matrix[i].charAt(j) != word.charAt(k)) {
            return false;
        }
        visited[i][j] = true;
        int p = k + 1;
        boolean res = dfs(i - 1, j, p) || dfs(i + 1, j, p) || dfs(i, j - 1, p) || dfs(i, j + 1, p);
        visited[i][j] = false;
        return res;
    }
}
