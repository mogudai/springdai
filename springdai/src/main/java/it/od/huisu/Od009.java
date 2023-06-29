package it.od.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Od009 {
    static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uv", "wx", "yz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.next().split("")).map(Integer::parseInt).toArray(Integer[]::new);
        String filter = sc.next();

        System.out.println(getResult(arr, filter));
    }

    public static String getResult(Integer[] arr, String filter) {
        // 数字转换成字符
        String[] newArr = Arrays.stream(arr).map(val -> map[val]).toArray(String[]::new);
        // 屏蔽词
        char[] cArr = filter.toCharArray();
        Arrays.sort(cArr);
        filter = new String(cArr);

        ArrayList<String> res = new ArrayList<>();
        dfs(newArr, 0, new LinkedList<>(), res, filter);

        StringBuilder sb = new StringBuilder();
        for (String str : res) {
            sb.append(str).append(",");
        }
        return sb.toString();
    }

    public static void dfs(
            String[] arr, int index, LinkedList<Character> path, ArrayList<String> res, String filter) {

        if (index == arr.length) {
            // 过滤这些完全包含屏蔽字符串的每一个字符的字符串
            if (!include(path, filter)) {
                StringBuilder sb = new StringBuilder();
                for (Character c : path) {
                    sb.append(c);
                }
                res.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < arr[index].length(); i++) {
            path.addLast(arr[index].charAt(i));
            dfs(arr, index + 1, path, res, filter);
            path.removeLast();
        }
    }

    public static boolean include(LinkedList<Character> path, String filter) {
        StringBuilder sb = new StringBuilder();
        path.stream().sorted().forEach(sb::append);
        return sb.toString().contains(filter);
    }
}