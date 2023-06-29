package it.od.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Od114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = Integer.parseInt(sc.nextLine());

        String str = sc.nextLine();
        Integer[] prices =
                Arrays.stream(str.substring(1, str.length() - 1).split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
        // 可重复元素组合
        System.out.println(getResult(amount, prices));
    }

    public static String getResult(int amount, Integer[] prices) {
        // 返回集合
        ArrayList<String> res = new ArrayList<>();
        // 每个路径
        LinkedList<Integer> path = new LinkedList<>();
        // 和，索引，当前和，路径，路径集合
        dfs(amount, prices, 0, 0, path, res);
        return res.toString();
    }

    public static void dfs(int total, Integer[] arr, int index, int sum, LinkedList<Integer> path, ArrayList<String> res) {
        // 结束条件
        if (sum >= total) {
            // 添加路径
            if (sum == total) res.add(path.toString());
            return;
        }
        // 循环
        for (int i = index; i < arr.length; i++) {
            // 路径添加元素
            path.addLast(arr[i]);
            // 递归
            dfs(total, arr, i, sum + arr[i], path, res);
            // 删除元素
            path.removeLast();
        }
    }
}