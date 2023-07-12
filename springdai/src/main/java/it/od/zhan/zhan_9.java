package it.od.zhan;

import java.util.LinkedList;
import java.util.Scanner;

public class zhan_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        int count = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(num1, count));
    }

    private static String getResult(String num1, int removeCount) {
        if (num1.length() == removeCount) return "0";

        int remainCount = num1.length() - removeCount;

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < num1.length(); i++) {
            //能移除元素， 后面一位比栈的最后一位小，就移除
            while (stack.size() > 0 && removeCount > 0 && stack.getLast() > num1.charAt(i)) {
                stack.removeLast();
                removeCount--;
            }
            stack.add(num1.charAt(i));
        }
        // 还有没移除的名额，移除最后一位
        while (stack.size() > remainCount) {
            stack.removeLast();
        }
        // 首位等于 0 ，移除首位
        while (stack.getFirst() == '0' && stack.size() != 1) {
            stack.removeFirst();
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) sb.append(c);
        return sb.toString();
    }
}
