package it.od;

import java.util.HashMap;
import java.util.Scanner;

public class Od83 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String content = sc.next();
        String word = sc.next();
        System.out.println(getResult(content, word));
    }

    // D
    // ABAACA123D
    private static int getResult(String content, String word) {
        int max = 0;
        String[] arr = word.split("");
        int length = arr.length;
        int l = 0, r = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while (r < length) {
            char c = arr[r].toCharArray()[0];
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                continue;
            }
            // 如果遇到字符 左右都到下个，没遇到右移，如果
            if (arr[r].equals(content)) {
                if (r < length) {
                    r++;
                    l = r;
                    continue;
                }
            }else {
                if (map.containsKey(arr[r])) {
                    Integer integer = map.get(arr[r]) + 1;
                    map.put(arr[r], integer);
                } else {
                    map.put(arr[r], 1);
                }
                Integer integer = map.get(arr[r]);
                if (integer == 3) {
                    l++;
                }
                max = Math.max(max, r - l + 1);
                r++;
            }

        }
        return max;
    }
}
