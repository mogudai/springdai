package it.od.huisu;

import java.util.*;

// 48
public class Od122_1 {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        getResult(arr);
        System.out.println(count);

    }

    private static void getResult(Integer[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int max = arr[length - 1];
        Map<Integer, Integer> path = new HashMap<>();
        boolean[] falgs = new boolean[length];
        dfs(arr, falgs, 0, max, path);
        for (int i = 0; i < length; i++) {
            if (!falgs[i]) {
                count = -1;
            }
        }
    }

    private static void dfs(Integer[] arr, boolean[] falgs, int index, int max, Map<Integer, Integer> path) {
        for (Integer key : path.keySet()) {
            if (falgs[key]) {
                return;
            }
        }
        if (is(path, max, falgs)) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (!falgs[i]) {
                path.put(i, arr[i]);
                dfs(arr, falgs, i + 1, max, path);
                path.remove(i);
            }
        }
    }

    private static boolean is(Map<Integer, Integer> map, int max, boolean[] falgs) {
        int sum = 0;
        for (Integer key : map.keySet()) {
            sum += map.get(key);
        }
        if (sum > max) {
            return true;
        }
        if (sum == max) {
            for (Integer key : map.keySet()) {
                falgs[key] = true;
            }
            count++;
        }
        return sum == max;
    }
}
