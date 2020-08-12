package contest_201;

public class problem_02 {
	
	public static StringBuilder invertAndReverse(StringBuilder s) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i) == '0') {
				result.append("1");
			}
			else
				result.append("0");
		}
		
		s.append("1");
		s.append(result.reverse());
		
		return s;
	}
	
	public static char findKthBit(int n, int k) {    
		StringBuilder result = new StringBuilder("0");
		
        for(int i = 1; i<n; i++) {
        	
        	if(result.length()>k) {
        		break;
        	}

        	result = invertAndReverse(result);
        }
                
        return result.charAt(k-1);
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		
		int n = 2;
		int k = 3;
		
		System.out.println(findKthBit(n, k));
		
	}

}
