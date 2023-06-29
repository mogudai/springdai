package it.od.huadong;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//100分 关联子串
public class Od165 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr = str.split(" ");
        String str1 = arr[0];
        String str2 = arr[1];
        System.out.println(getResult(str1, str2));
    }

    private static int getResult(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        Arrays.sort(chars1);
        String chars1Str = new String(chars1);
        char[] chars2 = str2.toCharArray();
        int index = -1;
        int windows_length = chars1.length;
        int r = windows_length - 1, l = 0;
        LinkedList<Character> list = new LinkedList<>();
        char[] win = new char[windows_length];
        // 初始化wins
        for (int i = 0; i < windows_length; i++) {
            list.add(chars2[i]);
        }
        while (true) {
            // 窗口排序
            for (int i = 0; i < list.size(); i++) {
                win[i] = list.get(i);
            }
            Arrays.sort(win);
            String winStr = new String(win);
            if (winStr.equals(chars1Str)) {
                index = l;
                break;
            }
            r++;
            if (r == chars2.length) {
                break;
            }
            list.add(chars2[r]);
            list.removeFirst();
            l++;
        }
        return index;
    }
}
