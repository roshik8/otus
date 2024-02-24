package algebra;

import java.util.Arrays;

public class SimpleNumbers {

    public static long getSimpleNum(long n) {
        long count = 0;
        for (int i = 2; i <= n; i++) {
            if (isSimple(i)) {
                count++;
            }
        }
        return count;
    }

    public static long getSimpleNum2(long n) {
        long count = 0;
        for (int i = 2; i <= n; i++) {
            if (isSimple2(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isSimple(long n) {
        long count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count == 2;
    }

    public static boolean isSimple2(long n) {
        if (n == 2) {
            return true;
        }
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long getSimpleNumSito(int n) {
        long count = 0;
        boolean[] sito = new boolean[n + 1];
        Arrays.fill(sito, true);
        sito[0] = false;
        sito[1] = false;
        for (int i = 2; i < sito.length; ++i) {
            if (sito[i]) {
                for (int j = 2; i * j < sito.length; ++j) {
                    sito[i * j] = false;
                }
            }
        }
        for (boolean d : sito) {
            if (d)
                count++;
        }
        return count;
    }
}
