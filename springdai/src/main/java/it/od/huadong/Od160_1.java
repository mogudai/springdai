package it.od.huadong;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Od160_1 {

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
        // 补种数值
        int k = sc.nextInt();
        System.out.println(getResult(arr, k));
    }

    private static int getResult(int[] arr, int k) {
        int left = 0;
        int max = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                linkedList.add(right);
                if (linkedList.size() > k) {
                    //更新窗口最大值
                    max = Math.max(max, right - left);
                    //做索引向右移
                    left = linkedList.removeFirst() + 1;
                    continue;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
