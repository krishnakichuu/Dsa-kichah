public class quikeSort {
    public void sort(int arr[],int low , int high){
        if(low>=high) {
            return;
        }
        int s = low;
        int e = high;
        int m = (s+e)/2;
        int pivot = arr[m];

        while(s<=e){
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }
            if (s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        sort(arr,low,e);
        sort(arr,s,high);
    }


}
