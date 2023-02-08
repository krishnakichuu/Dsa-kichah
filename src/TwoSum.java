import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twosum(int[] nums,int target){
        int[] newArray = new int[2];
      Map<Integer,Integer> map = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i]+nums[i-1]!=target))
                continue;
            map.put(i,nums[i]);
            map.put(i-1,nums[i-1]);

            newArray[1] =map.get(nums[i]);
        }

       return newArray;
    }
}
