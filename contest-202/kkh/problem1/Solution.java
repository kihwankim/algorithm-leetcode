class Solution { // 1550. Three Consecutive Odds
    public boolean threeConsecutiveOdds(int[] arr) {
        int sub = 0;
        for (int data : arr) {
            if (data % 2 == 1) {
                sub += 1;
                if (sub == 3) {
                    return true;
                }

            } else {
                sub = 0;
            }
        }
        return false;
    }
}