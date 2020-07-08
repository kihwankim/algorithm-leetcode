package contest_195;

public class problem_01 {
    public static boolean isPathCrossing(String path) {
    	boolean result = false;
    	int row = 0;
    	int col = 0;
    	char c;
    	int[] x = new int[path.length()+1];
    	int[] y = new int[path.length()+1];
    	
    	x[0] = 0;
    	y[0] = 0;
    	
    	for(int i = 0; i<path.length(); i++) {
    		c = path.charAt(i);
    		
    		if(c == 'N') {
    			col++;
    		}
    		
    		if(c == 'S') {
    			col--;
    		}    		
    		
    		if(c == 'E') {
    			row++;
    		}    		
    		
    		if(c == 'W') {
    			row--;
    		}
    		
    		x[i+1] = row;
    		y[i+1] = col;
    	}
    	
    	for(int i = 0; i<x.length; i++) {
    		for(int j = i+1; j<x.length; j++) {
    			if(x[i] == x[j] && y[i] == y[j]) {
    				result = true;
    				break;
    			}
    		}
    	}
    	
		return result;
    }
    
    public static void main(String args[]) {
    	String path = "NES";
    	
    	System.out.println(isPathCrossing(path));
    }
}
