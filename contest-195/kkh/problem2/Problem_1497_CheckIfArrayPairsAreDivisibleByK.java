import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_1497_CheckIfArrayPairsAreDivisibleByK { // leetCode problem 1471 The K Strongest value in an Array
    private StringTokenizer stringTokenizer;
    private final BufferedReader bufferedReader;

    public Problem_1497_CheckIfArrayPairsAreDivisibleByK() {
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

    public void solve() {

        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        if (!this.end()) {
            System.out.println("program error");
        }
    }

    public boolean canArrange(int[] arr, int k) {
        int[] rest = new int[k];
        for (int rawData : arr) {
            int restData = rawData % k;
            if (restData < 0) {
                restData += k;
            }
            rest[restData] += 1;
        }
        if (rest[0] % 2 == 1) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (rest[i] != rest[k - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Problem_1497_CheckIfArrayPairsAreDivisibleByK().solve();
    }
}
