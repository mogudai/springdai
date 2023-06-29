package it.od.dfs;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

public class dfs_13 {
    static int n;
    static String[][] matrix;
    static String tar;

    public static void main(String[] args) {
        // 将输入分隔符改为“,”和换行
        Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");

        n = sc.nextInt();

        matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.next();
            }
        }

        tar = sc.next();

        System.out.println(getResult());
    }

    public static String getResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                LinkedList<Integer[]> path = new LinkedList<>();
                if (dfs(i, j, 0, path)) {
                    StringJoiner sj = new StringJoiner(",");
                    for (Integer[] pos : path) sj.add(pos[0] + "," + pos[1]);
                    return sj.toString();
                }
            }
        }
        return "N";
    }

    public static boolean dfs(int i, int j, int k, LinkedList<Integer[]> path) {
        // 判断字符是否越界，是否是当前要判断的字符
        if (i < 0 || i >= n || j < 0 || j >= n || !tar.substring(k, k + 1).equals(matrix[i][j])) {
            return false;
        }
        // 添加路径
        path.add(new Integer[]{i, j});
        // 是否找的到
        if (path.size() == tar.length()) return true;

        String tmp = matrix[i][j];
        matrix[i][j] = null;
        // 深度搜索
        boolean res =
                dfs(i - 1, j, k + 1, path)
                        || dfs(i + 1, j, k + 1, path)
                        || dfs(i, j - 1, k + 1, path)
                        || dfs(i, j + 1, k + 1, path);
        if (!res) {
            // 没有找到 还原
            matrix[i][j] = tmp;
            // 减去枝叶
            path.removeLast();
        }

        return res;
    }
}
