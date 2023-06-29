package it.od.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class bfs_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            arr[i] = sc.nextInt();
        }

        int tarI = sc.nextInt();
        int tarJ = sc.nextInt();

        System.out.println(getResult(arr, m, n, tarI, tarJ));
    }

    public static int getResult(int[] arr, int m, int n, int tarI, int tarJ) {
        LinkedList<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i * n + j] > 0) {
                    // 需要扩散的队列
                    queue.addLast(new Integer[]{i, j});
                    break;
                }
            }
        }

        // 上下左右偏移量
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (queue.size() > 0) {
            // 从使用完就移除
            Integer[] pos = queue.removeFirst();
            // 节点坐标
            int i = pos[0];
            int j = pos[1];
            // 对列等级
            int x = arr[i * n + j] - 1;
            // 没有扩散能力结束
            if (x == 0) break;

            for (int[] offset : offsets) {
                int newI = i + offset[0];
                int newJ = j + offset[1];

                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && arr[newI * n + newJ] == 0) {
                    arr[newI * n + newJ] = x;
                    // 下一次扩散的队列
                    queue.addLast(new Integer[]{newI, newJ});
                }
            }
        }

        return arr[tarI * n + tarJ];
    }
}
