public class SecondLarge {
    public int Largeelement(int[] arr){
        int maxIndex = 0;
        for(int i = 1 ; i<arr.length; i++){
            if(arr[i-1] < arr[i])
                maxIndex = i;
        }
        int max = arr[maxIndex];
        int secondsmall = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>secondsmall && arr[i] != max)
                secondsmall=arr[i];
        }
          return secondsmall;
    }
}
