package it.od.dfs;

import java.util.Scanner;

public class dfs_6 {
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

    public static boolean dfs(int cx, int cy) {
        // 索引越界
        if (cx >= x || cy >= y) return false;
        // 碰到墙
        if (matrix[cx][cy] == 1) return false;
        // 碰到
        if (matrix[cx][cy] == -1) return false;
        // 当前可达
        if (matrix[cx][cy] == 2) return true;
        // 这个点可以走，统计不能到的点
        if (matrix[cx][cy] == 0) {
            // 向东走
            boolean east = dfs(cx + 1, cy);
            // 向北走
            boolean north = dfs(cx, cy + 1);
            if (east || north) {
                matrix[cx][cy] = 2; // 如果向东可达或者向北可达，则当前点可达，将值设为2
            } else {
                matrix[cx][cy] = -1; // 如果向东，向北都不可达，则当前前也是不可达点，将值设为-1
            }
        }
        // 返回当前节点是否可达
        return matrix[cx][cy] == 2;
    }
}
