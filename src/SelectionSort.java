public class SelectionSort {
    public int selectMinValue(int[] arr,int n){
        int minIndex = n ;
        for (int i = n; i < arr.length; i++) {
            if(arr[i]<arr[minIndex])
                minIndex = i;
        }
        return minIndex;
    }

    public int[] selectionSort(int[] arr , int n){
        for (int i = 0; i < n; i++) {
           int minIndex = selectMinValue(arr,i);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
