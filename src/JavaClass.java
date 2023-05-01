public class JavaClass {

    public static void main(String args[]){
       int a  = 'A';
       int b  = 'B';
        System.out.println(a);
        System.out.println(b);
        pattern(5);

    }

    public static void pattern(int n){

        for (int i = 1;i<=n;i++){
            for (int j =1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patterns(int n){
        char a = 'A';
        for (int i =0;i<n;i++){

            for (int j = 0;j<=i;j++){
                System.out.print(a);
            }

            a++;
            System.out.println();

        }
    }

}
