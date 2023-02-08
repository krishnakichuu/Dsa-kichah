import java.util.Arrays;

public class oddeven {

    public int[] addeven(int[] arr) {
        int o =0;
        int v = 0;

        int mid = arr.length / 2;

        int[] odd = new int[arr.length - mid];
        int[] even = new int[mid];

        for (int i = 0; i < arr.length; i++)
            if(i%2==0)
            odd[o++] = arr[i];
        else
            even[v++] =arr[i];


        Arrays.sort(odd);

        for (int i = 0; i < even.length; i++) {
            for (int j = i+1; j < even.length; j++) {
                if (even[i] < even[j]) {
                    int temp = even[j];
                    even[j] = even[i];
                    even[i] = temp;
                }
            }
        }
             int k =0,i=0,j=0;
        for( i = 0,j=0 ;i<odd.length&&j<even.length;i++,j++) {
            arr[k++] = odd[i];
            arr[k++] = even[j];
        }
        return arr;
    }
}
