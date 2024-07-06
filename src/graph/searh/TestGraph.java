package graph.searh;

public class TestGraph {
    public static void main(String[] args) {
        //матрица смежности
        int[][] adjacencyMatrix = new int[][] {
                      //1 2 3 4 5 6 7 8 9 10
                /*1*/  {0,0,0,1,0,0,0,0,0,1},
                /*2*/  {0,0,0,0,0,0,0,0,0,0},
                /*3*/  {0,0,0,0,0,0,0,0,0,0},
                /*4*/  {0,0,0,0,1,0,0,0,0,0},
                /*5*/  {0,0,1,0,0,1,0,0,0,0},
                /*6*/  {0,0,0,0,0,0,1,0,1,0},
                /*7*/  {0,1,0,0,0,0,0,0,0,0},
                /*8*/  {0,0,0,0,0,0,0,0,0,0},
                /*9*/  {0,0,0,0,0,0,0,1,0,1},
                /*10*/ {0,0,0,0,0,0,0,0,0,0}
        };
        Graph graph = new Graph(adjacencyMatrix);
        if(graph.dfs(1,10)) {
            System.out.println("Путь: " + graph.getPath());
        } else {
            System.out.println("Пути нет");
        }

        if(graph.bfs(1,10)) {
            System.out.println("Кратчайший путь: " + graph.getPath());
        } else {
            System.out.println("Пути нет");
        }

    }
}
