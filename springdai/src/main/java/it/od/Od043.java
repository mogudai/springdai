package it.od;

import java.util.Scanner;

public class Od043 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String sort = bySort(a, b);
        System.out.println(sort);
    }


    private static String bySort(String a, String b) {
        String[] aSplit = a.split("\\.");
        String[] bSplit = b.split("\\.");
        // 主版本排序
        // 校验
        if (bSplit.length < 1) {
            return a;
        }
        if (aSplit.length < 1) {
            return b;
        }
        if (Integer.parseInt(aSplit[0]) > Integer.parseInt(bSplit[0])) {
            return a;
        } else if (Integer.parseInt(aSplit[0]) < Integer.parseInt(bSplit[0])) {
            return b;
        }
        // 次版本排序
        // 校验
        if (bSplit.length < 2) {
            return a;
        }
        if (aSplit.length < 2) {
            return b;
        }
        if (Integer.parseInt(aSplit[1]) > Integer.parseInt(bSplit[1])) {
            return a;
        } else if (Integer.parseInt(aSplit[1]) < Integer.parseInt(bSplit[1])) {
            return b;
        }
        // 增量版本
        // 校验
        if (bSplit.length < 3) {
            return a;
        }
        if (aSplit.length < 3) {
            return b;
        }
        // 1.2.3-abc.123
        String a1 = "";
        String b1 = "";
        if (aSplit.length > 3) {
            for (int i = 2; i < aSplit.length; i++) {
                a1 = a1 + aSplit[i];
            }
        } else {
            a1 = aSplit[2];
        }
        if (bSplit.length > 3) {
            for (int i = 2; i < bSplit.length; i++) {
                b1 = b1 + bSplit[i];
            }
        } else {
            b1 = bSplit[2];
        }
        String[] split = a1.split("-");
        String[] split1 = b1.split("-");
        // 校验
        if (Integer.parseInt(split[0]) > Integer.parseInt(split1[0])) {
            return a;
        } else if (Integer.parseInt(split[0]) < Integer.parseInt(split1[0])) {
            return b;
        }
        // 都没有里程碑
        if (split.length == 1 && split1.length == 1) {
            return a;
        }
        // 其中一个没有里程碑
        if (split.length < 2) {
            return a;
        }
        if (split.length < 2) {
            return b;
        }
        char[] aStr = split[1].toCharArray();
        char[] bStr = split1[1].toCharArray();
        for (int i = 0; i < aStr.length; i++) {
            if (aStr[i] > bStr[i]) {
                return a;
            }
            if (aStr[i] < bStr[i]) {
                return b;
            }
        }
        // 里程碑版本排序
        return a;
    }
}
