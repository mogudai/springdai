package it.od.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Od114_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = Integer.parseInt(sc.nextLine());

        String str = sc.nextLine();
        Integer[] prices =
                Arrays.stream(str.substring(1, str.length() - 1).split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);

        System.out.println(getResult(amount, prices));
    }

    private static String getResult(int amount, Integer[] prices) {
        ArrayList<String> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(amount, 0, 0, path, res, prices);
        return res.toString();
    }

    private static void dfs(int amount, int index, int sum, LinkedList<Integer> path, ArrayList<String> res, Integer[] arr) {
        if (sum >= amount) {
            if (sum == amount) {
                res.add(path.toString());
            }
            return;
        }
        for (int i = index; i < arr.length; i++) {
            path.add(arr[i]);
            dfs(amount, i , sum + arr[i], path, res, arr);
            path.removeLast();
        }
    }
}
