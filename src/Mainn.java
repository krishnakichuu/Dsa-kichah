import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mainn {


    public static void main(String args[]){

     //[[2],[3,4],[6,5,7],[4,1,8,3]]


        DynamicProgramming dp = new DynamicProgramming();
        /*
        N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
         */





        /*
        [0,4,6,0,3,2,6,9,4,1]
3
         */

        String str1= "abghi";
        String str2 = "aebjguhdi";

        System.out.println((dp.longestCommonSubsequence(str1,str2)));



    }


}

class Disjoint{

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

   public Disjoint(int n){
       for (int i = 0;i<=n;i++){
           rank.add(0);
           parent.add(i);
       }
   }

   public int findUPair(int node){
       if (node == parent.get(node)){
           return node;
       }

       int ulp = findUPair(parent.get(node));
       parent.set(node,ulp);
       return parent.get(node);

   }

  public void unionByRank(int u,int v){

       int ulpU = findUPair(u);
       int ulpV = findUPair(v);

       if (ulpU == ulpV ) return;

       if (rank.get(ulpU) < rank.get(ulpV)){
           parent.set(ulpU,ulpV);
       }
       else if (rank.get(ulpV) < rank.get(ulpU)){
           parent.set(ulpV,ulpU);
       }
       else {
           parent.set(ulpV,ulpU);
           int incre = rank.get(ulpU);
           rank.set(ulpU,incre+1);
       }

  }



}
