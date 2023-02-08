public class LcmGcd {
    static long[] lcmAndGcd(long A , long B) {
        long[] ans = new long[2];
        ans[0] = lcm(A,B);
        ans[1] = gcd(A,B);
        return ans;

    }
    public static long gcd(long A,long B ){
        if(A==0)
            return B;
        return gcd(B%A,A);
    }
    public static long lcm(long A,long B){
        return A / gcd(A,B) * B;
    }
}
