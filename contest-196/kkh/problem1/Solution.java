import java.util.*;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int gap = -1;
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            int nowGap = arr[i] - arr[prev];
            if (gap != -1 && nowGap != gap) {
                return false;
            }
            gap = nowGap;

            prev += 1;
        }

        return true;
    }
}