package it.od.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZuHe {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    // 1-n  每2个排列
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    private void combineHelper(int n, int k, int startIndex) {
        // 终止条件
        if (path.size() == k) {
            result.add(new LinkedList(path));
            return;
        }
        // 遍历
        for (int j = startIndex; j <= n - (k - path.size()) + 1; j++) {
            // 添加
            path.add(j);
            // 递归
            combineHelper(n, k, j + 1);
            // 删除
            path.removeLast();
        }
    }
}
