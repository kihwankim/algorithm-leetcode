package contest_199;

public class problem_01 {
    public static String restoreString(String s, int[] indices) {
        String result = "";
        
        char[] c = s.toCharArray();
        
        for(int i = 0; i<indices.length; i++) {
        	for(int j = 0; j<indices.length; j++) {
        		if(i == indices[j]) {
        			result += c[j];
        		}
        	}
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	
    	String s = "aiohn";
    	int[] indices = {3,1,4,2,0};
    	
    	System.out.println(restoreString(s, indices));
    	
    }
}
