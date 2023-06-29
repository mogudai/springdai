package it.od.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 双回溯，用例过80
public class Od74_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] cases = new int[t][];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            cases[i] = arr;
        }
        getResult(cases);
    }

    public static void getResult(int[][] cases) {
        for (int[] arr : cases) {
            // 对每组测试线段升序排序
            Arrays.sort(arr);
            ArrayList<Integer[]> res = new ArrayList<>();
            // 得到所有满足要求的三角形
            dfs(arr, 0, new LinkedList<>(), res);
            // 再次回溯
            int[] count = new int[100];
            // 统计每个所有线条
            for (int i : arr) {
                count[i]++;
            }
            ArrayList<Integer> ans = new ArrayList<>();
            canCombine(res, 0, count, 0, ans);
            System.out.println(ans.stream().max((a, b) -> a - b).orElse(0));
        }
    }

    // 全组合求解，即n个数中选3个
    public static void dfs(int[] arr, int index, LinkedList<Integer> path, ArrayList<Integer[]> res) {
        if (path.size() == 3) {
            if (isRightTriangle(path)) {
                res.add(path.toArray(new Integer[3]));
            }
            return;
        }
        for (int i = index; i < arr.length; i++) {
            path.add(arr[i]);
            dfs(arr, i + 1, path, res);
            path.removeLast();
        }
    }

    // 判断三条边是否可以组成直角三角形
    public static boolean isRightTriangle(LinkedList<Integer> path) {
        // 注意，path中元素是升序的，因为path是取自arr的组合，而arr是升序的
        int x = path.get(0);
        int y = path.get(1);
        int z = path.get(2);

        return x * x + y * y == z * z;
    }

    // 3 4 5
    // 3 4 5
    // 5 12 13
    // 5 12 13
    // 求解当前直角三角形中不超用线段的最多组合数
    public static void canCombine(
            ArrayList<Integer[]> ts, int index, int[] count, int num, ArrayList<Integer> ans) {
        if (index >= ts.size()) {
            ans.add(num);
            return;
        }
        for (int i = index; i < ts.size(); i++) {
            Integer[] tri = ts.get(i);
            int a = tri[0];
            int b = tri[1];
            int c = tri[2];
            if (count[a] > 0 && count[b] > 0 && count[c] > 0) {
                count[a]--;
                count[b]--;
                count[c]--;
                num++;
                canCombine(ts, i + 1, count, num, ans);
                num--;
                count[a]++;
                count[b]++;
                count[c]++;
            }
        }
        ans.add(num);
    }
}