import javax.swing.*;
import java.security.interfaces.XECPrivateKey;
import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {

    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        for (int i =0;i<dp.length;i++){
            dp[i] = -1;

        }
        return helperclimbStairs(dp,n);

    }

    public int helperclimbStairs(int[] dp,int n){

        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;


        if (dp[n] != -1)
            return dp[n];

        return dp[n] = helperclimbStairs(dp,n-1) + helperclimbStairs(dp,n-2);


    }

 public int climbStairsT(int n){

        if (n == 1)
            return 1;
     if (n == 2)
         return 2;
     if (n == 0)
         return 1;


        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3;i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[dp.length-1];

 }


    public int minimumEnergy(int arr[],int N){

       return helper(arr,N-1);

    }
    public int helper(int arr[],int N){

        if(N == 0){
            return 0;
        }

        if (N == 1){
            return Math.abs(arr[N] - arr[N-1]);
        }
        if (N==2){
            return Math.abs(arr[N] - arr[N-2]);
        }

        int left = helper(arr,N-1) + Math.abs(arr[N] - arr[N-1]);

        int right = helper(arr,N-2) + Math.abs(arr[N] - arr[N-2]);



        return Math.min(left,right);
    }


    public int minimumEnergyT(int arr[],int N){

        int[] dp = new int[N+1];

        for (int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        return helperminimumEnergyT(arr,dp,N-1);

    }

   public int helperminimumEnergyT(int arr[] , int[] dp , int N){

        if (N == 0){
            return 0;
        }
        if (N == 1){
            return Math.abs(arr[N] - arr[N-1]);
        }
        if (N==2){
            return Math.abs(arr[N] - arr[N-2]);
        }

        if (arr[N] != -1){
            return arr[N];
        }

        int left = helperminimumEnergyT(arr,dp,N-1)  + Math.abs(arr[N] - arr[N-1]);
        int right = helperminimumEnergyT(arr,dp,N-2)  + Math.abs(arr[N] - arr[N-2]);

        return dp[N] = Math.min(left,right);


    }

   public int helperminimumEnergyTable(int[] arr,int N,int k){

        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 1;i<dp.length;i++){

            int min = Integer.MAX_VALUE;
                for(int j = 1;j<=k;j++){
                    if (i-j >= 0) {
                      int temp = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                      min = Math.min(temp, min);
                  }
                }
                dp[i] = min;


        }

        return dp[dp.length-1];
   }

   public int minPathSum(int[][] grid){

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[i].length;j++){
                dp[i][j] = -1;
            }
        }

        return helperminPathSum(grid,0,0,dp);

    }

   public int helperminPathSum(int[][] grid,int row, int col,int[][] dp){                 //  1 3 1
                                                                                          //  1 5 1
        if (row >= grid.length || col >= grid[0].length)                                  //  1 4 2
            return Integer.MAX_VALUE;                                                     //  2 3 2 6 8 19 7 10 1

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int left = helperminPathSum(grid,row+1,col,dp);
        int right = helperminPathSum(grid,row,col+1,dp);

        if (left != Integer.MAX_VALUE && right == Integer.MAX_VALUE){
            right = Integer.MAX_VALUE;
        }else if (left == Integer.MAX_VALUE && right != Integer.MAX_VALUE){
            left = Integer.MAX_VALUE;
        }else if(left == Integer.MAX_VALUE && right == Integer.MAX_VALUE){
            left =0;
            right =0;
        }


        return dp[row][col] = grid[row][col] + Math.min(left,right);



   }
    public int mincostTickets(int[] days, int[] costs) {

return 0;

    }

    public int helpermincostTickets(int[] days, int[] costs,int i,int costsi){


return 0;



    }


    public int maximumPoints(int points[][],int N){

        int dp[][] = new int[N][4];

        for (int i =0;i<dp.length;i++){
            for (int j = 0;j<dp[i].length;j++){
                dp[i][j] = -1;
            }
        }


        return helperpoints(dp,points,N-1,3);
    }

    public int helperpoints(int[][] dp , int points[][], int ind , int last){

        if (ind == 0){
            int max =0;
            for (int task = 0;task<3;task++){
              if (last != task){
                  max = Math.max(points[ind][task],max);
              }
            }
            return max;
        }

        if (dp[ind][last] != -1) return dp[ind][last];

        int maxi  = 0;

        for(int task = 0;task<3;task++){
           if (task != last) {
               int p = points[ind][task] + helperpoints(dp,points,ind-1,task);
              maxi = Math.max(maxi,p);

           }

        }
        return dp[ind][last] = maxi;
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                dp[i][j] = -1;
            }
        }


        int[][] grid = new int[m][n];


        return helperuniquePaths(dp,grid,0,0);


    }

    public int helperuniquePaths(int[][] dp ,int[][] grid, int m, int n){



        if (m >= grid.length || n >= grid[0].length ){
            return 0;
        }

        if(m == grid.length-1 && n == grid[0].length-1){
            return 1;
        }

        if (dp[m][n] != -1){
            return dp[m][n];
        }

        return dp[m][n] = helperuniquePaths(dp,grid,m,n+1) + helperuniquePaths(dp,grid,m+1,n);

    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i=0;i<obstacleGrid.length;i++){
            for (int j =0;j<obstacleGrid[0].length;j++){
                dp[i][j] = -1;
            }
        }


       return helperUniquePathsWithObstacles(dp,obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1);
    }

    public int helperUniquePathsWithObstacles(int[][] dp , int[][] obGrid , int i, int j){

        if (i<0 || j<0){
            return 0;
        }

        if (obGrid[i][j] == 1)
            return 0;

        if (i == 0 && j ==0)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        return  dp[i][j] = helperUniquePathsWithObstacles(dp,obGrid,i-1,j) +  helperUniquePathsWithObstacles(dp,obGrid,i,j-1);



    }

    /*

    -1
     3 2
    -3 1 -1

     2
     3 -4
     6  5 -7
     4 -1  8  3    -> -10

    */


    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i=0;i<triangle.size();i++){
            for (int j =0;j<triangle.size();j++){
                dp[i][j] = -1;
            }
        }


        return helperminimumTotal(triangle,0,0,dp);

    }
    public int helperminimumTotal(List<List<Integer>> triangle,int i, int j,int[][] dp){

        if (i == triangle.size()-1){
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        int down =  helperminimumTotal(triangle,i+1,j,dp);
        int downright =  helperminimumTotal(triangle,i+1,j+1,dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down,downright);

    }
    public int minFallingPathSum(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i =0;i<matrix.length;i++){
            for (int j = 0 ;j<matrix[0].length;j++){

                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0;i<matrix[0].length;i++){
            min = Math.min(helperminFallingPathSum(matrix,0,i,dp),min);
        }

     return min;



    }
    public int helperminFallingPathSum(int[][] matrix,int i, int j,int[][] dp){

        if (i>=matrix.length || j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE;

        if (i==matrix.length-1){
            return matrix[i][j];
        }

        if (dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }

        int down = helperminFallingPathSum(matrix,i+1,j,dp);
        int downleft = helperminFallingPathSum(matrix,i+1,j-1,dp);
        int downright = helperminFallingPathSum(matrix,i+1,j+1,dp);


       int min = Math.min(down,Math.min(down,downright));

        return dp[i][j] =  matrix[i][j] + min;


    }
    public int helperminFallingPathSumT(int[][] matrix){


        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0;i<matrix.length;i++){

            dp[0][i] = matrix[0][i];

        }

        for (int i = 1;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){

               int  down = matrix[i][j] + dp[i-1][j];

               int downleft = matrix[i][j];

                if (j-1 >= 0)downleft += dp[i-1][j-1];
               else downleft = Integer.MAX_VALUE;


                int downright = matrix[i][j];

                if (j+1 < dp[0].length) downright += dp[i-1][j+1];
                else downright = Integer.MAX_VALUE;



               dp[i][j] = Math.min(down,Math.min(downleft,downright));

            }


        }

        int min = Integer.MAX_VALUE;

        for (int i = 0;i<dp[0].length;i++){
            min = Math.min(min,dp[dp.length-1][i]);
        }
   return min;

    }


    public int solve(int n, int m, int grid[][]){

        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

        for (int i =0;i<dp.length;i++){
            for (int j =0;j<dp[0].length;j++){
                for (int k = 0;k<grid[0].length;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }


        return helpersolve(grid,0,0,grid[0].length-1,dp);

    }

    public int helpersolve(int[][] grid,int i ,int j1, int j2 ,int[][][] dp){

        if (j1 < 0 || j1 >= grid[0].length || j2 <0 || j2 >= grid[0].length){
            return (int)-1e8;
        }

        if (i ==  grid.length-1){

            if (j1 == j2){
                return grid[i][j1];
            }else
                return grid[i][j1] + grid[i][j2];

        }

        if (dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }

       int max = 0;

       for (int dj1 = -1; dj1<=1;dj1++){
           for (int dj2 = -1;dj2<=1;dj2++){

          if (j1 == j2)  max = Math.max(grid[i][j1] + helpersolve(grid,i+1,j1+dj1,j2+dj2,dp),max);
          else max = Math.max(grid[i][j1] + grid[i][j2] + helpersolve(grid,i+1,j1+dj1,j2+dj2,dp),max);
           }
       }
       return dp[i][j1][j2] = max;


    }

    static Boolean isSubsetSum(int N, int arr[], int sum){

         DynamicProgramming dynamic = new DynamicProgramming();

         int[][] dp = new int[N+1][sum+1];
         for (int i =0;i<N+1;i++){
             for (int j = 0;j<sum+1;i++)
             dp[i][j] = -1;
         }



        return (dynamic.helperisSubsetSum(arr,sum,N-1,dp)  == 1) ? true : false;




    }

    public int helperisSubsetSum(int[] arr , int target,int i,int[][] dp){

        if (target == 0)
            return 1;
        if (i == 0)
            return (arr[0] == target) ? 1 : 0;

        if (dp[i][target] != -1){
            return dp[i][target];
        }

        int notTake = helperisSubsetSum(arr,target,i-1,dp);
        int  take = 0;

        if (target >= arr[i]){
            take =  helperisSubsetSum(arr,target-arr[i],i-1,dp);
        }

        return dp[i][target] = (notTake == 1 || take == 1) ? 1 : 0;


    }


    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i =0;i<nums.length;i++){
            sum+= nums[i];
        }
        if (sum%2 != 0){
            return false;
        }

        int target = sum/2;

        int [][] dp = new int[nums.length][target+1];

        for (int i=0;i<dp.length;i++){
            for (int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        if (hlepercanPartition(nums,target,nums.length-1,dp) == 1)
            return true;
        else
            return false;

    }

    public int hlepercanPartition(int[] nums,int target, int i,int[][] dp){
        if (target == 0)
            return 1;

        if (i ==0){
           if (nums[0] == target)
               return 1;
           else
               return 0;
        }

        if (dp[i][target] != -1)
            return dp[i][target];

        int nottake = hlepercanPartition(nums,target,i-1,dp);

        int take = 0;
        if (target >= nums[i])
         take = hlepercanPartition(nums,target-nums[i],i-1,dp);


         return dp[i][target] = (nottake == 1 || take == 1) ? 1 : 0;


    }

    public int minimumDifference(int[] nums) {

        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        boolean[][] dp = new boolean[nums.length][total + 1];

        for (int i = 0; i < dp.length; i++) dp[i][0] = true;

        if (total >= nums[0]) dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int taget = 1; taget <= total; taget++) {

                boolean notTake = dp[i - 1][taget];
                boolean take = false;
                if (nums[i] <= taget) take = dp[i - 1][taget - nums[i]];

                dp[i][taget] = notTake || take;


            }
        }

        int mini = Integer.MAX_VALUE;


        for (int s1 = 0; s1 < total / 2; s1++) {

            if (dp[dp.length - 1][s1] == true) {
                mini = Math.min(mini, Math.abs((total - s1) - s1));
            }


        }

        return mini;


    }

    public int perfectSum(int arr[],int n, int sum){

        int mod = 1000000007;

        int[][] dp = new int[n][sum+1];

        for (int i =0;i<dp.length;i++){
            for (int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

   return perfectSumhelper(arr,n-1,sum,dp)%mod;

    }

    public int perfectSumhelper(int[] arr,int i,int sum,int[][] dp ){

        if (sum == 0){
            return 1;
        }

        if (i == 0){
            if (arr[i] == sum){
                return 1;
            }
            else {
                return 0;
            }
        }

        if(dp[i][sum] != -1){
            return dp[i][sum];
        }

        int nottake = perfectSumhelper(arr,i-1,sum,dp);

        int take = 0;
        if (sum >= arr[i]) {
            take = perfectSumhelper(arr,i-1,sum-arr[i],dp);
        }

        return dp[i][sum] = nottake + take;

    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        DynamicProgramming dpset  = new DynamicProgramming();
        int[][] dp = new int[n][W+1];

        for (int i = 0;i<dp.length;i++){
            for (int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }


        return dpset.helperKnapSack(n-1,W,wt,val,dp);

    }


    public int helperKnapSack(int ind,int w,int[] wt, int val[],int[][] dp){

        if (ind == 0){
            if (wt[0] <= w){
                return val[0];
            }
            else {
                return 0;
            }
        }
        if (dp[ind][w] != -1){
            return dp[ind][w];
        }
        int nottake = 0 + helperKnapSack(ind-1,w,wt,val,dp);

        int take = 0;
        if (w >= wt[ind])
        take = val[ind] +  helperKnapSack(ind-1,w-wt[ind],wt,val,dp);


        return dp[ind][w] = Math.max(take,nottake);



    }
    int count = 0;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

    return 1;

    }

    public int helperProfit(int ind,int m,int p,int n,int min,int[] group,int[] profit){

        if (ind == 0) {
            if (group[0] > n){
                return 0;
             }

        }



        int nottake = helperProfit(ind-1,m,p,n,min,group,profit);

        int take =0;

        if (n>=group[ind]){
            take = helperProfit(ind-1,m+group[ind],p+profit[ind],n,min,group,profit);
        }

        return nottake+take;
    }

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];

        for (int i = 0;i<dp.length;i++){
            for (int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }


        return helperC(coins.length-1,amount,coins,dp);

    }
    public int helperC(int ind,int amount,int[] coins,int[][] dp){

        if (ind == 0){
            if(amount%coins[ind] == 0){
                return amount/coins[ind];
            }
            else {
                return (int)1e9;
            }
        }

        if (dp[ind][amount] != -1){
            return dp[ind][amount];
        }


        int nottake = 0 + helperC(ind-1,amount,coins,dp);

        int take = Integer.MAX_VALUE;

        if (amount>=coins[ind])
        take = 1 + helperC(ind,amount-coins[ind],coins,dp);


        return dp[ind][amount] = Math.min(nottake,take);

    }


    public int findTargetSumWays(int[] nums, int target) {

       return helperF(nums.length-1,target,nums);
    }

    public int helperF(int ind,int target,int[] nums){

       if (ind == 0 && target+nums[0] == 0 && target-nums[0]==0)
           return 2;
       if (ind == 0 && (target - nums[0] == 0  || target-nums[0] == 0))
           return 1;
       if (ind==0){
          return 0;
         }

        int neg = helperF(ind-1,target-nums[ind],nums);
        int positive = helperF(ind -1,target+nums[ind],nums);


        return neg+positive;
    }

    public List<List<Integer>> permutation(int[] array){

        int[] hashMap = new int[array.length];
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> temp =  new ArrayList<>();

        formListofPermutation(ans,temp,hashMap,array);

        return ans;

    }

    public void formListofPermutation(List<List<Integer>> ans,List<Integer> temp,int[] hashMap,int[] array){

        if (temp.size() == array.length){
            ans.add(new ArrayList<>(temp));
            return;
        }


        for (int i = 0;i<hashMap.length;i++){
            if (hashMap[i] == 0){
                temp.add(array[i]);
                hashMap[i] = 1;
                formListofPermutation(ans,temp,hashMap,array);
                temp.remove(temp.size()-1);
                hashMap[i] = 0;
            }
        }

    }

    public static int knapSack(int N, int W, int val[], int wt[]){

        int[][] dp = new int[N][W+1];

        for (int i = 0;i<dp.length;i++){
            for (int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

   DynamicProgramming dp1 = new DynamicProgramming();
   return dp1.helpknapSack(N-1,W,val,wt,dp);

    }
   public int helpknapSack(int ind,int W,int[] val,int[] wt,int[][] dp){

        if(ind == 0){
            if (W>wt[0]) {
                return val[0] * (W / wt[0]);
            }else {
                return 0;
            }
        }

        if (dp[ind][W] != -1){
            return dp[ind][W];
        }

        int nottake = 0 + helpknapSack(ind-1,W,val,wt,dp);
        int take = 0;
        if(W>=wt[ind]){
            take = val[ind] + helpknapSack(ind,W-wt[ind],val,wt,dp);
        }

        return dp[ind][W] = Math.max(nottake,take);

   }

    public int cutRod(int price[], int n) {

        int[][] dp = new int[n][n+1];

        for (int i = 0;i<dp.length;i++){
            for (int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        return helpcutRod(n-1,n,price,dp);

    }

    public int helpcutRod(int ind,int n,int[] price,int[][] dp){

        if(ind == 0){
            return price[0] * n;
        }

        if (dp[ind][n] != -1){
            return dp[ind][n];
        }

        int nottake = 0 + helpcutRod(ind-1,n,price,dp);


        int rodlenght = ind+1;
        int take = 0;
        if (rodlenght <= n){
            take = price[ind] + helpcutRod(ind,n-rodlenght,price,dp);
        }

        return dp[ind][n] = Math.max(nottake,take);

    }
    public int longestCommonSubsequence(String text1, String text2) {

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        generateSubseq(0,str1,list1,text1);
        generateSubseq(0,str2,list2,text2);

        int max =Integer.MIN_VALUE;

        for (int i = 0;i<list1.size();i++){
            String test = list1.get(i);

            for (int j =0;j<list2.size();j++){
                if (test.equals(list2.get(j))){
                    max = Math.max(max,list2.get(j).length());
                }

            }
        }
     return max;
    }

    public void generateSubseq(int ind,StringBuilder string,List<String> list,String text){

        if (ind == text.length()){
            list.add(string.toString());
            return;
        }

        string.append(text.charAt(ind));
        generateSubseq(ind+1,string,list,text);
        string.deleteCharAt(string.length()-1);
        generateSubseq(ind+1,string,list,text);


    }
    public int longestCommonSubsequence1(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text1.length()+1];

        for (int i = 0;i<dp.length;i++){
            for (int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return helperlcs(text1,text2,text1.length()-1,text2.length()-1,dp);


    }

    public int helperlcs(String text1,String text2,int i,int j,int[][] dp){

        if ((i < 0 || j < 0)){

            return 0;

        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)){
          return dp[i][j]  =  1 + helperlcs(text1,text2,i-1,j-1,dp);
        }

            return  dp[i][j] = Math.max(helperlcs(text1,text2,i-1,j,dp),helperlcs(text1,text2,i,j-1,dp));
    }

    public int longestCommonSubsequence2(String text1, String text2) {

        int n = text1.length();
        int m =text2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i =0;i<dp.length;i++){
            for (int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        for (int j =0;j<=n;j++){
            dp[0][j] = 0;
        }
        for (int i = 0;i<=m;i++){
            dp[i][0] = 0;
        }

        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=m;j++){

                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else {
                   dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[n][m];

    }

    }




