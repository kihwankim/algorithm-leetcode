import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_1496_PathCrossing { // leetCode problem 1471 The K Strongest value in an Array
    private StringTokenizer stringTokenizer;
    private final BufferedReader bufferedReader;

    public Problem_1496_PathCrossing() {
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
        System.out.println(this.isPathCrossing("NESWW"));
        if (!this.end()) {
            System.out.println("program error");
        }
    }

    public boolean isPathCrossing(String path) {
        int[] now = new int[]{0, 0};
        Set<Point> set = new HashSet<>();
        set.add(new Point(0, 0));

        int[][] direction = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        char[] charPath = path.toCharArray();
        for (char directionChar : charPath) {
            int directionIndex = this.chooseDirection(directionChar);
            now[0] += direction[directionIndex][0];
            now[1] += direction[directionIndex][1];

            if (!set.add(new Point(now[0], now[1]))) {
                return true;
            }
        }

        return false;
    }

    private int chooseDirection(char direction) {
        switch (direction) {
            case 'N':
                return 0;
            case 'S':
                return 1;
            case 'E':
                return 2;
            default:
                return 3;
        }
    }

    public static void main(String[] args) {
        new Problem_1496_PathCrossing().solve();
    }
}
