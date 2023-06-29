package it.od.huadong;

import java.util.HashMap;
import java.util.Scanner;

// 完美走位
public class Od004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.next()));
    }

    public static int getResult(String str) {
        // count用于记录W,A,S,D字母的数量
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // 平衡状态时，W,A,S,D应该都是avg数量
        int avg = str.length() / 4;

        // total用于记录多余字母个数
        int total = 0;

        // flag表示当前是否为平衡状态，默认是
        boolean flag = true;

        for (Character c : count.keySet()) {
            if (count.get(c) > avg) {
                // 如果有一个字母数量超标，则平衡打破
                flag = false;
                // 此时count记录每个字母超过avg的数量
                count.put(c, count.get(c) - avg);
                total += count.get(c);
            } else {
                count.put(c, 0); // 此时count统计的其实是多余字母，如果没有超过avg,则表示没有多余字母
            }
        }

        // 如果平衡，则输出0
        if (flag) return 0;

        int i = 0;
        int j = 0;
        int minLen = str.length() + 1;

        while (j < str.length()) {
            Character jc = str.charAt(j);

            if (count.get(jc) > 0) {
                total--;
            }
            count.put(jc, count.get(jc) - 1);

            while (total == 0) {
                minLen = Math.min(minLen, j - i + 1);

                Character ic = str.charAt(i);
                if (count.get(ic) >= 0) {
                    total++;
                }
                count.put(ic, count.get(ic) + 1);

                i++;
            }
            j++;
        }
        return minLen;
    }
}