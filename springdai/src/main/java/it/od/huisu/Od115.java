package it.od.huisu;

import java.util.*;

public class Od115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        getResult(arr);
    }

    public static void getResult(Integer[] arr) {
        // 标记
        boolean[] used = new boolean[arr.length];
        // 路径
        LinkedList<Integer> path = new LinkedList<>();
        // 返回的行集合
        ArrayList<Integer[]> res = new ArrayList<>();
        // 回溯
        dfs(arr, used, path, res);
        // 排序
        res.sort(
                (a, b) -> {
                    for (int i = 0; i < 9; i++) {
                        if (!Objects.equals(a[i], b[i])) return a[i] - b[i];
                    }
                    return 0;
                });
        // 输出
        for (Integer[] re : res) {
            StringJoiner sj = new StringJoiner(" ");
            for (Integer i : re) {
                sj.add(i + "");
            }
            System.out.println(sj);
        }
    }

    public static void dfs(
            Integer[] arr, boolean[] used, LinkedList<Integer> path, ArrayList<Integer[]> res) {
        // 满足条件就添加
        if (path.size() == arr.length) {
            if (check(path)) {
                Integer[] a = path.toArray(new Integer[0]);
                res.add(a);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            //没有使用
            if (!used[i]) {
                // 添加
                path.add(arr[i]);
                // 标记
                used[i] = true;
                // 递归
                dfs(arr, used, path, res);
                // 剪去枝叶
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static boolean check(LinkedList<Integer> path) {
        Integer[] a = path.toArray(new Integer[0]);
        // 一行
        int r1 = a[0] * a[1] * a[2];
        //
        int r2 = a[3] * a[4] * a[5];
        if (r1 != r2) return false;

        int r3 = a[6] * a[7] * a[8];
        if (r1 != r3) return false;

        int c1 = a[0] * a[3] * a[6];
        if (r1 != c1) return false;

        int c2 = a[1] * a[4] * a[7];
        if (r1 != c2) return false;

        int c3 = a[2] * a[5] * a[8];
        if (r1 != c3) return false;

        int s1 = a[0] * a[4] * a[8];
        if (r1 != s1) return false;

        int s2 = a[2] * a[4] * a[6];
        if (r1 != s2) return false;

        return true;
    }
}