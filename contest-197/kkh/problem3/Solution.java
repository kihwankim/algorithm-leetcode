import java.util.*;

class Edge { // head vertex
    final int vertex;
    final double weight; // weight

    public Edge(int vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

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
        Queue<Edge> pq = new PriorityQueue<>((firsNode, secondNode) -> -Double.compare(firsNode.weight, secondNode.weight));
        pq.add(new Edge(start, 1.0));
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Edge nowEdge = pq.poll();
            if (!visited[nowEdge.vertex]) {
                if (nowEdge.vertex == end) {
                    return nowEdge.weight;
                }
                visited[nowEdge.vertex] = true;
                List<Edge> nextEdges = edgesList.get(nowEdge.vertex);
                for (Edge tempEdge : nextEdges) {
                    pq.add(new Edge(tempEdge.vertex, nowEdge.weight * tempEdge.weight));
                }
            }
        }
        return 0.0;
    }
}