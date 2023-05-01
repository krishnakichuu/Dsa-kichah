import java.awt.geom.QuadCurve2D;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {


        System.out.println(hcf(24,10));



    }
      /*      1
              1 0
              1 0 1
              1 0 1 0
              1 0 1 0 1     */

    public static int hcf(int num1,int num2){

        int time =( num1>num2 )? num1 : num2;

       int max = Integer.MIN_VALUE;

        for(int i = 1;i<=time;i++){
        if (num1 % i == 0 && num2 % i ==0){
            if (max < i){
                max = i;
            }

           max = Math.max(max,i);
        }


        }


      return max;
    }


    public static void p9(int n){

        for (int i =1;i<=n;i++){
            for (int j = 1;j<=n;j++){
                if (i == j){
                    System.out.print(j);
                }
                else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }


    }


    public static void p8(int n){

        for (int i = 1;i<=n;i++){

            for (int j = 1;j<=i;j++){
                System.out.print(j%2);
            }
            System.out.println();
        }
    }


    public static void p7(int n){

        for (int i =1;i<=n;i++){

            int temp = n-i;

            for (int j = 1;j<=temp;j++) {
                System.out.print(" ");
            }
                for (int k = 1;k<=i;k++){
                    System.out.print(k);
                }

                    for (int k = 1;k<=i-1;k++){
                        System.out.print(k);
                    }


            System.out.println();

        }

    }

    public static void p6(int n){


        for (int i = 1;i<=n;i++){
            var temp = n-i;
            for (int j =1;j<=n;j++){
                if (j<=temp){
                    System.out.print(" ");
                }else {
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }

    }


    public static void p5(int n){

        for (int i =1;i<=n*2;i++) {

            if (i<=n){
            for (int k = 1; k < i; k++) {
                System.out.print(" ");
            }

            for (int j = i; j <= n; j++) {
                System.out.print(j);
            }
        }


            else {
                for (int k = 1;k<=n;k++){

                    var t = n - (i%n);

                    if (n*2 == i){
                        t =0;
                    }

                    if (k <= t){
                        System.out.print(" ");
                    }else{
                        System.out.print(k);
                    }

                }
            }

            System.out.println();
        }


    }

    public static void p4(int n){
        for (int i =1;i<n*2;i++){
         if (i<=5){
             for (int j = 1;j<=n-i;j++){
                 System.out.print(" ");
             }
             for (int k = 1;k<=i;k++){
                 System.out.print(k+"");
             }
         }
         else {
             for (int j = 1;j<=i%n;j++){
                 System.out.print(" ");
             }

             for (int k = 1;k<=n-i%n;k++){
                 System.out.print(k+"");
             }
         }

            System.out.println();

        }


    }

    public static  void p3(int n){

        for (int i =1;i<=n;i++){

            for (int k = 1;k<i;k++){
                System.out.print(" ");
            }
            for (int j = 1;j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }


    }
   public static void p2(int n){

       for(int i =1;i<=n;i++){
           int temp = 1;
           for (int j = 1;j<=i;j++){
               System.out.print(temp++);
           }
           temp--;
           for (int k =1;k<i;k++){
               System.out.print(--temp);
           }

           System.out.println();
       }


   }

    public static void p1(int n){
        for (int i =1;i<=n;i++){
            int temp = 0;
            for (int j =1;j<=n;j++){
                if ((n-i+1) == j || j==n){
                    System.out.print(1 + " ");

                }else if ( i>2 && ( (n-i+1+1) == j || j == n-1 ) ){
                    System.out.print(i-1+" ");
                    temp = i-1;

                }
                else if ( ( i%2 == 0 ) &&  (n-i+1) <= j ){

                    int mul = i/2 -1;

                    System.out.print("* ");
                }

                else
                    System.out.print(" ");
            }

            System.out.println();
        }




    }











    public static List<Integer> valid(List<Integer> input){
        List<Integer> ans = new ArrayList<>();
        int[] array = new int[31];

        for (var it : input){
                array[it]++;
        }

        for (int i = 20;i<array.length;i++){
            if (array[i] == 0 || array[i] > 1){
                ans.add(i);
            }
        }
        return ans;

    }


    public static List<String> getVist(int input){

        List<String> output = new ArrayList<>();

        for(int i = 1;i<=input;i++){
          if (i % 2 != 0 && i%5 != 0){
              output.add("\"Visitor "+i +"\"");
          }
          else if(i%2 == 0 && i % 5 ==0) {

              output.add("\"Visitor "+i+" God save the king & queen"+"\"");
          }
          else if (i%2 == 0){
              output.add("\"Visitor "+i+" God save the king"+"\"");

          }
          else{
              output.add("\"Visitor "+i+" God save the queen"+"\"");
          }
        }
        return output;

    }

    public static int stair(int input){

        if (input == 0)
            return 0;

        if (input == 1)
            return 1;

        if (input % 3 == 0)
            return 1;

        if ((input-1) % 3 == 0)
            return 1;

            return 0;

    }

    class Pairof{


        public Pairof(int node, int des) {
            this.node = node;
            this.des = des;
        }

        int node;
        int des;


    }

    public String graph(int input){
        List<List<Pairof>> list = new ArrayList<>();

        for (int i =0;i<5;i++){
            list.add(new ArrayList<>());
        }

        list.get(0).add(new Pairof(1,2));
        list.get(0).add(new Pairof(2,1));
        list.get(1).add(new Pairof(1,1));
        list.get(1).add(new Pairof(4,4));
        list.get(2).add(new Pairof(4,7));
        list.get(2).add(new Pairof(3,6));
        list.get(3).add(new Pairof(2,3));
        list.get(4).add(new Pairof(4,3));




      return "dwlkdfw";

    }

    public static String vaild(String Input1){


        String z = "(\\d{1,2}|(0|1)\\"+"d{2}|2[0-4]\\d|25[0-5])";
        String regex = z+"\\." + z+"\\." + z+"\\." + z;


        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(Input1);

        if (m.matches()){
            return "VALID";
        }else
            return "INVALID";




    }

    public static List<String> generate(List<String> Input1){

        List<String> ans = new ArrayList<>();

        for(int i = 0;i<Input1.size();i++){
            String str = Input1.get(i);
           for(int j = i+1;j<Input1.size();j++){
              if (validation(str,Input1.get(j))){
                  ans.add(str +"-"+ Input1.get(j));
              }
           }
        }

        return ans;

    }

    public static boolean validation(String str1,String str2){
        int check = 0;
        String whichSmall;
        String whichBig;

        if(str1.length()>str2.length()){
          whichBig = str1;
          whichSmall = str2;
        }else {
            whichBig = str2;
            whichSmall = str1;
        }

        for (int i=0;i<whichBig.length();i++){
            for (int j= 0;j<whichSmall.length();j++){
                if (whichBig.charAt(i) == whichSmall.charAt(j)){
                    check++;
                }
            }
        }
        if (check == 0){
            return true;
        }
        else
           return false;



    }





















    public static boolean checkPara(String str){

        Stack<Character> stack = new Stack<>();

        for (int i =0;i<str.length();i++) {
            if (str.charAt(i) == '(') {
                stack.add(str.charAt(i));
            } else if (str.charAt(i) == ')'){
                if (stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
            if (stack.isEmpty()){
                return true;
            }else
                return false;

    }

    public static int[] alternativesorithing(int[] array){
        int[] array1;
        int[] array2;

        if (array.length%2==0){
         array1 = new int[array.length/2];
         array2 = new int[array.length/2];
        } else {
            array1 = new int[array.length/2];
            array2 = new int[(array.length/2)+1];
        }

        for(int i = 0;i<array1.length;i++){
           array1[i] = array[i];
        }
        int j = array.length-1;

      for (int i = 0;i<array2.length;i++){
          array2[i] = array[j--];
      }

      int[] newarray = new int[array.length];
      int i =0;
      int m = 0;
      int l =0;

      int n = (array1.length>array2.length) ? array2.length : array1.length;

      while (l<n && m<n){
          newarray[i++] = array2[m++];
          newarray[i++] = array1[l++];
      }

      if(array2.length>array1.length){
          newarray[i] = array2[array2.length-1];
      }else if (array1.length>array2.length){
          newarray[i] = array1[array1.length-1];
      }

      return newarray;

    }

    public static void numberpattern(int n){

        for (int i = 1;i<=n;i++){
            int pre = i;
            for (int j = 1;j<=i;j++){

               if (j==1){

                   System.out.print(i+" ");
                   pre = i;
               }
               else if (j%2 == 0){
                   int now =  pre + ((n-i) + (n-i) + 1);
                   System.out.print(now+" ");
                   pre = now;
               }else {

                   int nowhere = pre +(i-(j-1)) +(i-j) + 1;
                   System.out.print(nowhere+" ");
                   pre = nowhere;

               }

            }
            System.out.println();
        }






    }
     public static  void arrays(int[] array) {

        int[] minarray = new int[array.length];

        for (int i =0;i<array.length;i++){

            minarray[i] = -1 *array[i];
        }

        Arrays.sort(minarray);
        for (int i = 0;i<array.length ;i++){
            array[i] = -1 * minarray[i];
        }



     }        public static int oddsum(int[] array){

        int oddsum =0;
        int evensum =0;

        for (int i = 0;i<array.length;i++){
            if (array[i] % 2 == 0)
                evensum+=array[i];
            else
                oddsum+=array[i];
        }
         int ans= oddsum%evensum;

        return ans;
        }

        public static String changeAlpha(String str){

        String string = "";

        for (int i =0;i<str.length();i++){

            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                string+=(char) (str.charAt(i) - 'a' + 'A');

            }
            else{
               string += (char) (str.charAt(i) - 'A' + 'a');


            }
        }
        return string;
        }


public static void patternyes(int n){

        for (int  i = n;i>0;i--){
            for (int j =i;j>0;j--){
                System.out.print(j);
            }
            System.out.println();

        }

}



    public static void patternsmak(int num){
         for (int i = 0;i<num;i++){

             for (int j = 0;j<num;j++){
                 if (i == 0 || j ==0 || i == num-1 || j == num-1){
                     System.out.print("*");
                 }else
                     System.out.print(" ");
             }
             System.out.println();
         }


    }
    public static void pattern111(int num){
        int center = num/2;
        for(int i = 0;i<num;i++){
            for (int j=0;j<num;j++){
                if (i<=center && j ==0 ||
                        i == 0 && j>= center ||
                        (i==num-1 && j<=center ) ||
                        (j == num-1 && i>=center) ||
                        j == center ||i == center )
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }


    }

    // Function to return the adjacency list for each vertex.
    public static ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> pg) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){

            ArrayList<Integer> temp = new ArrayList<>();

            temp.add(i);

            adj.add(temp);

        }
        for(int i = 0; i < pg.size(); i++){
            adj.get(pg.get(i).get(0)).add(pg.get(i).get(1));
            adj.get(pg.get(i).get(1)).add(pg.get(i).get(0));
        }
        return adj;

    }
   
    class Node{
        char v;
        int tims;

        public Node(char v,int tims) {
            this.v = v;
            this.tims=tims;
        }
    }
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxEnd = 0;

        for (int j = 0;j< (2*nums.length)-1;j++){
            maxEnd+=nums[j%5];
            if(max<maxEnd)
                max = maxEnd;
            if (maxEnd <0)
                maxEnd =0;
        }

        return max;

    }
     public static long countGood(int[] nums, int k) {

        Map<Integer,Integer> map;
        int ans = 0;
        for (int i =0;i<nums.length;i++){
            map = new HashMap<>();
            for (int j = i;j<nums.length;j++){

                if (map.containsKey(nums[j]))
                    map.put(nums[j],map.get(nums[j])+1);
                else
                    map.put(nums[j],1);

                int mapPiairCount =0;

                for (var m : map.values()){
                    if (m>=2)
                        mapPiairCount++;
                }
                if (mapPiairCount >= k)
                    ans++;

            }
        }
        if (ans == 0)
            return 1;
return ans;


    }
    public static int differenceOfSum(int[] nums) {
      int total = 0;
        int digitaltotal = 0;
      for (int i = 0;i<nums.length;i++){
          total+=nums[i];

          if (nums[i] < 10){
              digitaltotal+=nums[i];
          }else {
              int temp = nums[i];
              while (temp != 0){
                  int toAdd = (temp%10);
                  digitaltotal+=toAdd;
                  temp = temp/10;
              }
          }
      }
      return Math.abs(total-digitaltotal);

    }
    public static int[][] rangeAddQueries(int n, int[][] queries) {
      int[][] mat = new int[n][n];

      for (int i=0;i<queries.length;i++){
          int rowS,colS,rowE,colE = 0;
              rowS = queries[i][0];
              colS = queries[i][1];
              rowE = queries[i][2];
              colE = queries[i][3];

       for (int r = rowS; r<=rowE;r++){
           for (int c= colS;c<=colE;c++){
               mat[r][c]++;
           }
       }

      }
 return mat;

    }
    public void findVowels(String s){

        String vowels = "aeiou";

        Node[] node = new Node[5];

        for(int i=0;i<node.length;i++){
            node[i] = new Node(vowels.charAt(i),0);
        }

        for (int i = 0 ;i<s.length();i++){

            if(s.charAt(i) == 'a' || s.charAt(i) == 'A')
                node[0].tims = node[0].tims + 1;
           else if(s.charAt(i) == 'e' || s.charAt(i) == 'E')
                node[1].tims = node[1].tims + 1;
           else if(s.charAt(i) == 'i' || s.charAt(i) == 'I')
                node[2].tims = node[2].tims + 1;
            else if(s.charAt(i) == 'o' || s.charAt(i) == 'O')
                node[3].tims = node[3].tims + 1;
            else if(s.charAt(i) == 'u' || s.charAt(i) == 'U')
                node[4].tims = node[4].tims + 1;

        }

        for (int i = 0;i<node.length;i++){
            for (int j = i;j<node.length;j++){
                if(node[i].tims < node[j].tims){
                    var temp = node[j];
                    node[j] = node[i];
                    node[i] = temp;
                }
            }
        }
        for (int i = 0;i<5;i++){
            if (node[i].tims == 0){
                break;
            }
            System.out.println(node[i].v + " = " + node[i].tims);
        }
    }

    public static int similarPairs(String[] words) {

        int ans = 0;

        ArrayList<Set<Character>> similar = new ArrayList<>();



        for (int i = 0;i<words.length;i++){
            Set<Character> tempset = new HashSet<>();
            var intostrArray = words[i].toCharArray();
            Arrays.sort(intostrArray);
            for (int j= 0; j < intostrArray.length; j++){
                 tempset.add(intostrArray[j]);
            }

            similar.add(tempset);

       }

        for ( int i = 0;i<similar.size();i++){
            for (int j = i+1;j<similar.size();j++){
                if(similar.get(i).equals(similar.get(j)))
                    ans++;
            }
        }

        return ans;


    }





    public static boolean uniqueOccurrences(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(var val : arr){
            map.put(val,1+map.getOrDefault(val,0));
        }

        for(var mapVal : map.values()){
           set.add(mapVal);
        }

        if(set.size() == map.size())
            return true;

        else
            return false;

    }

    public static boolean halvesAreAlike(String s) {
        Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');//'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
        int length = s.length();
        int half = s.length()/2;
        int fisrtHalfcount = 0;
        int secondHalfcount = 0;
        for (int i = 0 ;i<half;i++){
            if(s.charAt(i) == 'a' ||s.charAt(i) == 'e' ||s.charAt(i) == 'i'
                    ||s.charAt(i) == 'o' ||s.charAt(i) == 'u'
                    ||s.charAt(i) == 'A' ||s.charAt(i) == 'E'
                    ||s.charAt(i) == 'I' ||s.charAt(i) == 'O'
                    ||s.charAt(i) == 'U')
                fisrtHalfcount++;

            if(s.charAt(i+half) == 'a' ||s.charAt(i+half) == 'e'||
                    s.charAt(i+half) == 'i' || s.charAt(i+half) == 'o'||
                    s.charAt(i+half) == 'u' ||s.charAt(i+half) == 'A'
                    ||s.charAt(i+half) == 'E' ||s.charAt(i+half) == 'I'
                    ||s.charAt(i+half) == 'O' ||s.charAt(i+half) == 'U')
                secondHalfcount++;

        }

       if (fisrtHalfcount == secondHalfcount)
           return true;

       return false;



    }


    public static int averageValue(int[] nums){
        int ans =0;
         int total = 0;
         int count =0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] % 2 == 0 && nums[i] % 3 == 0){
                total+=nums[i];
                count++;
            }
        }
         if (count == 0)
             return 0;

        ans = total/count;

            return ans;



    }
    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views){

          List<List<String>> ans = new LinkedList<>();
          Map<String,Integer> map = new LinkedHashMap<>();
          Map<String ,String > str = new LinkedHashMap<>();

          for (int i =0;i<creators.length;i++){
              if(map.containsKey(creators[i])){
                  map.put(creators[i],map.get(creators[i])+views[i]);
              }
              else
                  map.put(creators[i],views[i]);
          }

          Map<String ,Integer> decending = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> decending.put(x.getKey(), x.getValue()));

        for (var items : decending.entrySet()){
            List<String> string = new LinkedList<>();
            for (int i = 0; i < creators.length; i++) {

                if (creators[i] == items.getKey()){

                  if(str.containsKey(creators[i])){

                      var s1 = str.get(creators[i]);
                      int val = s1.compareTo(ids[i]);
                      if(val>=0){
                          string.add(creators[i]);
                          string.add(ids[i]);
                      }
                      else{
                          string.add(creators[i]);
                          string.add(s1);
                      }
                  }
                  else{
                      str.put(creators[i],ids[i]);
                  }
                }

            }
            if (!string.isEmpty())
            ans.add(string);
        }
        return ans;

    }



    public static boolean haveConflict(String[] event1, String[] event2) {
        int event1start = 0, event1end=0, event2start=0, event2end=0;

        for (int i = 0; i < event1.length; i++) {
            var ch = event1[i].toCharArray();
            for (int j = 0; j < event1[i].length(); j++) {
                if (i == 0){
                    if(ch[j] != ':'){
                        event1start *=10;
                        event1start += Integer.parseInt(String.valueOf(ch[j]));

                    }else
                        continue;
                }
            else {
                 if(ch[j] != ':'){
                     event1end *=10;
                     event1end+= Integer.parseInt(String.valueOf(ch[j]));
                 }
                 else
                     continue;
                }
            }
        }

        for (int i =0;i<event2.length;i++){
            var ch = event2[i].toCharArray();
            for(int j =0;j<event2[i].length();j++){
                if(i==0){
                    if(ch[j] != ':'){
                        event2start *= 10;
                        event2start += Integer.parseInt(String.valueOf(ch[j]));
                    }else
                        continue;
                }else {
                    if(ch[j] != ':'){
                        event2end *= 10;
                        event2end +=Integer.parseInt(String.valueOf(ch[j]));
                    }else
                        continue;

                }


            }
        }

        if(event2start >= event1start && event2start<=event1end)
        return true;
        else if(event2end>=event1start &&event2end<=event1end)
            return true;
        else if(event1start>=event2start && event1start<=event2end)
            return true;
        else if(event1end>=event2start && event1end<= event2end)
            return true;

        return false;
    }

    static void array1(int[] arr){
     int max = arr[arr.length-1];

        for (int i = arr.length-2; i>=0;i--){
            int pre = arr[i];
            arr[i] = max;
            max = Math.max(max,pre);

        }
//        for (int i = 0;i<arr.length-1;i++)
//        arr[i] = arr[i+1];

        arr[arr.length-1] = -1;
    }

    int max = Integer.MIN_VALUE;

    //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
    //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

  // [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483646]
  // [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]

    static void array(int[] arr){

        int max;
        for (int i =0;i<arr.length-1;i++){
            max = Integer.MIN_VALUE;
            for(int j = i+1;j<arr.length;j++){
                max = Math.max(max,arr[j]);
            }
            arr[i] = max;
        }
        arr[arr.length-1] = -1;


    }

    static void parttern(int n) {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (j % 2 == 0)
                    System.out.print((n * (j)) + i + 1 + " ");
                else
                    System.out.print((n * (j + 1)) - i + " ");
            }
            System.out.println();
        }
    }

    static void parttern1(int row){
        for (int i = 1; i <=row ; i++) {
            for (int j = 1;j <= i; j++){
                System.out.print(j);
        }
            System.out.println();
        }

        for (int i = row; i > 1 ; i--) {
            for (int j = 1 ;j < i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void patter(int row){
        for (int i = row; i > 0; i--) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1 ; j<=i; j++){
                System.out.print(j);

            }
            System.out.println();
        }
    }
    
    static void parttern4(int row){
        for (int i = 1; i <= row ; i++) {
            for (int j = i; j < row ; j++) {
                System.out.print(" ");
            }
                for (int k = 1; k <= i ; k++) {
                    System.out.print(k+" ");
                }
            System.out.println();
            }

        }

        static void parttern5(int row){
            for (int i = 1; i <= row ; i++) {
                for (int j = row; j>=i; j--){
                    System.out.print(j);
                }
                System.out.println();
            }
        }

        static void pattern6(int row){
        for(int i =row; i>0 ; i--){
            for(int j =row ; j>=i ; j--)
                System.out.print(j);

            System.out.println();
        }

        }
        static void pattern7(int row){
            for (int i = row; i > 0 ; i--) {
                for (int j =1; j<=i ; j++)
                    System.out.print(j);

                System.out.println();
            }
        }

        static void pattern8(int row){
              int k =1;
        for(int i= 1; i<= row; i++){

            for(int j = 1; j<=i; j++){

                System.out.print(k+ "    ");
                  k++;
            }
            System.out.println();
        }
        }

        static void pattern9(int row){
            for (int i = 1; i <= row; i++) {
                for (int j = i; j >= 1 ; j--) {
                    System.out.print(j);
                }
                System.out.println();
            }
        }

        static void parttern10(int row){
            for (int i = 1; i<=row; i++ ){
                for(int j = 1; j<=i; j++)
                    System.out.print(j+" ");

                for (int j = i-1; j >=1; j--) {
                    System.out.print(j+" ");
                }

                System.out.println();
            }


        }

        static void pattern11(int row){
        for (int i = 1; i<=row; i++){
            for (int j=1;j<i; j++)
                System.out.print(" ");

            for(int k = 1;k<=row-i+1; k++)
            System.out.print(k+" ");

            System.out.println();
        }
        }


        static void pattern(int row){
       for (int i = row ;i>0; i--) {
           for (int j = 1; j<i; j++) {
               System.out.print(" ");
           }
           for (int k =1 ;k<=row-i+1;k++)
               System.out.print(k+" ");

           System.out.println();
       }

       for(int i = 1; i<row; i++)
       {
           for (int j=1; j<=i ;j++)
               System.out.print(" ");

           for(int k = 1; k<=row-i; k++)
               System.out.print(k+" ");

           System.out.println();


       }

        }


        static void pattern12(int row){

            for (int i = 1; i <=row ; i++) {
                for(int j = 1 ; j<i ; j++){
                    System.out.print(" ");
                }
                for(int k = i; k<=row ; k++){
                    System.out.print(k+"");
                }
                System.out.println();
            }
            for (int i = row; i >= 1; i--) {
                for (int j = 1; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = i;j<=row;j++)
                System.out.print(j+" ");

                System.out.println();
            }

        }

        static void pattern13(int row){
       for (int i = row; i>= 1; i--){
           for (int j =1;j<i; j++){
               System.out.print(" ");
           }
           for (int k = row; k>=i ; k--){
               System.out.print(k+ " ");
           }
           System.out.println();
       }

        }
        static void pattern14(int row){
       for(int i = 1; i<=row; i++){
           for (int j = row; j> i ;j--)
               System.out.print(" ");

           for (int k =1 ; k<=i ; k++)
               System.out.print(k);

           for(int l = i-1; l>=1; l--)
               System.out.print(l);

           System.out.println();
       }

        }


        static void pattern15(int row){
        for (int i =1; i<=row; i++){
            for (int j = 1;j<=i;j++){
                var k = (j%2==1) ?  1:0;
                System.out.print(k);
            }
            System.out.println();
        }
        }

        static void pattern16(int row){
          for (int i = 1; i<=row; i++){
              for (int j = 1;j<= row; j++)
                  if(i==j)
                  System.out.print(j+" ");
              else
                  System.out.print(0+" ");
              System.out.println();
          }

        }


}




    /*
1
1 2 1
1 2 3 2 1
1 2 3 4 3 2 1
1 2 3 4 5 4 3 2 1



     */
