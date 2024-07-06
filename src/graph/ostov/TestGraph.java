package graph.ostov;

import java.util.Arrays;

public class TestGraph {
    public static void main(String[] args) {
        //матрица смежности
        int[][] adjacencyMatrix = new int[][] {
                      //1 2 3 4 5 6 7
                /*1*/  {0,2,2,0,1,0,3},
                /*2*/  {2,0,3,3,0,0,0},
                /*3*/  {2,3,0,0,0,0,0},
                /*4*/  {0,3,0,0,2,0,0},
                /*5*/  {1,0,0,2,0,4,0},
                /*6*/  {0,0,0,0,4,0,2},
                /*7*/  {3,0,0,0,0,2,0}
        };
        Graph graph = new Graph(adjacencyMatrix);
        graph.kruskal();
        System.out.println("Минимальное остовное дерево: ");
        for(Graph.Edge edge: graph.getEdges()) {
            System.out.println((edge.getBegin()+1) + "-" + (edge.getEnd()+1) + ": " + edge.getWeight());
        }
        System.out.println("Сумма весов: " + graph.getWeightMin());


        //матрица смежности
        int[][] dMatrix = new int[][] {
                      //1 2 3 4 5 6
                /*1*/  {0,7,9,0,0,14},
                /*2*/  {7,0,10,15,0,0},
                /*3*/  {9,10,0,11,0,2},
                /*4*/  {0,15,11,0,6,0},
                /*5*/  {0,0,0,6,0,9},
                /*6*/  {14,0,2,0,9,0}
        };
        Graph graph2 = new Graph(dMatrix);
        for (int i =0; i < dMatrix.length;i++ ) {
            int[] ways = graph2.deikstra(i);
            System.out.println("Минимальные пути из вершины " + (i + 1) + ": " +Arrays.toString(ways));

        }

    }
}
