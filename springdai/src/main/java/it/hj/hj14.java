package it.hj;

import java.util.*;

public class hj14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            String[] s = new String[n];
            for(int i = 0; i < n; i++){
                s[i] = in.next();
            }
            Arrays.sort(s);
            for (int i = 0; i < s.length;i++) {
                System.out.println(s[i]);
            }
        }
    }
}
