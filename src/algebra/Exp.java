package algebra;

public class Exp {

    public static long getExpOn(long a, long b) {
        if (b == 0) {
            return 1;
        }
        return  a * getExpOn(a, b - 1);
    }
}
