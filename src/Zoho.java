import java.util.*;

public class Zoho {
    public static void main(String agrs[]){




    int[] arr = new int[]{3,4,1,5,2};
    int n =5;

        System.out.println(Arrays.toString(placemnt(n,arr)));


    }

    public static int[] placemnt(int input1,int[] intput2){

        int[] array = new int[input1];

        for (int i =0;i<input1;i++){
           int val = intput2[i];
           int cont = 0;
           for(int j = 0;j<i;j++){
              if (val<intput2[j]){
                  cont++;
              }
           }
           array[i] = cont;
        }

        return array;
    }

    public static void pattern(int n){

        for (int i = 1;i<=n;i++){
            int time = (n)-i+1;
            int pre = i;
            int plus = n;
            for (int j = 1;j<=time;j++){
                if (j == 1)
                    System.out.print(i+" ");
                else{
                    System.out.print(pre+plus+" ");
                    int temp = pre;
                    pre =0;
                    pre += temp+plus;
                    plus--;
                }
            }
            System.out.println();
        }


    }

    public static void zoho(String str){

        for (int i = 0;i<=(str.length()/2);i++){
            for (int j = 0;j<str.length();j++){
                int first = i;
                int second = str.length()-i-1;
                if (j == first){
                    System.out.print(str.charAt(first)+" ");
                }
                else if (j == second)
                    System.out.print(str.charAt(second)+ " ");
                else
                    System.out.print(" ");

            }
            System.out.println();

        }

        int start = str.length()/2 -1;
        int end = str.length()/2+1;

        for (int i = 0 ;i<str.length()/2;i++){
            for(int j = 0;j<str.length();j++){

                if (start == j){
                    System.out.print(str.charAt(start)+" ");

                }else if (end == j){
                    System.out.print(str.charAt(end)+" ");

                }else
                    System.out.print(" ");

            }
            start--;
            end++;

            System.out.println();
        }


    }

    class charater{

        char c;
        int frq;
    }

    public static boolean rearrange(String str1, String str2){

        if (str1.length()!=str2.length())
            return false;


        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map1 = new HashMap<>();
         for (int i =0;i<str1.length();i++){
            if (map.containsKey(str1.charAt(i)))
                map.put(str1.charAt(i),map.get(str1.charAt(i))+1);
             else
                 map.put(str1.charAt(i),1);
        }


        for (int j =0;j<str2.length();j++){
            if (map1.containsKey(str2.charAt(j)))
                map1.put(str2.charAt(j),map1.get(str2.charAt(j))+1);
            else
                map1.put(str2.charAt(j),1);
        }

        for (var get : map.entrySet()){
            if(map1.containsKey(get.getKey()) && get.getValue() == map1.get(get.getKey())){
                continue;
            }
            else
                return false;

        }
        return true;

    }

    public static void swapArray(int[] arr,int k){

        int time = arr.length/k;
        int t = 0;
        int start = 0;
        int end = k-1;

        while(t<time){
            int s =start;
            int e = end;
            int i = 0;

            while(i<k/2){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                e--;
                s++;
                i++;
            }
            t++;
            start = end+1;
            end = start+k-1;


        }
        if (arr.length%k != 0){
            int s = arr.length - (arr.length%k);
            int e = arr.length-1;

            int i =0;

           while(i<(arr.length%k)-1){

               int temp = arr[s];
               arr[s] = arr[e];
               arr[e] = temp;

               s++;
               e--;
               i++;

           }


        }
    }



    public static void date(String date1,String date2){

        int d1 = 0;
        int m1 = 0;
        int y1 =0;

        int d2 = 0;
        int m2 =0;
        int y2 = 0;

        for (int i =0;i<date1.length();i++){
            if (date1.charAt(i) == '-'){
                continue;
            }else
                if (i==0){
                   var temp= date1.charAt(i);
                   d1+=temp-'0';
                   d1 = d1*10;
                }
               else if(i==1){
                    var temp = date1.charAt(i);
                    d1+=temp-'0';
                }
               else if(i==3){
                    var temp= date1.charAt(i);
                    m1+=temp-'0';
                    m1 = m1*10;
                }else if(i==4){
                    var temp = date1.charAt(i);
                    m1+=temp-'0';
                }else if(i>5 && i<=8){
                    var temp= date1.charAt(i);
                    y1+=temp-'0';
                    y1 = y1*10;
               }
        }

    }



}
