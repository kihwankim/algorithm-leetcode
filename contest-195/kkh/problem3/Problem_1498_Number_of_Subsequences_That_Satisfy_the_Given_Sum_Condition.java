import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Problem_1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition { // lNumber of Subsequences That Satisfy the Given Sum Condition
    private StringTokenizer stringTokenizer;
    private final BufferedReader bufferedReader;

    public Problem_1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition() {
        this.stringTokenizer = new StringTokenizer("");
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private String nextLine() {
        try {
            return this.bufferedReader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private String next() {
        while (!this.stringTokenizer.hasMoreTokens()) {
            this.stringTokenizer = new StringTokenizer(Objects.requireNonNull(this.nextLine()));
        }
        return this.stringTokenizer.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(this.next());
    }

    private boolean end() {
        try {
            this.bufferedReader.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * ex)
     * start == 0, end == 4
     * 1 : 1개
     * 1,3 : 1개
     * 1,5 : 3 유뮤 : 2개
     * 1,8 : 3, 5 유무 : 4개
     * 1,10 : 3, 5, 8 유무 : 8개
     * 총 : 16개
     */
    public void solve() {
        System.out.println(numSubseq(new int[]{3, 5, 6, 7}, 9));
        if (!this.end()) {
            System.out.println("program error");
        }
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int mod = (int) 1e9 + 7;
        int length = nums.length;
        int[] pows = new int[length + 1];

        pows[0] = 1;
        for (int index = 1; index < pows.length; index++) {
            pows[index] = (2 * pows[index - 1]) % mod;
        }

        int result = 0;
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            if ((nums[start] + nums[end]) <= target) {
                result += pows[end - start];
                result %= mod;
                start += 1;
            } else {
                end -= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Problem_1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition().solve();
    }
}
