package it.od.dfs;

import java.util.Scanner;

public class dfs_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] res = new int[n][3];
        for (int i = 0; i < n; i++) {
            res[i][0] = sc.nextInt();
            res[i][1] = sc.nextInt();
            res[i][2] = sc.nextInt();
        }

        System.out.println(getResult(n, res));
    }

    public static int getResult(int n, int[][] res) {
        int last = -1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            last = getMinEleIdx(res[i], last);
            sum += res[i][last];
        }

        return sum;
    }

    public static int getMinEleIdx(int[] arr, int excludeIdx) {
        int minEleVal = Integer.MAX_VALUE;
        int minEleIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (i == excludeIdx) continue;

            if (arr[i] <= minEleVal) {
                minEleVal = arr[i];
                minEleIdx = i;
            }
        }

        return minEleIdx;
    }
}
