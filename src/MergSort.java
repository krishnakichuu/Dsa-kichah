public class MergSort {
    public  void mergeSort(int[] arr) {

        if(arr.length<2)
            return;

        var mid = arr.length/2;

        int[] left = new int[mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        int[] right = new int[arr.length-mid];
        for (int i = mid; i < arr.length; i++)
            right[i-mid] = arr[i];


        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }

    private void merge(int[] left , int[] right , int[] arr){
        int i = 0;
        int j =0;
        int k =0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while(i<left.length)
            arr[k++] = left[i++];

        while(j<right.length)
            arr[k++] = right[j++];

    }
    }