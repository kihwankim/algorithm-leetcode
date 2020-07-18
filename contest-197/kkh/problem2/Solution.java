class Solution {
    public int numSub(String s) { // 1513. Number of Substrings With Only 1s
        int mod = (int) 1e9 + 7;
        char[] array = s.toCharArray();
        int count = 0;
        int length = 0;
        for (int index = 0; index < s.length(); index++) {
            if (array[index] == '1') {
                length += 1;
                count += length;
                count %= mod;
            } else {
                length = 0;
            }
        }

        return count;
    }
}