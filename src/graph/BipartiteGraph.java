package graph;

public class BipartiteGraph {
    public static void main(String[] args) {
        //множество
        String[] v = new String[] {"A", "B", "C", "D", "E", "F", "G"};
        String[][] e = new String[][] {{"A", "D"}, {"A", "E"}, {"B", "F"}, {"C", "F"}, {"C", "G"}};


        //матрица смежности
        int[][] AdjacencyMatrix = new int[][] {
                     //A B C D E F G
                /*A*/ {0,0,0,1,1,0,0},
                /*B*/ {0,0,0,0,0,1,0},
                /*C*/ {0,0,0,0,0,1,1},
                /*D*/ {1,0,0,0,0,0,0},
                /*E*/ {1,0,0,0,0,0,0},
                /*F*/ {0,1,1,0,0,0,0},
                /*G*/ {0,0,1,0,0,0,0}
        };

        //матрица инциндентности
        int[][] IncidenceMatrix = new int[][] {
                    //1 2 3 4 5
                /*A*/{1,1,0,0,0},
                /*B*/{0,0,1,0,0},
                /*C*/{0,0,0,1,1},
                /*D*/{1,0,0,0,0},
                /*E*/{0,1,0,0,0},
                /*F*/{0,0,1,1,0},
                /*G*/{0,0,0,0,1}
        };

    }
}
