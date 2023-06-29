package it.od.huadong;

import java.util.Arrays;
import java.util.Scanner;

//100 区块链文件转储系统
public class Od058 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        Integer[] arr =
                Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(getResult(arr, k));
    }

    private static int getResult(Integer[] arr, int m) {
        int max = 0;
        int l = 0, r = 0;
        int sum = 0;
        while (true) {
            // 不满足要求
            if (sum > m) {
                sum -= arr[l];
                l++;
            } else {
                max = Math.max(max, sum);
                if (r == arr.length) {
                    break;
                }
                sum += arr[r];
                r++;
            }
        }
        return max;
    }
}
