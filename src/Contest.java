import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

}
