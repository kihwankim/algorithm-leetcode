package contest_201;

public class problem_03 {

    public static int maxNonOverlapping(int[] nums, int target) {
        int result = 0;
        int prefixSum = 0;
        int preI = nums.length+1, preJ = -1;
        
        for(int i = 0; i<nums.length;i++) {
        	
        	prefixSum = nums[i];
        	
        	if(nums[i] == target) {
        		result++;
    			preI = i;
    			preJ = i;
        	}
        	        	        	
        	for(int j = i+1; j<nums.length; j++) {
        		prefixSum += nums[j];	
        		
        		if(prefixSum == target) {
        			result++;
        			//걸러내는걸 잘못 생각한듯함
        			if(preJ == i || (preI == i && preJ < j) || (i>preI && j<preJ)) {
        				result--;
        				continue;
        			}
        			
        			preI = i;
        			preJ = j;
        		}
        		
        		
        	}        	
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, 3, 5, 1, 4, 2, -9};
		int target = 6;
		System.out.println(maxNonOverlapping(nums, target));
	}

}
