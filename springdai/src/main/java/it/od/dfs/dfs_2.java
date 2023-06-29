package it.od.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dfs_2 {
    static ArrayList<Integer[]> nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        // 多层树
        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer[] node =
                    Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            nodes.add(node);
        }

        int tx = sc.nextInt();
        int ty = sc.nextInt();

        System.out.println(getResult(nodes, tx, ty));
    }

    public static String getResult(ArrayList<Integer[]> nodes, int tx, int ty) {
        // 2023.03.17，尼玛，谁能想到还有tx,ty小于0的用例，题目描述一点没说
        if (tx < 0 || ty < 0) return "{}";
        // 重新排列的双列集合
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // 从第一行开始，第一层
        dfs(matrix, nodes.get(0), 0);

        if (tx < matrix.size() && ty < matrix.get(tx).size()) {
            return "{" + matrix.get(tx).get(ty) + "}";
        } else {
            return "{}";
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> matrix, Integer[] node, Integer level) {
        // 节点为空就停止
        if (node == null) return;
        // 每行第一个为值
        int val = node[0];
        // 有该层
        if (level < matrix.size()) {
            // 添加到该层
            matrix.get(level).add(val);
        } else {
            // 没有这一层，新建这一层天爱
            ArrayList<Integer> list = new ArrayList<>();
            list.add(val);
            matrix.add(list);
        }
        // 多叉树
        for (int i = 1; i < node.length; i++) {
            // 遍历节点
            int child = node[i];
            //
            dfs(matrix, nodes.get(child), level + 1);
        }
    }
}