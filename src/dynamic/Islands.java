package dynamic;

import java.util.Scanner;

public class Islands {
    private static int n;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int i, j;
        n = console.nextInt();
        map = new int[n][n];
        console = new Scanner(System.in);
        for (i = 0; i < n; i++) {
            String[] line = console.nextLine().trim().split(" ");
            for (j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        int islands = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    islands++;
                    walk(i, j);
                }
            }
        }
        System.out.println(islands);
    }

    private static void walk(int x, int y) {
        if (x < 0 || x >= n) return;
        if (y < 0 || y >= n) return;
        if (map[x][y] == 0) return;
        map[x][y] = 0;
        walk(x - 1, y);
        walk(x + 1, y);
        walk(x, y - 1);
        walk(x, y + 1);

    }
}
