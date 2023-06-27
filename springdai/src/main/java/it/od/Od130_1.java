package it.od;

import java.util.Arrays;
import java.util.Scanner;

public class Od130_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        int sum = Integer.parseInt(sc.nextLine());
        System.out.println(getResult(arr, sum));
    }

    public static int getResult(Integer[] arr, int sum) {
        int ans = -1;
        if (sum <= 0) return ans;
        int l = 0;
        int r = 0;
        int n = arr.length;
        // 初始化窗口
        int total = arr[l];
        while (true) {
            // 如果总值大于 和
            if (total > sum) {
                // 左索引右移
                l++;
                // 减去原来的值
                total -= arr[l - 1];
                // 如果 左索引没有越界，并且没有超过右索引
                if (l < n && r < l) {
                    // 左右索引同步
                    r = l;
                    // 更新总值
                    total += arr[r];
                }
            }
            // 如果 小于和
            else if (total < sum) {
                // 右索引移动
                r++;
                // 如果右索引没有越界，更新总值
                if (r < n) total += arr[r];
                    // 否则结束
                else break;
            } else {
                // 如果总值相等 更新窗口长度
                ans = Math.max(ans, r - l + 1);
                // 左右所以都右移
                l++;
                r++;
                //  如果索引没有越界，更新总值
                if (r < n) total += arr[r] - arr[l - 1];
                else break;
            }
        }
        return ans;
    }
}