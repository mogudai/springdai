package it;

public class Test {

    public static void main(String[] args) {
        int[] coins = {7,2,5};
        int M = 29;
        int i = coinChage(coins, M);
        System.out.println(i);
    }


    /**
     *
     * @param coins 代表硬币的种类
     * @param M 代表拼凑的值 27
     * @return
     */
    public static int coinChage(int[] coins, int M) {
        //新建一个长度28的数组
        int[] f = new int[M + 1];
        //number of kinds of coins
        int n = coins.length;
        //initialization
        f[0] = 0;
        //遍历数组27次
        for (int i = 1; i <= M; i++  ){
            //给定上限值
            f[i] = Integer.MAX_VALUE;
            //f[X]=min{f[X-2]+1,f[X-5]+1,f[X-7]+1}
            for (int j = 0; j < n; j++) {
                if (i >= coins[j] && f[i-coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i-coins[j]] + 1, f[i]);
                }
            }
        }

        if (f[M] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[M];
    }

}
