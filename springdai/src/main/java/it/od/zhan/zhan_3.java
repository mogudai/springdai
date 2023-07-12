package it.od.zhan;

import java.util.Scanner;
import java.util.regex.Pattern;

public class zhan_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(getResult(s));
    }

    public static String getResult(String s) {
        // 正则匹配
        Pattern reg = Pattern.compile("^(01)+0$");

        int maxLen = 0;
        String ans = "-1";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当前 ==0
            if (c == '0') {
                // 前一个也是0  重新计算
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
                    //  正则匹配
                    if (reg.matcher(sb.toString()).find() && sb.length() > maxLen) {
                        maxLen = sb.length();
                        ans = sb.toString();
                    }
                    sb = new StringBuilder();
                }
            }

            sb.append(c);
        }

        if (sb.length() > 0) {
            if (reg.matcher(sb.toString()).find() && sb.length() > maxLen) {
                return sb.toString();
            }
        }

        return ans;
    }
}
