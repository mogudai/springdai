package nowCode;

import java.util.Scanner;

/**
 * HJ2 计算某字符出现次数
 * 题目
 * 题解(859)
 * 讨论(2k)
 * 排行
 * 面经new
 * 简单  通过率：33.73%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 哈希
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * <p>
 * 数据范围： 1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 * <p>
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 复制
 * 输出：
 * 2
 */

public class code_1006 {

    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String br = sc.nextLine();
        String string1 = str.toUpperCase();
        String br1 = br.toUpperCase();
        char a = br1.charAt(0);
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) == a)
                count++;
        }
        System.out.println(count);
    }

}
