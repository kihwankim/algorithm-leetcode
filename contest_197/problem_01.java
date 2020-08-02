package contest_197;

public class problem_01 {

	public static int numIdenticalPairs(int[] nums) {
		int result = 0;
		
		for(int i = 0; i<nums.length; i++) {
			for(int j = i+1; j<nums.length; j++) {
				if(nums[i] == nums[j]) {
					result += 1;
				}
			}
		}
			
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1, 1, 1, 1};
		
		System.out.println(numIdenticalPairs(nums));
	}

}
