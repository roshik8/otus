package graph.ostov;

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

    }
}
