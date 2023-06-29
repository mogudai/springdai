package it.od.dfs;

import java.util.LinkedList;
import java.util.Scanner;

public class dfs_11_1 {
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        getResult(n, m, matrix);
    }

    public static void getResult(int n, int m, int[][] matrix) {
        LinkedList<String> ans = new LinkedList<>();
        dfs(0, 0, new LinkedList<>(), ans, n, m, matrix);
        ans.add("(" + (n - 1) + "," + (m - 1) + ")");

        for (String an : ans) {
            System.out.println(an);
        }
    }

    public static void dfs(
            int x, int y, LinkedList<String> path, LinkedList<String> ans, int n, int m, int[][] matrix) {
        if (x == n - 1 && y == m - 1) {
            ans.addAll(path);
            return;
        }

        for (int[] offset : offsets) {
            int newX = x + offset[0];
            int newY = y + offset[1];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] == 0) {
                path.add("(" + x + "," + y + ")");
                matrix[x][y] = 2;
                dfs(newX, newY, path, ans, n, m, matrix);
                path.removeLast();
            }
        }
    }
}
