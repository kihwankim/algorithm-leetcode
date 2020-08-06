import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution { // 1514. Path with Maximum Probability
    public static void main(String[] args) {
        System.out.println(maxProbability(3,
                new int[][]{{0, 1}}, new double[]{0.5}, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Edge>> edgesList = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            edgesList.add(new LinkedList<>());
        }

        int indexSucc = 0;

        for (int[] edge : edges) {
            edgesList.get(edge[0]).add(new Edge(edge[1], succProb[indexSucc]));
            edgesList.get(edge[1]).add(new Edge(edge[0], succProb[indexSucc]));
            indexSucc += 1;
        }

        boolean[] isVisited = new boolean[n];
        return dfs(edgesList, isVisited, start, end);
    }

    private static double dfs(List<List<Edge>> edges, boolean[] isVisited, int now, int end) {
        List<Edge> edgeList = edges.get(now);
        isVisited[now] = true;
        double result = 0;
        for (Edge edge : edgeList) {
            if (!isVisited[edge.vertex]) {
                if (edge.vertex == end) {
                    return Math.max(result, edge.weight);
                }
                double dfsResult = edge.weight * dfs(edges, isVisited, edge.vertex, end);
                result = Math.max(result, dfsResult);
            }
        }
        isVisited[now] = false;

        return result;
    }
}

class Edge {
    int vertex;
    double weight;

    public Edge(int vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}