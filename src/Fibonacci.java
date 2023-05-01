import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int []array=new int[n+1];
        array[0]=0;
        array[1]=1;
        for(int i=2;i<=n;i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        System.out.println(Arrays.toString(array));
    }
}
