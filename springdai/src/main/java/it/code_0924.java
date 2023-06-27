package it;
/**
 * 1!+2!+3！+，，，+n！
 * */
public class code_0924 {
    public static void main(String[] args) {
        int n=5;
        int shows = shows(n);
        System.out.println(shows);
    }
    //  !+2!+3！+，，，+n！
     static int shows(int n) {
        int j = 0;
        for (int i = 1; i <=n ;i++) {
          j=  j+ show(i);
        }
        return j ;
    }
    // N!
    static int show(int n){
        if(n==1){
            return 1;
        }else {
            int i = show(n-1) *n;
            return i;
        }
    }
}
