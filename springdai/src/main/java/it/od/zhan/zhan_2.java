package it.od.zhan;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class zhan_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        System.out.println(getResult(k, s));
    }

    public static String getResult(int k, String s) {
        StringBuilder stack = new StringBuilder();
        LinkedList<String> result = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '_' && (stack.length() == 0 || stack.charAt(0) != '"')) {
                result.add(stack.toString());
                stack = new StringBuilder();
            } else if (c == '"' && stack.length() != 0) {
                stack.append('"');
                result.add(stack.toString());
                stack = new StringBuilder();
            } else {
                stack.append(c);
            }
        }

        if (stack.length() > 0) result.add(stack.toString());

        List<String> ans = result.stream().filter(str -> !"".equals(str)).collect(Collectors.toList());

        if (k > ans.size() - 1) return "ERROR";
        ans.set(k, "******");

        StringJoiner sj = new StringJoiner("_");
        for (String an : ans) sj.add(an);
        return sj.toString();
    }
}
