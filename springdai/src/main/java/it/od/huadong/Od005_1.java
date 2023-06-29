package it.od.huadong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Od005_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int n = sc.nextInt();

        System.out.println(getResult(arr, n));
    }

    public static int getResult(Integer[] arr, int n) {
        // count用于统计滑动窗口内各种颜色的数目
        HashMap<Integer, Integer> count = new HashMap<>();

        // 初始滑动窗口的左右边界，注意这里的右边界r是不包含的
        int l = 0;
        int r = l + n;

        // 记录滑窗内部最多颜色数量
        int max = 0;

        // 统计初始滑动窗口中各种颜色的数量
        for (int i = l; i < Math.min(r, arr.length); i++) {
            Integer c = arr[i];
            count.put(c, count.getOrDefault(c, 0) + 1);
            max = Math.max(max, count.get(c));
        }

        // 如果滑动窗口右边界未达到数组尾巴，就继续右移
        // 注意，初始滑窗的右边界r是不包含的，因此r可以直接当成下一个滑窗的右边界使用
        while (r < arr.length) {
            // 当滑动窗口右移后，新的滑动窗口相比移动前来看，新增了arr[r]，失去了arr[l]，注意此时左边界l还是指向上一个滑窗的左边界，而不是新滑窗的左边界，因此可以直接通过arr[l]取得失去的
            Integer add = arr[r++];
            Integer remove = arr[l++];

            count.put(add, count.getOrDefault(add, 0) + 1);
            count.put(remove, count.getOrDefault(remove, 0) - 1);

            // 只有新增数量的颜色可能突破最大值
            max = Math.max(max, count.get(add));
        }

        return max;
    }
}