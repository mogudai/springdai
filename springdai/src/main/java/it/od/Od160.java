package it.od;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 补种杨树
public class Od160 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        //  初始化一个树满的数组
        Arrays.fill(arr, 1);
        // 坏死的树赋值
        for (int i = 0; i < m; i++) {
            int deadIdx = sc.nextInt() - 1;
            arr[deadIdx] = 0;
        }

        int k = sc.nextInt();

        System.out.println(getResult(arr, k));
    }

    public static int getResult(int[] arr, int k) {
        // 左索引初始化
        int left = 0;
        // 记录死树索引
        LinkedList<Integer> occur = new LinkedList<>();
        int maxLen = 0;
        // 右索引从0开始
        for (int right = 0; right < arr.length; right++) {
            // 右索引遇到了死树
            if (arr[right] == 0) {
                // 记录死树索引
                occur.addLast(right);
                // 死树满足可以补的最大情况
                if (occur.size() > k) {
                    // 目前窗口最大值
                    maxLen = Math.max(maxLen, right - left);
                    // 左索引向右移动
                    left = occur.removeFirst() + 1;
                    continue;
                }
            }
            //没有遇到死树，扩大窗口值
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

}
