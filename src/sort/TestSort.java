package sort;

import java.util.Arrays;
import java.util.Random;

public class TestSort {

    private static int[] array;
    private static int cntMore;
    private static int cnt;

    public static void main(String[] args) {
        int n = 100;
        init(n);
        long start = System.currentTimeMillis();
        bubleSort();
        printSort("Сортировка пузырьком", start, n);
        init(n);
        start = System.currentTimeMillis();
        insertSort();
        printSort("Сортировка вставками", start, n);
        init(n);
        start = System.currentTimeMillis();
        shellSort();
        printSort("Сортировка Шелл", start, n);
    }

    private static void printSort(String nameSort, long start, int n) {
        System.out.println(nameSort + ", длина массива " + n + ", количество сравнений " + cntMore + ", количество присваиваний " + cnt + ", время работы: " +
                (System.currentTimeMillis() - start));
        //Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static void init(int n) {
        array = null;
        cntMore = 0;
        cnt = 0;
        Random random = new Random();
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(n * 100);
        }
    }

    public static void bubleSortBetter() {
        boolean flag = false;
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (more(i, i + 1)) {
                    swap(i, i + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static void bubleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (more(j, j + 1)) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public static void insertSort() {
        for (int i = 1; i < array.length - 1; i++) {
            int x = array[i];
            int j = i;
            while (j > 0 && (array[j - 1] > x)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = x;
        }
    }

    public static void shellSort() {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j >= gap && more(j - gap, j); j -= gap) {
                    swap(j, j - gap);
                }

            }
        }
    }

    private static boolean more(int i, int j) {
        cntMore++;
        return array[i] > array[j];
    }

    private static void swap(int i, int j) {
        cnt++;
        int k = array[i];
        array[i] = array[j];
        array[j] = k;
    }
}
