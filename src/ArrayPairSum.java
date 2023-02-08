public class ArrayPairSum {
    public int arrayPair(int[] array){
        int ans =0;
        int max = 0;
        for (var arr:array){
            if(arr>max)
                max = arr;
        }

        int[] count = new int[max+1];
        for(var arr1 : array)
            count[arr1]++;
           int k =0;

        for (int i = 0; i< count.length ; i++)
            for (int j = 0; j < count[i] ;j++)
                    array[k++] = i;

        for (int i = 0; i < array.length; i+=2) {
            ans+=array[i];
        }

            return ans;
    }
}
