package it.od;

import java.util.Scanner;

public class Od006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());
        int b = Integer.parseInt(scanner.next());
        int count = 0;
        for (int i = a; i <=b; i++) {
            String s = Integer.toBinaryString(i);
            if(s.contains("101")){
                count++;
            }
        }
        System.out.println(count);
    }
}
