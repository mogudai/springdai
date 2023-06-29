package it.od.huisu;

import java.util.LinkedList;
import java.util.Scanner;

public class Od090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            link.add(sc.nextInt());
        }

        System.out.println(getResult(link, m));
    }

    public static int getResult(LinkedList<Integer> link, int m) {
        link.sort((a, b) -> b - a);

        int sum = 0;
        for (Integer ele : link) {
            sum += ele;
        }

        while (m >= 1) {
            LinkedList<Integer> link_cp = new LinkedList<>(link);
            if (canPartitionMSubsets(link_cp, sum, m)) return m;
            m--;
        }

        return 1;
    }

    public static boolean canPartitionMSubsets(LinkedList<Integer> link, int sum, int m) {
        if (sum % m != 0) return false;

        int subSum = sum / m;

        if (subSum < link.get(0)) return false;

        //    while (link.get(0) == subSum) {
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