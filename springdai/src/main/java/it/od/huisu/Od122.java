package it.od.huisu;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Od122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(getResult(arr));
    }

    public static int getResult(Integer[] arr) {
        // 先排序
        Arrays.sort(arr, (a, b) -> b - a);
        int sum = 0;
        // 算出总长度
        for (Integer ele : arr) {
            sum += ele;
        }
        int m = arr.length;
        while (m > 1) {
            LinkedList<Integer> link = new LinkedList<>();
            // 转link
            Collections.addAll(link, arr);
            if (canPartitionMSubsets(link, sum, m)) return m;
            m--;
        }
        return -1;
    }

    public static boolean canPartitionMSubsets(LinkedList<Integer> link, int sum, int m) {
        //
        if (sum % m != 0) return false;

        int subSum = sum / m;

        if (subSum < link.get(0)) return false;

        //    while (link.get(0) == subSum) { // 此段代码可能越界
        while (link.size() > 0 && link.get(0) == subSum) {
            link.removeFirst();
            m--;
        }

        int[] buckets = new int[m];
        return partition(link, 0, buckets, subSum);
    }

    public static boolean partition(LinkedList<Integer> link, int index, int[] buckets, int subSum) {
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