public class Armstrong {
    static String armstrongNumber(int n){
        if(cubeOfEachnumber(n) == n)
             return "yes";
        return "no";
    }
    static long cubeOfEachnumber(int n){
        if (n == 0)
            return 0;

        int newn = n;
        newn = (int)Math.pow(newn%10,3);
        return newn+cubeOfEachnumber(n/10);
    }
}
