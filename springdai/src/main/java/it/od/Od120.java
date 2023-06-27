package it.od;

import java.util.Scanner;

class Od120 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int[][] arr = new int[a][b];
        boolean[][] booleans = new boolean[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] == 0) {
                    booleans[i][j] = false;
                } else {
                    booleans[i][j] = true;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (arr[i][j] == 1) {
                    if (i - 1 > -1) {
                        booleans[i - 1][j] = true;
                    }
                    if (i + 1 < a) {
                        booleans[i + 1][j] = true;
                    }
                    if (j + 1 < b) {
                        booleans[i][j + 1] = true;
                    }
                    if (j - 1 > -1) {
                        booleans[i][j - 1] = true;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (booleans[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
