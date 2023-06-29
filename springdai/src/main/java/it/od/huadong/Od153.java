package it.od.huadong;

import java.util.LinkedList;
import java.util.Scanner;

// 求满足条件的最长子串的长度
public class Od153 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] arr = line.toCharArray();
        System.out.println(getResult(arr));
    }

    private static int getResult(char[] arr) {
        int max = -1;
        int left = 0;
        int right = 0;
        boolean hasLetter = false;
        // 标记
        LinkedList<Integer> letterIdx = new LinkedList<>();
        for (; right < arr.length; ) {
            char c = arr[right];
            // a 97 z 122 A65 Z 91  在 A-Z 或 a-z 如果是字母
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                hasLetter = true;
                letterIdx.add(right);
                if (letterIdx.size() > 1) {
                    left = letterIdx.removeFirst() + 1;
                }
                if (right == left) {
                    right++;
                    continue;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        if (!hasLetter) {
            return -1;
        }
        return max;
    }
}
