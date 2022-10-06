package it;

/**
 * 不等概率01到等概率返回01
 */
public class code_0925_02 {

    public static void main(String[] args) {
        int testTimes = 1000000;
        int[] ints = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int i1 = y();
            ints[i1]++;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(i +"这个数出现了"+ints[i]+"次");
        }
    }



    /**
     * 固定概率返回 0 或者 1
     */
    private static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 固定概率返回 0 或者 1
     */
    private static int y() {
        int ans = 0;
        do{
            ans=x();
        }while (ans == x());
        return ans;
    }

}
