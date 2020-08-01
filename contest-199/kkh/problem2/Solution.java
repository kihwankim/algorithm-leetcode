class Solution {
    public int minFlips(String target) { // 1529. Bulb Switcher IV
        char[] data = target.toCharArray();
        int before = 0;
        int count = 0;
        for (char input : data) {
            int now;
            if (input == '0') {
                now = 0;
            } else {
                now = 1;
            }
            if (before != now) {
                count += 1;
                before = now;
            }
        }
        return count;
    }
}