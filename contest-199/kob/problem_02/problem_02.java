package contest_199;

public class problem_02 {
	
    public static int minFlips(String target) {
    	int result = 0;
    	
    	char checker = '1';
    	char[] targetArray = target.toCharArray();
    	
    	for(int i = 0; i<targetArray.length; i++) {
    		if(targetArray[i] == checker) {
    			result += 1;
    			if(checker == '0')
    				checker = '1';
    			else
    				checker = '0';
    		}
    	}
    	
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String target = "001011101";
		
		System.out.println(minFlips(target));
	}

}
