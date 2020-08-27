import java.util.Arrays;

class Solution { // 1561. Maximum Number of Coins You Can Get
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int minIndex = 0;
        int sum = 0;
        int middleIndex = piles.length - 2;
        while (middleIndex > minIndex) {
            sum += piles[middleIndex];
            middleIndex -= 2;
            minIndex += 1;
        }

        return sum;
    }
}