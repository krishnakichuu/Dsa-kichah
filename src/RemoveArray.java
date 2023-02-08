public class RemoveArray {
    public int removeduplicate(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int i =0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j])
                arr[++i] = arr[j];
        }
        return (i+1);
    }


}

