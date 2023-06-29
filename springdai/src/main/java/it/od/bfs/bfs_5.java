package it.od.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class bfs_5 {
    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        getResult(arr);
    }

    // 算法入口
    public static void getResult(Integer[] arr) {
        int n = (int) Math.sqrt(arr.length);
        int total = arr.length;

        LinkedList<Integer[]> queue = new LinkedList<>();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[n * i + j];
                if (matrix[i][j] == 1) {
                    queue.add(new Integer[] {i, j});
                    total--;
                }
            }
        }

        if (queue.size() == 0 || queue.size() == arr.length) {
            System.out.println(-1);
            return;
        }

        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (queue.size() > 0 && total > 0) {
            Integer[] tmp = queue.removeFirst();
            int i = tmp[0];
            int j = tmp[1];

            int num = matrix[i][j];

            for (int[] offset : offsets) {
                int newI = i + offset[0];
                int newJ = j + offset[1];

                if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && matrix[newI][newJ] == 0) {
                    matrix[newI][newJ] = num + 1;
                    queue.add(new Integer[] {newI, newJ});
                    total--;
                    if (total == 0) {
                        System.out.println(num);
                        return;
                    }
                }
            }
        }
    }
}
