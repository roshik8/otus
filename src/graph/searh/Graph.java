package graph.searh;

import java.util.*;

public class Graph {
    private final int size;
    private final int[][] matrix;

    private final VertexState[] vertex;
    Deque<Edge> edges;

    private final List<Integer> path;

    public Graph(int[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
        vertex = new VertexState[size];
        path = new ArrayList<>();
        edges = new ArrayDeque<>();
    }

    public boolean dfs(int begin, int end) {
        if (begin <= 0 || end <= 0) return false;
        clear();
        begin = begin - 1;
        end = end - 1;
        boolean result = dfsRec(begin, end);
        if (!result) return false;
        setPath(end);
        return true;
    }

    public boolean bfs(int begin, int end) {
        if (begin <= 0 || end <= 0) return false;
        begin = begin - 1;
        end = end - 1;
        clear();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(begin);
        boolean found = false;
        while (queue.size() > 0) {
            int z = queue.poll();
            vertex[z] = VertexState.processed;
            for (int i = 0; i < size; i++) {
                if (matrix[z][i] == 0) continue;
                if (vertex[i] != VertexState.none) continue;
                Edge edge = new Edge(z, i);
                edges.push(edge);
                if (i == end) {
                    found = true;
                    break;
                }
                queue.add(i);
                vertex[i] = VertexState.found;
            }

            if (found) break;

        }
        if (found) {
            setPath(end);
            return true;
        }
        return false;
    }

    private boolean dfsRec(int begin, int end) {
        vertex[begin] = VertexState.found;
        if (begin == end) return true;
        for (int i = 0; i < size; i++) {
            if (vertex[i] == VertexState.found) continue;
            if (matrix[begin][i] == 0) continue;
            Edge edge = new Edge(begin, i);
            edges.push(edge);
            if (dfsRec(i, end)) return true;
        }
        return false;

    }

    public List<Integer> getPath() {
        return path;
    }

    private void setPath(int goal) {
        path.clear();
        if (edges.size() == 0) return;
        path.add(goal + 1);
        for (Edge edge : edges) {
            if (edge.end != goal) {
                continue;
            }
            goal = edge.begin;
            path.add(goal + 1);
        }
        Collections.reverse(path);
    }

    private void clear() {
        for (int i = 0; i < size; i++) {
            vertex[i] = VertexState.none;
        }
        edges.clear();
    }

    enum VertexState {
        none,
        found,
        processed
    }

    static class Edge {
        private final int begin;
        private final int end;

        public Edge(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
