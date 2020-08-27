class Solution { // 1551. Minimum Operations to Make Array Equal
    public int minOperations(int n) {
        int mid = n / 2;
        int result = mid * mid;
        if (n % 2 == 0) {
            return result;
        } else {
            return result + mid;
        }
    }
}