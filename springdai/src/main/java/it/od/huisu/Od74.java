package it.od.huisu;

import java.util.Comparator;
import java.util.LinkedList;

public class Od74 {

    public static void main(String[] args) {
        int[] arr = new int[0];
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        dfs(arr, 0, count, list);
    }

    private static void dfs(int[] arr, int index, int count, LinkedList<Integer> list) {
        if (list.size() == 3 && isZhiJiao(list)) {
            count++;
            return;
        }
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            dfs(arr,index+1,count,list);
            list.removeLast();
        }
    }

    private static boolean isZhiJiao(LinkedList<Integer> list) {
        list.sort(Comparator.naturalOrder());
        Integer a = list.get(0);
        Integer b = list.get(1);
        Integer c = list.get(2);
        return a * a + b * b == c * c;
    }
}
