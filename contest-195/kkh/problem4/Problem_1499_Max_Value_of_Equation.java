import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Problem_1499_Max_Value_of_Equation { // Max Value of Equation - time out
    private StringTokenizer stringTokenizer;
    private final BufferedReader bufferedReader;

    public Problem_1499_Max_Value_of_Equation() {
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
        System.out.println(findMaxValueOfEquation(new int[][]{{-19, 9}, {-15, -19}, {-5, -8}}, 10));
        if (!this.end()) {
            System.out.println("program error");
        }
    }

    public int findMaxValueOfEquation(int[][] points, int k) {
        int lenght = points.length;
        double result = Double.NaN;

        for (int indexOut = 0; indexOut < lenght - 1; indexOut++) {
            int indexIn = indexOut + 1;
            while (indexIn < lenght) {
                int cal = Math.abs(points[indexOut][0] - points[indexIn][0]);
                if (cal > k) {
                    break;
                }
                int temp = cal + points[indexOut][1] + points[indexIn][1];
                if (Double.isNaN(result)) result = temp;
                else result = Math.max(result, temp);
                indexIn++;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        new Problem_1499_Max_Value_of_Equation().solve();
    }
}
