import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DailyChallenge {


    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int i=0;i<nums.length;i++){
            List<Integer> l = new ArrayList<>();
            for (int j = i;j<nums.length;j++){
                if (l.size()==0){
                    l.add(nums[j]);
                }else{
                    l.add(nums[j]);
                    for (int k = 0;k<l.size()-1;k++){
                        if (l.get(k) > l.get(k+1)){
                            l.remove(k+1);
                        }
                    }



                }
                List<Integer> temp = new ArrayList<>();
                for (var Tl : l){
                    temp.add(Tl);
                }
                if (l.size()>1){
                    ans.add(temp);

                }
            }
        }


      return ans;
    }
}
