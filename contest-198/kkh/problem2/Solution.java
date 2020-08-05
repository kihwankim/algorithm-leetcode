import java.util.*;

class Solution { //1519. Number of Nodes in the Sub-Tree With the Same Label
    public static void main(String[] args) {
        int[][] data = new int[][]{{0, 2}, {0, 3}, {1, 2}};
        System.out.println(Arrays.toString(new Solution().countSubTrees(4, data, "aeed")));
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> mapList = new ArrayList<>();
        int[] result = new int[n];
        for (int index = 0; index < n; index++) {
            mapList.add(new LinkedList<>());
        }

        for (int[] edge : edges) {
            mapList.get(edge[0]).add(edge[1]);
            mapList.get(edge[1]).add(edge[0]);
        }
        this.arr(result, labels, 0, -1, mapList);

        return result;
    }

    private int[] arr(int[] result, String labels, int now, int before, List<List<Integer>> edges) {
        int[] count = new int[26];
        List<Integer> parentList = edges.get(now);
        for (int child : parentList) {
            if (child == before) {
                continue;
            }
            int[] childCount = this.arr(result, labels, child, now, edges);
            for (int index = 0; index < count.length; ++index) {
                count[index] += childCount[index];
            }
        }

        count[labels.charAt(now) - 'a'] += 1;
        result[now] = count[labels.charAt(now) - 'a'];

        return count;
    }
}