package base_struct;

import java.util.Random;

public class TestArray {
    public static void main(String[] args) {
        Array<Integer> singleArray = new SingleArray<>();
        Array<Integer> vectorArray = new VectorArray<>();
        Array<Integer> factorArray = new FactorArray<>();
        Array<Integer> matrixArray = new MatrixArray<>();
        Array<Integer> arrayList = new ArrayListWrapper<>();


          testEndArray(singleArray, 100000);
        testBeginArray(singleArray, 100000);
        testRandomArray(singleArray, 100000);

        testEndArray(vectorArray, 100000);
        testBeginArray(vectorArray, 100000);
        testRandomArray(vectorArray, 100000);

        testEndArray(factorArray, 100000);
        testBeginArray(factorArray, 100000);
        testRandomArray(factorArray, 100000);

        testEndArray(matrixArray, 100000);
        testBeginArray(matrixArray, 100000);
        testRandomArray(matrixArray, 100000);

        testEndArray(arrayList, 100000);
        testBeginArray(arrayList, 100000);
        testRandomArray(arrayList, 100000);

    }

    private static void testEndArray(Array<Integer> data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j++)
            data.add(j);

        System.out.println(data + " testAddEndArray: " +
                (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int j = 0; j < total; j++)
            data.get(j);

        System.out.println(data + " testGetArray: " +
                (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int j = total - 1; j >= 0; j--) {
            if (j == 0) {
                data.remove(0);
                continue;
            }
            data.remove(j);
        }

        System.out.println(data + " testRemoveEndArray: " +
                (System.currentTimeMillis() - start));
    }


    private static void testBeginArray(Array<Integer> data, int total) {
        long start = System.currentTimeMillis();
        start = System.currentTimeMillis();
        for (int j = 0; j < total; j++)
            data.add(j, 0);

        System.out.println(data + " testAddBeginArray: " +
                (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int j = 0; j < total; j++)
            data.remove(0);

        System.out.println(data + " testRemoveBeginArray: " +
                (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Random r = new Random();
        for (int j = 0; j < total; j++)
            data.add(r.nextInt(total - 1), j);

    }


    private static void testRandomArray(Array<Integer> data, int total) {
        long start = System.currentTimeMillis();
        Random r = new Random();
        for (int j = 0; j < total; j++)
            data.add(r.nextInt(total - 1), j);

        System.out.println(data + " testAddRandomArray: " +
                (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int j = total - 1; j >= 0; j--) {
            if (j == 0) {
                data.remove(0);
                continue;
            }
            data.remove(r.nextInt(j));
        }

        System.out.println(data + " testRemoveRandomArray: " +
                (System.currentTimeMillis() - start));

    }
}
