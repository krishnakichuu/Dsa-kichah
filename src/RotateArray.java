public class RotateArray {

    public int[] rotateArr(int[] arr, int k) {
        for (int i = 0; i < k; i++)
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[j];
                arr[j] = arr[arr.length-1];
                arr[arr.length-1] = temp;
                }
            return arr;
        }

        void rotateArr2(int[] arr , int k){
        k%= arr.length;

        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k, arr.length-1);

    }
    void reverse(int[] arr , int start , int end ){
        while(start<end){
            int temp = arr[start];
            arr[start] =arr[end];
            arr[end] = temp;
        }
    }
    }

