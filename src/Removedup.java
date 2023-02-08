public class Removedup {

    public int removeDuplicate(int[] nums){
        int unique = nums.length;
        int i =0;
        for(int j =1; j<nums.length; j++)
            if (nums[i] != nums[j])
                i=+j;
             else {
                i++;
                unique--;
            }

        return unique;
    }


}
