package it.od.huadong;

import java.util.Arrays;
import java.util.Scanner;

//寻找符合要求的最长子串
public class Od83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String exclude = sc.next();
        String s = sc.next();

        System.out.println(getResult(s, exclude.charAt(0)));
    }

    public static int getResult(String s, char ex) {
        // 记录滑窗内部每个字符出现的次数
        int[] count = new int[128];

        // 滑窗左边界,右边界
        int l = 0, r = 0;

        // 记录满足条件的最长子串的长度
        int ans = 0;

        // 滑窗右边界不越界的话，可以继续右移
        while (r < s.length()) {
            // r指针指向的字符是滑窗新增的字符
            char add_c = s.charAt(r);

            if (ex == add_c) {
                // 如果新增字符是屏蔽字符，那么滑窗不能包含此字符，为了让滑窗不能包含此字符，只能让滑窗的左边界l移动到此字符的右边一个位置
                ans = Math.max(ans, r - l); // 但是在具体移动之前，需要将上一个状态的滑窗长度，和统计的最大长度进行比较，保留最大的
                l = ++r; // 滑窗左边界l要移动到屏蔽字符的右边，即r+1位置，而滑窗的右边界r又不能落后于左边界l，因此相当于同时移动
                Arrays.fill(count, 0); // 此时滑窗为空，因此清空统计的字符的数量
            } else {
                // 如果新增字符不是屏蔽字符，那么就纳入滑窗
                count[add_c]++;

                // 如果此时新增字符的数量超过了2，那么我们应该让滑窗的左边界l右移，直到该新增字符的数量等于2时停止
                if (count[add_c] > 2) {
                    ans = Math.max(ans, r - l); // 但是在具体移动之前，我们需要将上一个状态的滑窗长度，和统计的最大长度进行比较，保留最大的
                }

                while (count[add_c] > 2) {
                    char remove_c = s.charAt(l);
                    count[remove_c]--;
                    l++;
                }

                r++;
            }
        }

        return Math.max(ans, r - l); // 对最后一次滑窗位置进行记录
    }
}