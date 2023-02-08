public class BubbleSort {
    public static void bubbleSort(int arr[], int n){
        int temp;

            for (int j = 0; j < arr.length; j++)
                for (int k = 1; k < arr.length; k++)
                    if(arr[k-1] > arr[k]) {
                        temp = arr[k];
                        arr[k] = arr[k-1];
                        arr[k-1] = temp;
                    }


    }
}
