package dynamic;

import java.util.Scanner;

public class FiveEight {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int f5 = 1;
        int f8 = 1;
        int f55 = 0;
        int f88 = 0;
        int n5, n8, n55, n88;
        for (int i = 2; i <= n; i++) {
            n5 = f8 + f88;
            n8 = f5 + f55;
            n55 = f5;
            n88 = f8;
            f5 = n5;
            f8 = n8;
            f55 = n55;
            f88 = n88;
        }
        int sum = f5 + f8 + f55 + f88;
        System.out.println(sum);
    }
}
