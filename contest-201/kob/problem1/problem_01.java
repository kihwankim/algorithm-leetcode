package contest_201;

public class problem_01 {

    public static String makeGood(String s) {        
        StringBuilder result = new StringBuilder(s);
    	
        if(s.length() == 1)
        	return s;
        
        for(int i = 0; i<result.length()-1; i++) {
        	if(Math.abs(result.charAt(i)-result.charAt(i+1)) == 32) {
        		result.delete(i, i+2);
        		i = -1;
        	}
        }                        
        return result.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String s = "leEeetcode";
		
		System.out.println(makeGood(s));
	}

}
