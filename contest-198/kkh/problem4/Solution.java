import java.util.ArrayList;
import java.util.List;

class Solution { // 1521. Find a Value of a Mysterious Function Closest to Target
    public int closestToTarget(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        int length = arr.length;
        for (int index = 0; index < length; ++index) {
            if (index == 0) {
                list.add(arr[index]);
            } else if (list.get(list.size() - 1) != arr[index]) {
                list.add(arr[index]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int indexOfLeft = 0; indexOfLeft < list.size(); ++indexOfLeft) {
            int now = list.get(indexOfLeft);
            for (int indexOfRight = indexOfLeft; indexOfRight < list.size(); ++indexOfRight) {
                now &= list.get(indexOfRight);
                result = Math.min(Math.abs(now - target), result);
                if (now <= target) {
                    break;
                }
            }
        }

        return result;
    }
}