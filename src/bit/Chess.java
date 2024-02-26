package bit;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

public class Chess {
    private final static BigInteger kA = new BigInteger("fefefefefefefefe", 16);
    private final static BigInteger kH = new BigInteger("7f7f7f7f7f7f7f7f", 16);
    private final static BigInteger kAB = new BigInteger("fcfcfcfcfcfcfcfc", 16);
    private final static BigInteger kGH = new BigInteger("3f3f3f3f3f3f3f3f", 16);
    private final static BigInteger kAll = new BigInteger("ffffffffffffffff", 16);

    private final static BigInteger k1 = new BigInteger("ff", 16);
    private final static BigInteger a = new BigInteger("101010101010101", 16);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число от 0 до 63: ");
        int position = scanner.nextInt();
        System.out.print("Введите наименование фигуры (король или конь): ");
        String piece = scanner.next().toLowerCase(Locale.ROOT);
        BigInteger pieceBits = BigInteger.ONE.shiftLeft(position);
        BigInteger mask = BigInteger.ZERO;
        switch (piece) {
            case ("король"):
                mask = kAll.and(getKingMoves(pieceBits));
                break;
            case ("конь"):
                mask = kAll.and(getHorseMoves(pieceBits));
                break;
            case ("ладья"):
                mask = kAll.and(getRookMoves(position));
                break;
            default:
                System.out.println("Неизвестная фигура");
                break;
        }
        System.out.println(popcntl(mask));
        System.out.println(popcntl2(mask));
        System.out.println(mask);
    }
    private static BigInteger getKingMoves(BigInteger king) {
        BigInteger kl = king.and(kA);
        BigInteger kr = king.and(kH);
        return (kl.shiftLeft(7)).or(king.shiftLeft(8))
                .or(kr.shiftLeft(9))
                .or(kl.shiftRight(1)).or(kr.shiftLeft(1))
                .or(kl.shiftRight(9)).or(king.shiftRight(8)).or(kr.shiftRight(7));
    }

    private static BigInteger getHorseMoves(BigInteger horse) {
        return kGH.and(horse.shiftLeft(6).or(horse.shiftRight(10))).or(
                kH.and(horse.shiftLeft(15).or(horse.shiftRight(17)))).or(
                kA.and(horse.shiftLeft(17).or(horse.shiftRight(15)))).or(
                kAB.and(horse.shiftLeft(10).or(horse.shiftRight(6))));
    }

    private static BigInteger getRookMoves(long rook) {
        int x =  (int)rook & 7;
        int y = (int)rook >> 3;

        return a.shiftLeft(x).xor(k1.shiftLeft(y*8));
    }

    static int popcntl(BigInteger mask) {
        int cnt = 0;
        while (mask.compareTo(BigInteger.ZERO) > 0) {
            if (mask.and(BigInteger.ONE).equals(BigInteger.ONE)) {
                cnt++;
            }
            mask = mask.shiftRight(1);
        }
        return cnt;
    }

    static int popcntl2(BigInteger mask) {
        int cnt = 0;
        while (mask.compareTo(BigInteger.ZERO) > 0) {
            cnt++;
            mask = mask.and(mask.subtract(BigInteger.ONE));
        }
        return cnt;
    }
}
