package it.od.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Od151 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        // 求 10选5的去重组合
        getResult(arr);
    }

    public static int getResult(Integer[] arr) {
        Arrays.sort(arr);

        ArrayList<Integer> res = new ArrayList<>();
        // dfs求10选5的去重组合，并将组合之和记录进res中，即res中记录的是所有可能性的5人小队实力值之和
        dfs(arr, 0, 0, 0, res);

        int sum = Arrays.stream(arr).reduce(Integer::sum).orElse(0);
        // 某队实力为subSum，则另一队实力为sum - subSum，则两队实力差为 abs((sum - subSum) - subSum)，先求最小实力差
        return res.stream().map(subSum -> Math.abs(sum - 2 * subSum)).min((a, b) -> a - b).orElse(0);
    }

    // 队列，当前索引，人员，和，和的队列
    public static void dfs(Integer[] arr, int index, int level, int sum, ArrayList<Integer> res) {
        // 满足条件结束
        if (level == 5) {
            res.add(sum);
            return;
        }
        for (int i = index; i < 10; i++) {
            // 与前一个队员能力相等跳过
            if (i > 0 && arr[i] == arr[i - 1]) continue; // arr已经升序，这里进行树层去重
            // 后面一个球员，人员加1
            dfs(arr, i + 1, level + 1, sum + arr[i], res);
        }
    }
}
