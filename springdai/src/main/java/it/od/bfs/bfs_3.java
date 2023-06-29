package it.od.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class bfs_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    public static int getResult(Integer[] arr) {
        // 题目说会输入n*n个值
        int n = (int) Math.sqrt(arr.length);

        // 将一维arr输入转为二维矩阵matrix
        int[][] matrix = new int[n][n];

        // 将矩阵中所有感染区域位置记录到queue中,这里选择queue先进先出的原因是保证当天的感染区域并发扩散
        LinkedList<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[i * n + j];
                if (matrix[i][j] == 1) queue.add(new Integer[] {i, j});
            }
        }

        // 全是感染区，或全是健康区
        if (queue.size() == 0 || queue.size() == arr.length) {
            return -1;
        }

        // 健康区个数
        int healthy = arr.length - queue.size();

        // 上下左右偏移量
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // day用于统计感染全部花费的时间，理论上应该从1开始统计，但是这里从2开始统计，因此最终结果要减去1，为什么从2开始统计，是因为这里的day既要统计天数，也要用于标记感染区，由于1已经被标记为感染区，因此新的感染区只能从2开始标记
        int day = 0;
        // 如果健康区个数为0，说明感染完了
        while (queue.size() > 0 && healthy > 0) {
            LinkedList<Integer[]> newQue = new LinkedList<>();

            // 遍历完当前queue的所有感染区，即过去一天
            for (Integer[] tmp : queue) {
                int x = tmp[0], y = tmp[1];

                for (int[] offset : offsets) {
                    int newX = x + offset[0];
                    int newY = y + offset[1];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && matrix[newX][newY] == 0) {
                        matrix[newX][newY] = 1;
                        healthy--;
                        // 新增感染区加到newQue中，不影响queue的当前遍历
                        newQue.add(new Integer[] {newX, newY});
                    }
                }
            }

            day++;
            queue = newQue;
        }

        return day;
    }
}
