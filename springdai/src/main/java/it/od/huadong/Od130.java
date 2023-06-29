package it.od.huadong;

import java.util.LinkedList;
import java.util.Scanner;

// 80 分
public class Od130 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(getResult(next, k));
    }

    private static int getResult(String next, int sum) {
        if (next == null) {
            return -1;
        }
        int max = -1;
        String[] arr = next.split(",");
        int left = 0, rigth = 0, count = 0;
        // 记录左索引
        LinkedList<Integer> list = new LinkedList<>();
        for (; rigth < arr.length; ) {
            int total = 0;
            for (int i = left; i <= rigth; i++) {
                total += Integer.parseInt(arr[i]);
            }
            // 缩小区间，左指针右移
            if (total > sum) {
                // 有特例  left = rigth
                if (left >= rigth) {
                    rigth = left;
                    rigth++;
                    continue;
                }
            } else if (total < sum) {
                // 扩大区间，右指针右移
                rigth++;
            } else {
                max = Math.max(max, rigth - left + 1);
                rigth++;
            }

        }
        return max;
    }
}
