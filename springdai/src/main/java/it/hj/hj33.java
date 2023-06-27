package it.hj;

import java.util.Scanner;

/**
 * 输入：
 * 10.0.3.193
 * 167969729
 */
public class hj33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            // System.out.println(a);
            Long b = in.nextLong();
            // System.out.println(b);
            String[] as = a.split("\\.");
            // System.out.println(as.length);
            if (as.length != 4) {
                continue;
            }

            // IP -> Long
            Long a0 = (Long) (Long.parseLong(as[0]) * 256 * 256 * 256);
            // System.out.println(a0);
            int a1 = Integer.parseInt(as[1]) * 256 * 256;
            int a2 = Integer.parseInt(as[2]) * 256;
            int a3 = Integer.parseInt(as[3]);

            // Long -> IP
            int b0 = (int) (b / 256 / 256 / 256);
            int b1 = (int) ((b / 256 / 256) % 256);
            int b2 = (int) ((b / 256) % 256);
            int b3 = (int) (b % 256);

            System.out.println(a0 + a1 + a2 + a3);
            System.out.println(b0 + "." + b1 + "." + b2 + "." + b3);
        }
    }
}


