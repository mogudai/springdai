package it.od.shuangzizhen;

import java.util.Arrays;
import java.util.Scanner;

//最大花费金额
public class Od152 {
    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arrM =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int r = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(arrM, r));
    }

    // 算法入口
    public static int getResult(Integer[] arr, int target) {
        // 题目说小明要购买三件，如果商品不足三件直接返回-1
        if (arr.length < 3) return -1;
        // 数组升序
        Arrays.sort(arr);
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            // 左索引从第二个开始
            int l = i + 1;
            //右索引是最后一个
            int r = arr.length - 1;
            // 左右相聚的时候
            while (l < r) {
                // 当前加后面一个加从后面一个过来
                int sum = arr[i] + arr[l] + arr[r];
                // 相等结束
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    // 小于获得最大值
                    ans = Math.max(ans, sum);
                    l++;
                } else {
                    // 后面向当前靠拢
                    r--;
                }
            }
        }
        return ans;
    }
}