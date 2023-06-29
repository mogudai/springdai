package it.od.dfs;

import java.util.Scanner;

//  数学问题
public class dfs_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String bin1 = sc.next();
        String bin2 = sc.next();

        System.out.println(getResult(n, bin1, bin2));
    }

    /**
     * @param n    二进制长度
     * @param bin1 可能产生错误交换的二进制
     * @param bin2 不会发生错误的二进制
     * @return 产生错误结果的情况有几种
     */
    public static long getResult(int n, String bin1, String bin2) {
        // 找出bin2值为0的位，并统计对应位上bin1的值为0的有x个
        long x = 0;
        // 找出bin2值为0的位，并统计对应位上bin1的值为1的有y个
        long y = 0;
        // 统计bin1总共有多少个1
        long a = 0;
        // 统计bin1总共有多少个0
        long b = 0;

        for (int i = 0; i < n; i++) {
            if (bin1.charAt(i) == '0') {
                b++;
                if (bin2.charAt(i) == '0') x++;
            } else {
                a++;
                if (bin2.charAt(i) == '0') y++;
            }
        }

        return x * a + y * b - x * y;
    }
}
