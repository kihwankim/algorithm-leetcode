import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution { // 1535. Find the Winner of an Array Game
    public int getWinner(int[] arr, int k) {
        if (k > arr.length) {
            Arrays.sort(arr);
            return arr[arr.length - 1];
        }
        List<Integer> list = new LinkedList<>();
        for (int data : arr) {
            list.add(data);
        }

        int winCount = 0;

        do {
            int fD = list.get(0);
            int sD = list.get(1);
            int temp;
            if (fD > sD) {
                winCount += 1;
                temp = list.remove(1);
            } else {
                winCount = 1;
                temp = list.remove(0);
            }
            list.add(temp);
            if (winCount >= k) {
                return list.get(0);
            }
        } while (true);
    }
}