import java.util.Scanner;

public class Leap {

    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int leap= scan.nextInt();
        if(leap%4==0 && leap%100!=0){
            System.out.println(leap + "is a leap year");

        }else {
            System.out.println("not a leap year");
        }
    }


}
