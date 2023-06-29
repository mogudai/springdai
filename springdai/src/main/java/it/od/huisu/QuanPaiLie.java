package it.od.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class QuanPaiLie {

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;

    public static void main(String[] args) {
        QuanPaiLie quanPaiLie = new QuanPaiLie();
        int[] arr={1,2,3};
        List<List<Integer>> list = quanPaiLie.permute(arr);
        System.out.println(list);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        //初始化标记数组
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }
    // 需要排列的数组
    private void permuteHelper(int[] nums) {
        // 如果
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //跳过标记的
            if (used[i]) {
                continue;
            }
            // 标记
            used[i] = true;
            // 添加
            path.add(nums[i]);
            // 回溯
            permuteHelper(nums);
            // 删除
            path.removeLast();
            // 消除标记
            used[i] = false;
        }
    }
}
