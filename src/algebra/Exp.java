package algebra;

public class Exp {

    public static long getExpIt(long a, long b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static long getExpOn(long a, long b) {
        if (b == 0) {
            return 1;
        }
        return a * getExpOn(a, b - 1);
    }

    public static long getExpDiv2(long a, long b) {
        long result = 1;
        while (b > 1) {
            if (b % 2 == 1)
                result *= a;
            a *= a;
            b /= 2;
        }
        if (b > 0) {
            result *= a;
        }
        return result;
    }
}
