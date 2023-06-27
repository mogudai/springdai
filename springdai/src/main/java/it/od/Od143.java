package it.od;

import java.util.Scanner;

public class Od143 {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        int n = scanner.nextInt();
        String[] split = next.split(",");
        if (split.length > n) {
            alibabaV(split, n);
        } else {
            for (int i = 0; i <= split.length; i++) {
                alibabaV(split, i);
            }
        }
        System.out.println(max);
        max = 0;
    }

    private static void alibabaV(String[] split, int n) {
        int next = 0;
        for (int i = 0; i <= split.length - n; i++) {
            int sum = 0;
            if (next <= split.length - n && i - 1 > -1) {
                if (Integer.parseInt(split[next]) < Integer.parseInt(split[i - 1])) {
                    continue;
                }
            }
            for (int j = 0; j < n; j++) {
                int k = i + j;
                sum += Integer.parseInt(split[k]);
                next = k + 1;
            }
            max = Math.max(sum, max);
            sum = 0;
        }
    }
}
