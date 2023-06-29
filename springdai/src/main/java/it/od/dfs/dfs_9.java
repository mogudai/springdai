package it.od.dfs;

import java.util.Scanner;

public class dfs_9 {
    static int n;
    static int m;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult());
    }

    public static int getResult() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j, 0));
            }
        }

        return ans;
    }

    public static int dfs(int i, int j, int count) {
        if (i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] == 0) {
            return count;
        }

        count++;
        matrix[i][j] = 0;

        count = dfs(i - 1, j, count);
        count = dfs(i + 1, j, count);
        count = dfs(i, j - 1, count);
        count = dfs(i, j + 1, count);

        return count;
    }
}
