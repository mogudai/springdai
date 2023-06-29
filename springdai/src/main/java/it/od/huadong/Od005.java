package it.od.huadong;

import java.util.*;

// 100分  最多颜色的车辆
public class Od005 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] arr =
                Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int n = in.nextInt();
        System.out.println(getResult(arr, n));
    }

    private static int getResult(Integer[] arr, int n) {
        int max = 0;
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!integers.contains(arr[i])) {
                integers.add(arr[i]);
            }
        }
        int[] arrFlag = new int[integers.size()];
        Arrays.fill(arrFlag, 0);

        int l = 0, r = n - 1;
        // n>leng
        if (n > arr.length) {
            r = arr.length - 1;
        }
        // 初始化第一个窗口
        for (int i = 0; i <= r; i++) {
            arrFlag[arr[i]]++;
        }
        while (true) {
            for (int i = 0; i < arrFlag.length; i++) {
                max = Math.max(max, arrFlag[i]);
            }
            l++;
            r++;
            if (r == arr.length) {
                break;
            }
            int k = l - 1;
            //移除左索引
            arrFlag[arr[k]]--;
            //加上右索引
            arrFlag[arr[r]]++;
        }
        return max;
    }
}
