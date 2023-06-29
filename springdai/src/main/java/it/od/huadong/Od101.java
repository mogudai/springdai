package it.od.huadong;

import java.util.*;

//100 最差产品奖
public class Od101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        Integer[] arr =
                Arrays.stream(in.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        getResult(arr, k);
    }

    private static void getResult(Integer[] arr, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        int l = 0, r = k - 1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        while (true) {
            int min = min(list);
            integers.add(min);
            r++;
            if (r == arr.length) {
                break;
            }
            list.add(arr[r]);
            list.removeFirst();
            l++;
        }
        System.out.println(integers.toString().replace("[", "").replace("]", "").replace(" ", ""));
    }

    private static int min(LinkedList<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
        }
        return min;
    }
}
