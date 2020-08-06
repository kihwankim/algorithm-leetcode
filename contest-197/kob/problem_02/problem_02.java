package contest_197;

import java.math.BigInteger;

public class problem_02 {
   
	public static int numSub(String s) {
        BigInteger result = BigInteger.ZERO;
        BigInteger x, y, xMuly, quot, temp;
        
        
        BigInteger mod = BigInteger.valueOf((int)1e9+7);
        
        
        String[] subS = s.split("0");
        
        for(int i = 0; i<subS.length; i++) {
        	if(subS[i].length() != 0) {
        		x = BigInteger.valueOf(subS[i].length()+1);
        		y = BigInteger.valueOf(subS[i].length());
        		
        		xMuly = x.multiply(y);
        		
        		quot = BigInteger.valueOf(2);
        		
        		temp = xMuly.divide(quot);
        		
        		result = result.add(temp);
        	}
        }
        
        result = result.mod(mod);
        
        return result.intValue();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1010000101111000011101110110";
		
		System.out.println(numSub(s));
	}

}
