package dynamic;

import java.util.Scanner;

public class Herringbone {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int i, j;
        int n = console.nextInt();
        int[][] herringArray = new int[n][n];
        console = new Scanner(System.in);
        for (i = 0; i < n; i++) {
            String[] line = console.nextLine().trim().split(" ");
            for (j = 0; j <= i; j++) {
                herringArray[i][j] = Integer.parseInt(line[j]);
            }
        }
        for (i = n - 2; i >= 0; i--) {
            for (j = 0; j <= i; j++) {
                herringArray[i][j] += Math.max(herringArray[i + 1][j], herringArray[i + 1][j + 1]);
            }
        }
        System.out.println(herringArray[0][0]);
    }
}
