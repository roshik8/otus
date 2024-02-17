package algebra;

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

    public static boolean isSimple(long n) {
        long count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count == 2;
    }
}
