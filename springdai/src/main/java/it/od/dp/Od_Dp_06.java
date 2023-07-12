package it.od.dp;

import java.util.Scanner;

public class Od_Dp_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getSeq(n));
    }

    public static String getSeq(int n) {
        String base = "1";
        for (int i = 1; i <= n; i++) {
            base = describe(base);
        }
        return base;
    }

    public static String describe(String seq) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char val = seq.charAt(0);

        for (int i = 1; i < seq.length(); i++) {
            if (seq.charAt(i) == seq.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(val);
                count = 1;
                val = seq.charAt(i);
            }
        }
        sb.append(count).append(val);
        return sb.toString();
    }
}
