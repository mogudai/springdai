package it.od.huisu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class HuSu_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split(",");
        String abbr = sc.nextLine();

        System.out.println(getResult(names, abbr));
    }

    public static String getResult(String[] names, String abbr) {
        ArrayList<String> ans = new ArrayList<>();
        for (String name : names) {
            // 每个字的拼音
            String[] parts = name.split(" ");
            // 如果姓名长度小于缩写跳过
            if (parts.length > abbr.length()) continue;
            // 递归这个姓名
            boolean res = dfs(parts, 0, abbr, 0);
            if (res) {
                ans.add(name);
            }
        }
        StringJoiner sj = new StringJoiner(",");
        for (String an : ans) {
            sj.add(an);
        }
        return sj.toString();
    }

    public static boolean dfs(String[] parts, int index, String abbr, int start) {
        // 如果查找的长度大于等于 搜索长度 判断当前索引是否大于等于当前
        if (start >= abbr.length()) return index >= parts.length;
        // 遍历每个名字拼音缩写
        for (int i = index; i < parts.length; i++) {
            String part = parts[i];
            // 遍历每个单词字母
            for (int j = 0; j < part.length(); j++) {
                // 搜索索引小于长度，并且字母包含当前搜索单词
                if (start < abbr.length() && part.charAt(j) == abbr.charAt(start)) {
                    boolean res = dfs(parts, i + 1, abbr, ++start);
                    // 没有搜索完就继续搜索
                    if (res) return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}