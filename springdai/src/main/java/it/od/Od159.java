package it.od;

import java.util.*;

public class Od159 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.next();
        }
        Map<Integer, String> map = new HashMap<>(n);
        int[] integers = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            String[] split = str.split("");
            int falg=Integer.MAX_VALUE;
            for (int j = split.length-1; j >-1; j--) {
                String s1 = split[j];
                if("0123456789".contains(s1)){
                    falg = Math.min(falg, j);
                }
            }
            Integer key = Integer.parseInt(str.substring(falg));
            integers[i] = key;
            map.put(key, str.substring(0, falg));
        }
        String str = "";
        Arrays.sort(integers);
        for (int i = 0; i < integers.length; i++) {
            String s1 = map.get(integers[i]);
            str = str + s1 + " ";
        }
        System.out.println(str);
    }
}
