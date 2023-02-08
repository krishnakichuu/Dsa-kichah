public class DivisiorSum {
    public static long sumOfDivisor(int n){

        return sumtheValu(n);

    }
    public static long sumtheValu(int n){
        if(0>=n)
            return 0;
        int j =0;
        for (int i = 1; i <= n; i++)
            if(n% i == 0)
                j += i;

        return j + sumtheValu(n-1);
    }
}
