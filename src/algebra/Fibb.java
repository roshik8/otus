package algebra;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

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

    public static BigInteger getFibbIter(long n) {
        BigInteger f0 = BigInteger.valueOf(0);
        BigInteger f1 = BigInteger.valueOf(1);
        BigInteger f = BigInteger.valueOf(1);
        for (int i = 1; i < n; i++) {
            f = f0.add(f1);
            f0 = f1;
            f1 = f;
        }
        return f;
    }

    public static BigInteger[][] matrixMult(BigInteger[][] a, BigInteger[][] b) {
        return new BigInteger[][]{
                {a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))},
        };
    }

    public static BigInteger[][] matrixExpDiv2(BigInteger[][] a, long n) {
        if (n == 0) {
            return new BigInteger[][]{
                    {BigInteger.valueOf(1), BigInteger.valueOf(0)},
                    {BigInteger.valueOf(0), BigInteger.valueOf(1)}
            };
        } else if (n % 2 == 0) {
            return matrixExpDiv2(matrixMult(a, a), n / 2);
        } else {
            return matrixMult(matrixExpDiv2(a, n - 1), a);
        }
    }

    public static BigInteger getFibMatrix(long n) {
        if (n == 0) {
            return BigInteger.valueOf(0);
        }

        BigInteger[][] a = {
                {BigInteger.valueOf(1), BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(0)}
        };
        BigInteger[][] expA = matrixExpDiv2(a, n - 1);
        return expA[0][0];
    }

    public static BigDecimal getFibGold(int n) {
        //контекст используется для установления точности в BigDecimal и округления
        MathContext context = new MathContext(20, RoundingMode.HALF_UP);
        double sqrt5 = Math.sqrt(5);
        BigDecimal Sqrt5 = new BigDecimal(sqrt5, context);
        BigDecimal Phi = new BigDecimal((1 + sqrt5)/2, context);
        return Phi.pow(n, context).divide(Sqrt5, context);
    }
}
