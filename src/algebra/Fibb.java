package algebra;

public class Fibb {

    public static long getFibbRec(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        return getFibbRec(n - 1) + getFibbRec(n - 2);
    }

    public static long getFibbIter(long n) {
        long f0 = 0;
        long f1 = 1;
        long f = 0;
        for (int i = 1; i < n; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;
    }
}
