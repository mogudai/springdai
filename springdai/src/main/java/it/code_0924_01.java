package it;
/**
 * 1!+2!+3！+，，，+n！= 1!+(1!*2)+(1!*2*3)+...+(1!*2*3*...n)
 * */
public class code_0924_01 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(show(n));
    }

    private static int show(int n) {
        int sum = 1;
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f=f *i;
            sum=sum+f;
        }
        return sum;
    }
}
