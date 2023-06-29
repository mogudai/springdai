package it.od.huisu;

import java.util.LinkedList;
import java.util.Scanner;

public class Od008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        // 元素都加入链表
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            link.add(sc.nextInt());
        }

        System.out.println(getResult(link, m));
    }

    public static int getResult(LinkedList<Integer> link, int m) {
        // 排序 从大到小排序
        link.sort((a, b) -> b - a);
        // 所有数的和
        int sum = 0;
        for (Integer ele : link) {
            sum += ele;
        }

        while (m > 0) {
            // 每次循环赋值一个新链表
            LinkedList<Integer> link_cp = new LinkedList<>(link);
            if (canPartitionMSubsets(link_cp, sum, m)) return sum / m;
            m--;
        }

        return sum;
    }

    public static boolean canPartitionMSubsets(LinkedList<Integer> link, int sum, int m) {
        // 和不能等分就返回
        if (sum % m != 0) return false;
        // 等分数值
        int subSum = sum / m;
        // 等分数值不能小于最小的子集
        if (subSum < link.get(0)) return false;

        //    while (link.get(0) == subSum) { // 此段代码可能越界
        // 等分数值等于小于最小的子集，且队列还有元素
        while (link.size() > 0 && link.get(0) == subSum) {
            link.removeFirst();
            m--;
        }

        int[] buckets = new int[m];
        // 递归找最小值 找到就返回
        return partition(link, 0, buckets, subSum);
    }

    public static boolean partition(LinkedList<Integer> link, int index, int[] buckets, int subSum) {
        //
        if (index == link.size()) return true;

        int select = link.get(index);

        for (int i = 0; i < buckets.length; i++) {
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            if (select + buckets[i] <= subSum) {
                buckets[i] += select;
                if (partition(link, index + 1, buckets, subSum)) return true;
                buckets[i] -= select;
            }
        }

        return false;
    }
}