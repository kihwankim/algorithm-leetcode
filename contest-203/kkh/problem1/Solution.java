import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution { // 1560. Most Visited Sector in a Circular Track

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new LinkedList<>();
        Point[] data = new Point[n + 1];

        int before = rounds[0];
        for (int index = 0; index <= n; index++) {
            data[index] = new Point(index, 0);
        }

        for (int index = 1; index < rounds.length; index++) {
            int next = rounds[index];
            while (before != next) {
                ++data[before].count;
                before = (before + 1) % (n + 1);
            }
        }
        ++data[before].count;

        Arrays.sort(data, (a, b) -> -a.count + b.count);
        int max = data[0].count;
        for (Point input : data) {
            if (input.count == max && input.index != 0) {
                list.add(input.index);
            }
        }
        Collections.sort(list);
        return list;
    }
}

class Point {
    int index;
    int count;

    public Point(int index, int count) {
        this.index = index;
        this.count = count;
    }
}