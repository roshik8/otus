package graph.ostov;

import java.util.*;

public class Graph {
    private final int size;
    private final int[][] matrix;

    Deque<Edge> edges;
    private int weightMin = 0;
    int[] parents;

    public Graph(int[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
        edges = new ArrayDeque<>();
    }

    public int getParent(int v) {
        if (parents[v] == v) return v;
        return getParent(parents[v]);
    }

    public void kruskal() {
        weightMin = 0;
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (matrix[i][j] == 0) continue;
                Edge edge = new Edge(i, j, matrix[i][j]);
                edgeList.add(edge);
            }
        }
        edgeList.sort(Comparator.comparingInt(o -> o.weight));

        parents = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
        }
        for (Graph.Edge edge : edgeList) {
            int begin = getParent(edge.begin);
            int end = getParent(edge.end);
            if (begin == end) continue;
            edges.add(edge);
            weightMin += edge.weight;
            parents[end] = begin;
        }
    }

    public int[] deikstra(int vertex) {
        int[] ways = new int[size];
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            ways[i] = Integer.MAX_VALUE;
        }
        ways[vertex] = 0;
        int min;
        for (int i = 0; i < size; i++) {
            min = getMin(ways, visited);
            visited[min] = true;
            for (int j = 0; j < size; j++) {
                if (visited[j]) continue;
                if (matrix[min][j] == 0) continue;
                int weight = ways[min] + matrix[min][j];
                if (weight < ways[j]) {
                    ways[j] = weight;
                }
            }

        }
        return ways;

    }

    public Deque<Edge> getEdges() {
        return edges;
    }

    public int getWeightMin() {
        return weightMin;
    }

    private int getMin(int[] mas, boolean[] visited) {
        int min = -1;
        for (int i = 0; i < mas.length; i++) {
            if (visited[i]) continue;
            if (min == -1) {
                min = i;
            } else if (mas[i] < mas[min]) {
                min = i;
            }
        }
        return min;
    }

    static class Edge {
        private final int begin;
        private final int end;
        private final int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        public int getBegin() {
            return begin;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }
}
