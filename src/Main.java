import java.util.*;

public class Main{
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

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
