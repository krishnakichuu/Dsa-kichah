import java.util.Arrays;

public class MostFrequentElement {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int left =0,right =0;
        int result =0,total =0;
        while(right < nums.length){
             total += nums[right];
            while(nums[right] * (right-left+1) > total+k){

              total -= nums[left];
              left+=1;
            }
            result = Math.max(result,right-left+1);
            right+=1;
        }

       return result ;
    }
}
