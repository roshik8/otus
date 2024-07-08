package dynamic;

import java.util.Scanner;

public class Peas {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String line = (console.nextLine()).replace(" ", "").trim();
        String[] split = line.split("\\+");
        int a = Integer.parseInt((split[0].split("/"))[0]);
        int b = Integer.parseInt((split[0].split("/"))[1]);
        int c = Integer.parseInt((split[1].split("/"))[0]);
        int d = Integer.parseInt((split[1].split("/"))[1]);

        int x = a * d + b * c;
        int y = b * d;
        int nod = nod(x, y);

        System.out.println(x / nod + "/" + y / nod);
    }

    private static int nod(int x, int y) {
        if (x == y) return x;
        if (x == 0) return y;
        if (y == 0) return x;
        if (even(x) && even(y)) return nod(x >> 1, y >> 1) << 1;
        if (even(x) && odd(y)) return nod(x >> 1, y);
        if (odd(x) && even(y)) return nod(x, y >> 1);
        if (x > y) return nod((x - y) >> 1, y);
        else return nod(x, y - x >> 1);
    }

    private static boolean even(int n) {
        return (n & 1) == 0;
    }

    private static boolean odd(int n) {
        return (n & 1) == 1;
    }
}
