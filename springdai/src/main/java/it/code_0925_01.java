package it;

/**
 * 随机返回1-5
 * 随机返回 等概率0-1
 * 随机返回 等概率0-7
 * 随机返回 等概率0-6
 * 随机返回 等概率1-7
 */
public class code_0925_01 {

    public static void main(String[] args) {
        int testTimes = 1000000;
        int[] ints = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int i1 = g();
            ints[i1]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i +"这个数出现了"+ints[i]+"次");
        }
    }
    /**
     *  001
     *  010
     *  011
     *  100
     *  ...
     * 随机返回 等概率1-7
     * @return
     */
    private static int g() {return f4()+1;
    }

    /**
     *  001
     *  010
     *  011
     *  100
     *  ...
     * 随机返回 等概率0-6
     * @return
     */
    private static int f4() {
        int ans=0;
        do {
            ans = f3();
        }while (ans==7);
            return ans;
    }


    /**
     *  001
     *  010
     *  011
     *  100
     *  ...
     * 随机返回 等概率0-7
     * @return
     */
    private static int f3() {
        return (f2()<<2)+(f2()<<1)+(f2()<<0);
    }

    /**
     * 随机返回 等概率0-1
     */
    private static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 随机返回1-5
     */
    private static int f1() {
        return (int) (Math.random() * 5) + 1;
    }


}
