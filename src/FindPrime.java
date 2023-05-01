public class FindPrime {
    public static String isPrime(int n){
        if(n == 2)
            return "is not prime";
        int count  = 0;
        for (int i = 2; i< n; i++) {
            if(n % i == 0)
                count++;
        }
        if(count>1)
            return "is non prime";

        return "is prime";
    }
}
