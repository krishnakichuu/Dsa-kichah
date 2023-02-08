public class CountSortTheArray {
   /*[1,2,3,2,3,4,5]


    */

    public void countSort(int[] arr){
        for(int i = 0; i<arr.length; i++){
            int count = 0;
            for (int j = i; j<arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }

            }

            System.out.println(arr[i] + " = " + count);
        }
    }
}
