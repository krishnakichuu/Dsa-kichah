import java.util.*;

public class Contest {

    public boolean isCircularSentence(String sentence) {

        int StringLength =0;
        for(var ch : sentence.toCharArray()){
            if(ch == ' ')
                StringLength++;
        }
       if(StringLength == 0){
           if(sentence.charAt(0) != sentence.charAt(sentence.length()-1))
               return false;
           else
               return true;
       }

       String[] str = new String[StringLength+1];
       int i = 0;
       int j =0;
       while (i<sentence.length()){
           if (sentence.charAt(i) == ' '){
               i++;
               continue;
           }else{
               String newString = "";
               while ( i<sentence.length() && sentence.charAt(i) != ' '){

                   newString+=sentence.charAt(i);
                   i++;
               }
               str[j++] = newString;
           }

       }

   for (int k = 0;k<str.length-1;k++){
       if(str[k].charAt(str[k].length()-1) != str[k+1].charAt(0))
           return false;
       if(k == str.length-2){
           if(str[k+1].charAt(str[k+1].length()-1) != str[0].charAt(0))
               return false;
       }
   }

   return true;



    }

    //merge 2D array
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int i =0;i<nums1.length;i++){
            if (map.containsKey(nums1[i][0]))
                map.put(nums1[i][0],map.get(nums1[i][0])+nums1[i][1]);
            else
                map.put(nums1[i][0],nums1[i][1]);

        }

        for (int i =0;i<nums2.length;i++){
            if (map.containsKey(nums2[i][0]))
                map.put(nums2[i][0],map.get(nums2[i][0])+nums2[i][1]);
            else
                map.put(nums2[i][0],nums2[i][1]);

        }

        int[][] mat = new int[map.size()][2];

        int k =0;
        for (var it : map.entrySet()){
          mat[k][0] = it.getKey();
          mat[k][1] = it.getValue();
          k++;
        }

        // sort the array

      return mat;

    }



    public boolean findSquarFree(int num){

        for (int i = 0;i<num;i++){
            if (i*i == num)
                return true;
            else if (i*i > num){
                break;
            }


        }

        return false;
    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int[] array = new int[]{numOnes,numZeros,numNegOnes};
       int k1 =0;
       int max =0;
        for (int i =0;i<3;i++){
            var time = array[i];
            if (i ==0){
                int k2 =0;
                while (k2<time && k1<k){
                    max+=1;
                    k1++;
                    k2++;
                }
                if (k1 == k){
                    return max;
                }
            }
          else if (i == 1){
                int k2 =0;
                while (k2<time && k1 < k){
                    max+=0;
                    k1++;
                    k2++;
                }
                if (k1 == k){
                    return max;
                }
            }

            else {
                int k2 =0;
                while (k2<time && k1<k){
                    max-=1;
                    k1++;
                    k2++;
                }
                if (k1 == k){
                    return max;
                }
            }



        }

      return max;

    }

    public boolean primeSubOperation(int[] nums){

        int max= Integer.MIN_VALUE;
        for (int i =0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }

        var listOfPrime = findPrime(max);

        int temp = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){              // 4 9 6 10
                                                          // 2 3 5 7      9-2 -> 7  9-3 -> 6   9 -5-> 4
            if (temp > nums[i]){
                 temp = nums[i];
                 continue;
            }
            int maxi =0;
            for(int j =0;j<listOfPrime.size();j++){

                if (listOfPrime.get(j) < nums[i] &&  nums[i] - listOfPrime.get(j) < temp){

                    maxi = Math.max(maxi,nums[i] - listOfPrime.get(j));


               }
            }
           nums[i] = maxi;
            temp =maxi;
        }

      for (int k = 0;k<nums.length-1;k++){
          if (nums[k] > nums[k+1]){
              return false;
          }

      }

      return true;

    }


    public List<Integer> findPrime(int max){
        List<Integer> listofprime = new ArrayList<>();

        for (int i= 2;i<=max;i++){
            if (checkPrime(i)){
                listofprime.add(i);
            }
        }

       return listofprime;
    }

    public boolean checkPrime(int num){

        int test = 0;
        for (int i = 2;i<num;i++){

            if (num%i == 0){
                test++;
            }
            if (test>0){
                return false;
            }
        }
        return true;

    }



    public int findTheLongestBalancedSubstring(String s) {

        int max =Integer.MIN_VALUE;


        for (int i =0;i<s.length();i++){
            Map<Character,Integer> map = new HashMap<>();
            map.put('0',0);
            map.put('1',0);
            for (int j=i;j<s.length();j++){

                if (s.charAt(i) == '1' && map.get('0') == 0){
                    break;
                }

                if (s.charAt(i) == s.charAt(j) && map.get('0') != 0 && map.get('1') != 0){
                    break;
                }



                map.put(s.charAt(j),map.get(s.charAt(j))+1);

                if (map.get('0') == map.get('1')){
                    max = Math.max(map.get('0')+map.get('1'),max);
                }



            }


        }

        if (max == Integer.MIN_VALUE){
            return 0;
        }

        return max;


    }

    class Pair{


        public Pair(int num, int frq) {
            this.num = num;
            this.frq = frq;
        }

        int num;
        int frq;

    }
    public List<List<Integer>> findMatrix(int[] nums) {


        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }

        Pair[] pairs = new Pair[map.size()];
        int max = Integer.MIN_VALUE;

        int i = 0;
        for (var it : map.entrySet()){
             pairs[i++] = new Pair(it.getKey(),it.getValue());
             max = Math.max(max,it.getValue());
        }



        List<List<Integer>> ans  = new ArrayList<>();

        for (int k = 1;k<=max;k++){

            List<Integer> sub = new ArrayList<>();
            for (int j =0;j<pairs.length;j++){
               if (pairs[j].frq>=k){
                   sub.add(pairs[j].num);
               }

            }
          ans.add(sub);
        }


    return ans;



    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {


        int maxeaten = 0;

        for(int i = 0;i<reward1.length;i++){
             maxeaten += (reward1[i] >= reward2[i]) ? reward1[i] : reward2[i];
        }

        return maxeaten;




    }



    public int partitionString(String s) {

        int ans = 0;
        Set<Character> set = new HashSet<>();

        for (int i =0;i<s.length();i++){

            if (set.add(s.charAt(i))){
                continue;
            }else{
                set = new HashSet<>();
                set.add(s.charAt(i));
                ans++;
            }


        }

        return ans+1;

       }

    public int minimizeArrayValue(int[] nums) {

        var list = findmax(nums);

     return  minimizeArrayValue1(nums,list);



    }

   public int minimizeArrayValue1(int[] nums,List<Integer> listofMaxin){

        if (check(listofMaxin)){
            return nums[0];
        }
        var listofind = findmax(nums);

        for (var ind : listofind){
            nums[ind]--;
            nums[ind-1]++;
        }

        var newlist = findmax(nums);

        return minimizeArrayValue1(nums,newlist);
   }

    public List<Integer> findmax(int[] nums){

        List<Integer> listofMax = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for (int i= 0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }

        for (int i =0;i<nums.length;i++){
            if (max == nums[i]){
                listofMax.add(i);
            }
        }
     return listofMax;

    }

    public boolean check(List<Integer> list){

        for (var num:list){
            if (num == 0){
                return true;
            }
        }

        return false;

    }


    public Node cloneGraph(Node node) {
       var ans= new Node(node.val);


        cloneGraphHelper(node,new HashMap<>(),ans);
        return ans;

    }
    public void cloneGraphHelper(Node node,Map<Node,Node> map,Node newNode){

        map.put(node,newNode);

        for (var nei : node.neighbors){
            if (!map.containsKey(nei)){
                var node2 = new Node(nei.val);
                newNode.neighbors.add(node2);
                cloneGraphHelper(nei,map,node2);
            }else{
                newNode.neighbors.add(map.get(nei));
            }
        }

    }


    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public int closedIsland(int[][] grid) {
        int ans = 0;

        int[][] vis = new int[grid.length][grid[0].length];

        for (int i =0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){

                vis[i][j] = -1;


            }
        }

        for(int i = 0;i<grid.length;i++){
            for (int j =0;j<grid[0].length;j++){

                if (grid[i][j] == 0 && ( i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1) && vis[i][j] == -1){

                    dfdwater(grid,vis,i,j);

                }

            }
        }

        for (int i =0;i<grid.length;i++){
            for (int j =0;j<grid[0].length;j++){

                if (grid[i][j] == 0 && vis[i][j] == -1){
                    ans++;
                    dfdwater(grid,vis,i,j);
                }

            }
        }

return ans;

    }

    public void dfdwater(int[][] grid,int[][] vis,int row, int col){

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || vis[row][col] != -1 || grid[row][col] != 0){
            return;
        }

        vis[row][col] = 0;

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};

        for (int i = 0;i<4;i++){
            dfdwater(grid,vis,row+r[i],col+c[i]);
        }
                                                      // int[] drow = {-1, 0, 1, 0};
                                                       //        int[] dcol = {0, 1, 0, -1};

    }
    public int diagonalPrime(int[][] nums) {

        int max = Integer.MIN_VALUE;

        int time = 0;
        int i =0,j = 0;
        int k =nums.length-1,l = nums.length-1;


        while (time<nums.length){
            if(findP(nums[i][j])){
                max = Math.max(max,nums[i][j]);
            }
            if(findP(nums[i][l])){
                max = Math.max(max,nums[i][l]);
            }
            i++;
            j++;
            l--;
            time++;
        }


        if (max == Integer.MIN_VALUE){
            return 0;
        }
        else
            return max;
    }

   public boolean findP(int n){
        if (n == 1)
            return false;
        int count = 0;

        for (int i = 2;i*i<=n;i++){

            if (n%i == 0)
                return false;
        }
        return true;


  }
  // [1,3,1,1,2]
  //  0 1 2 3 4 5 6
    //
    /*
       0-2 + 0-3 + 0-4
       */


    public long[] distance1(int[] nums) {

        long[] ans = new long[nums.length];

      for (int i =0;i<nums.length;i++){
            int update = 0;
          for (int j = 0 ;j<nums.length;j++){

              if (i != j && nums[i] == nums[j]){

                  update+= Math.abs(i-j);
              }

          }
          ans[i] = update;
      }
      return ans;
}


    public long[] distance(int[] nums) {

        long[] ans = new long[nums.length];

        Map<Integer,List<Integer>> map = new HashMap<>();


        for (int i =0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                var list = map.get(nums[i]);
                list.add(i);
               map.put(nums[i],list);
            }
            else{
                List<Integer> newlist = new ArrayList<>();
                newlist.add(i);
                map.put(nums[i],newlist);
            }

            /*
            1 -> 0,2,3;

             */

            for (var m : map.entrySet()){
                var list = m.getValue();

                if (list.size() == 1){
                    ans[list.get(0)] = 0;
                    continue;
                }else {
                    int sum  =0;

                    for (var val : list){
                        sum+=val;
                    }

                    int tempsum = 0;

                    for (int k =0;k< list.size();k++){
                        int index = list.get(k);

                        tempsum+=index;
                        int rightsum = sum - tempsum;
                        int leftsum = tempsum - index;

                        ans[index] = ((index *k) - leftsum) + (rightsum - ( index*(list.size()-k-1)));

                    }
                }
            }
        }

        return ans;

    }


    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0;i<s.length();i++){

            if(s.charAt(i) == '*'){
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }


        }
        StringBuilder s1 = new StringBuilder();

        // Iterate over each character in the stack and append it to the StringBuilder
        for (char c : stack){
            s1.append(c);
        }

        // Convert the StringBuilder to a string and return it as the output
        return s1.toString();
    }
    public String simplifyPath(String path) {

        List<String> stringList = new ArrayList<>();

         StringBuilder string = new StringBuilder();        //  /a/../../b/../c//.//
        for (int i =0;i<path.length();i++){

            if (path.charAt(i) == '/'){
                if (string.length()>0)
                    stringList.add(string.toString());

                string = new StringBuilder();
            }
            else if (path.charAt(i) != '/') {
              string.append(path.charAt(i));
            }

            if ( i == path.length()-1 && string.length()>0 && path.charAt(i) != '/'){
                stringList.add(string.toString());
            }

        }

   Stack<String> stack = new Stack<>();

        for (var str : stringList){                                  //  a .. .. b .. c .
            if(str.equals("..")){
                if (!stack.isEmpty())
                    stack.pop();
                else
                    continue;
            }else if(str.equals(".")){
                continue;
            }else {
                stack.add(str);
            }

        }

        if (stack.isEmpty()){
            return "/";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (var sta : stack){
            stringBuilder.append("/");
            stringBuilder.append(sta);
        }

        return stringBuilder.toString();

    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        int j =0;
        for (int i =0;i<pushed.length;i++){               // : pushed = [1,2,3,4,5], popped = [4,5,3,2,1]   1 2 3 4

            stack.push(pushed[i]);

            while (stack.peek() == popped[j]){
                stack.pop();
                j++;
            }

         }

        if (stack.isEmpty())
            return true;

        return false;


    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {


        int max = Integer.MIN_VALUE;

        for(int i =0;i<candies.length;i++){
           max = Math.max(max,candies[i]);
        }

        List<Boolean> ans =new ArrayList<>();


        for (int i = 0;i<candies.length;i++){

            if (candies[i]+extraCandies >= max){
                ans.add(true);
            }else {
                ans.add(false);
            }
        }

        return ans;

    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount+1];

        for (int i = 0;i<dp.length;i++){
            for (int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }


         return helperchange(coins.length-1,amount,coins,dp);
    }


    public int helperchange(int ind,int target,int[] coins,int[][] dp){

        if (ind ==0){
           if(target%coins[ind] == 0){
               return 1;
           }else {
               return 0;
           }

        }
        if (dp[ind][target] != -1){
            return dp[ind][target];
        }

        int nottake = helperchange(ind-1,target,coins,dp);
        int take = 0;
        if (target>=coins[ind]){
            take = helperchange(ind,target-coins[ind],coins,dp);
        }

        return dp[ind][target] = nottake+take;


    }

}