package contest_200;

public class problem_02 {
    
	public static int getWinner(int[] arr, int k) {        
        int target = 0;
        int opponent = 1;
        int score = k;
        
		if(arr.length < k) {
            int max = arr[0];
			for(int i = 1; i < arr.length; i++) {
				if(max < arr[i])
					max = arr[i];
			}
			return max;
		}
		else {
			while (score != 0) {
				if (opponent >= arr.length) {
					opponent = 0;
				}

				if (arr[target] > arr[opponent]) {
					score -= 1;
					opponent++;
				} else {
					score = k;
					score -= 1;
					target = opponent;
					opponent++;
				}
			}
	        return arr[target];
		}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 1, 3, 5, 4, 6, 7};
		int k = 2;
		
		System.out.println(getWinner(arr, k));
	}

}
