public class LimitedRangeArray {
    public static void frequencyCount(int arr[], int N, int P) {
        for(int i =1 ; i<=N ; i++){
            int count =0;
            for(int j =0 ; j<arr.length;j++){
                if(i==arr[j])
                    count++;
            }
            System.out.print(count+" ");
        }

    }
}
