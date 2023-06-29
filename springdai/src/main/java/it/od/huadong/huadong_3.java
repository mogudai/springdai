package it.od.huadong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

// 用连续自然数之和来表达整数
public class huadong_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getResult(sc.nextInt());
    }

    public static void getResult(int t) {
        int[] arr = new int[t];
        // 初始化一个从1到t 的数组
        for (int i = 0; i < t; i++) arr[i] = i + 1;
        // 序列
        ArrayList<int[]> ans = new ArrayList<>();
        //初始化索引
        int l = 0;
        int r = 1;
        // 初始累加值
        int sum = arr[l];
        // 左左索引到t结束
        while (l < t) {
            // 和大于t
            if (sum > t) {
                // 减去左索引，左索引右移
                sum -= arr[l++];
            } else if (sum == t) {
                // 满足条件 添加到集合中
                ans.add(Arrays.copyOfRange(arr, l, r));
                // 减去左索引，左索引右移
                sum -= arr[l++];
                // 右索引越界
                if (r >= t) break;
                // 右索引右移
                sum += arr[r++];
            } else {
                // 右索引右移
                sum += arr[r++];
            }
        }
        //数组排序
        ans.sort((a, b) -> a.length - b.length);
        for (int[] an : ans) {
            StringJoiner sj = new StringJoiner("+");
            for (int v : an) sj.add(v + "");
            System.out.println(t + "=" + sj);
        }

        System.out.println("Result:" + ans.size());
    }
}