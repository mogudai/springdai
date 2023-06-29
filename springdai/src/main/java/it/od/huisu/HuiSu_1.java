package it.od.huisu;

import java.util.Scanner;

public class HuiSu_1 {
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
        // 二维遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 满足条件
                if (backTracking(i, j, 0)) {
                    // 返回索引
                    return (i + 1) + " " + (j + 1);
                }
            }
        }
        return "NO";
    }

    public static boolean backTracking(int i, int j, int k) {
        // 结束这一行
        if (k == word.length()) return true;
        //  左右不能越界，字符不能被使用，一行字符的某个是否是目标字符
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || matrix[i].charAt(j) != word.charAt(k)) {
            return false;
        }
        // 标记
        visited[i][j] = true;
        // 索引相加
        int newK = k + 1;
        // 上下左右回溯
        boolean res =
                backTracking(i - 1, j, newK)
                        || backTracking(i + 1, j, newK)
                        || backTracking(i, j - 1, newK)
                        || backTracking(i, j + 1, newK);
        // 剪去枝叶
        visited[i][j] = false;
        return res;
    }
}