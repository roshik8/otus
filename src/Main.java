import algebra.Exp;
import algebra.Fibb;
import algebra.SimpleNumbers;
import test.FileTest;

public class Main {

    public static void main(String[] args) {
        System.out.println(Exp.getExpIt(2, 12));
        System.out.println(Exp.getExpOn(2, 12));
        System.out.println(Exp.getExpDiv2(2, 12));

        System.out.println(Fibb.getFibbRec(10));
        System.out.println(Fibb.getFibbIter(10));
        System.out.println(Fibb.getFibMatrix(10));
        System.out.println(Fibb.getFibGold(10));

        System.out.println(SimpleNumbers.getSimpleNum(11));
        System.out.println(SimpleNumbers.getSimpleNum2(11));
        System.out.println(SimpleNumbers.getSimpleNumSito(11));

        FileTest.checkAllTestFromFolder("C:/Users/User/Downloads/5.Primes-19350-906510/5.Primes");
        FileTest.in.forEach((test, value) -> {
            var result = SimpleNumbers.getSimpleNumSito(value.intValue());
            var printResult = test + " " + (result == (FileTest.out.get(test)) ? "true" : "false");
            System.out.println(printResult);
        });
    }
}

