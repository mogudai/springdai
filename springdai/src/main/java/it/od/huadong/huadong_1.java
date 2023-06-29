package it.od.huadong;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

//高矮个子排队
public class huadong_1 {
    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Integer[] arr =
                    Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            System.out.println(getResult(arr));
        } catch (Exception e) {
            System.out.println("[]");
        }
    }

    // 算法入口
    public static String getResult(Integer[] arr) {
        // i高->i+1矮 为true，i矮->i+1高 为false
        boolean flag = true;

        for (int i = 0; i < arr.length - 1; i++) {
            // i矮->i+1高 互换位置
            if (arr[i] != arr[i + 1] && (arr[i] > arr[i + 1]) != flag) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }

            flag = !flag;
        }
        // 输出
        StringJoiner sj = new StringJoiner(" ");
        for (Integer h : arr) {
            sj.add(h + "");
        }
        return sj.toString();
    }
}