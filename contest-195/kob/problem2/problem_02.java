package contest_195;

public class problem_02 {
	
    public static boolean canArrange(int[] arr, int k) {
		boolean result = true;
		
		int[] freq = new int[k];
		
		for(int i = 0; i<freq.length; i++) {
			freq[i] = 0;
		}
    	
		for(int i = 0; i<arr.length; i++) {
			freq[((arr[i] % k) + k) % k]++;
		}
		
		for(int i = 1; i<k; i++) {
			
			if(freq[0]%2 != 0) {
				result = false;
				break;				
			}
			
			if(k == 2 && freq[1]%2 != 0) {
				result = false;
				break;				
			}
			
			if(freq[i] != freq[k-i]) {
				result = false;
				break;
			}

		}
    	
    	return result; 
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,1,-2,2,-3,3,-4,4};
		int k = 3;
		
		System.out.println(canArrange(arr, k));
	}

}
