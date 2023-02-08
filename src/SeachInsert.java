public class SeachInsert {


    public int searchInsert(int[] nums, int target) {
     return  binarySeach(nums,target,0,nums.length-1);
    }
    public int binarySeach(int[] nums,int target, int left, int right){
        if (left>right){
            return left;
        }
        int mid = left + (right-left) / 2;
        if(nums[mid] == target)
            return mid;
        else if (target<nums[mid])
            return binarySeach(nums,target,left,mid-1);
        else
            return binarySeach(nums,target,mid+1,right);

    }
}
