import java.util.Scanner;

public class Pratice{
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a prime number");
        n = sc.nextInt();

        for (int j = 2; j <= n; j++){
            int time = 0;
            for (int i = 2; i < j; i++) {
                if (j % i == 0) {
                    time++;
                }
                if (time > 0) {
                    System.out.println( j + "is not a prime number");
                    break;
                }
            }
            if (time == 0) {
                System.out.println(j +"is a prime number ");
            }

        }
    }

}
