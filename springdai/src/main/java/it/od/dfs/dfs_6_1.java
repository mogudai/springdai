package it.od.dfs;

import java.util.Scanner;

public class dfs_6_1 {

    static int x;
    static int y;
    static int n;
    static int[][] poses;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt(); // 行数
        y = sc.nextInt(); // 列数
        n = sc.nextInt(); // 墙数

        poses = new int[n][2]; // 墙位置
        for (int i = 0; i < n; i++) {
            poses[i][0] = sc.nextInt();
            poses[i][1] = sc.nextInt();
        }

        getResult();
    }

    public static void getResult() {
        matrix = new int[x][y];

        for (int[] pos : poses) {
            int i = pos[0];
            int j = pos[1];
            matrix[i][j] = 1; // 墙点值为1，非墙点值为0
        }
        // 终点
        matrix[x - 1][y - 1] = 2; // 可达点值为2
        // 深度搜索标记
        dfs(0, 0);

        int trap = 0; // 陷阱数量
        int unreach = 0; // 不可达点数量

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) unreach++;
                else if (matrix[i][j] == -1) trap++;
            }
        }

        System.out.println(trap + " " + unreach);
    }

    private static boolean dfs(int d, int b) {
        if (d >= x || b >= y) return false;
        if (matrix[d][b] == -1) return false;
        if (matrix[d][b] == 1) return false;
        if (matrix[d][b] == 2) return true;
        if (matrix[d][b] == 0) {
            boolean dfs = dfs(d + 1, b);
            boolean dfs1 = dfs(d, b + 1);
            if (dfs || dfs1) {
                matrix[d][b] = 2;
            } else {
                matrix[d][b] = -1;
            }
        }
        return matrix[d][b] == 2;
    }

}
