class Solution { // 1512. Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int index = 0; index < nums.length - 1; index++){
            for(int inner = index + 1; inner < nums.length; inner++){
                if(nums[index] == nums[inner]){
                    count += 1;
                }                
            }
        }
        return count;
    }
}