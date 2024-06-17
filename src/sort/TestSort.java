package sort;

import java.util.Random;

public class TestSort {

    private static int[] array;
    private static int cntMore;
    private static int cnt;
    private static int randomValue = 1000;

    public static void main(String[] args) {
        int n = 10000000;
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
        init(n);
        start = System.currentTimeMillis();
        selectionSort();
        printSort("Сортировка выбором", start, n);
        init(n);
        start = System.currentTimeMillis();
        heapSort();
        printSort("Сортировка выбором из кучи", start, n);
        init(n);
        start = System.currentTimeMillis();
        quickSort();
        printSort("Быстрая сортировка", start, n);
        init(n);
        start = System.currentTimeMillis();
        mergeSort();
        printSort("Сортировка слиянием", start, n);
        init(n);
        start = System.currentTimeMillis();
        countSort();
        printSort("Сортировка подсчетом", start, n);
        init(n);
        start = System.currentTimeMillis();
        radixSort();
        printSort("Сортировка поразрядная", start, n);
        init(n);
        start = System.currentTimeMillis();
        bucketSort();
        printSort("Сортировка ведрами", start, n);
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
            array[i] = random.nextInt(randomValue);
        }
    }

    private static void mergeSort() {
        mergeSortDiv(0, array.length - 1);
    }

    private static void mergeSortDiv(int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSortDiv(l, m);
        mergeSortDiv(m + 1, r);
        merge(l, m, r);
    }

    private static void merge(int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int a = l;
        int b = m + 1;
        int t = 0;
        while (a <= m && b <= r) {
            if (more(a, b)) {
                temp[t++] = array[b++];
            } else {
                temp[t++] = array[a++];
            }
        }
        while (a <= m) {
            temp[t++] = array[a++];
        }
        while (b <= r) {
            temp[t++] = array[b++];
        }

        for (int i = l; i <= r; i++) {
            array[i] = temp[i - l];
        }
    }

    private static void quickSort() {
        quick(0, array.length - 1);
    }

    private static void quick(int l, int r) {
        if (l >= r) return;
        int m = split(l, r);
        quick(l, m - 1);
        quick(m + 1, r);
    }

    private static int split(int l, int r) {
        int p = array[r];
        int m = l - 1;
        for (int j = l; j <= r; j++) {
            if (moreEq(p, array[j]))
                swap(++m, j);
        }
        return m;
    }

    public static void heapSort() {
        int n = array.length;
        for (int h = n / 2 - 1; h >= 0; h--) {
            heap(h, n);
        }
        for (int j = n - 1; j > 0; j--) {
            swap(0, j);
            heap(0, j);
        }
    }

    private static void heap(int root, int size) {
        int p = root;
        int l = 2 * p + 1;
        int r = 2 * p + 2;
        if (l < size && more(l, p)) {
            p = l;
        }
        if (r < size && more(r, p)) {
            p = r;
        }
        if (p == root) return;
        swap(root, p);
        heap(p, size);
    }

    public static void selectionSort() {
        for (int j = array.length - 1; j > 0; j--) {
            swap(findMax(j), j);
        }
    }

    private static int findMax(int j) {
        int max = 0;
        for (int i = 1; i <= j; i++) {
            if (more(i, max)) {
                max = i;
            }
        }
        return max;
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

    public static void countSort() {
        int[] arrayCount = new int[randomValue];
        for (int k : array) {
            arrayCount[k] = arrayCount[k] + 1;
        }

        int index = 0;
        for (int i = 0; i < arrayCount.length; i++) {
            for (int j = 0; j < arrayCount[i]; j++) {
                array[index] = i;

                index++;
            }
        }
    }

    public static void radixSort() {
        int digitCount = String.valueOf(max()).length();
        int place = 1;
        while (digitCount-- > 0) {
            countSort(place);
            place *= 10;
        }
    }

    private static void countSort(int place) {
        int range = 10;
        int[] frequency = new int[range];
        int[] sortedValues = new int[array.length];

        for (int number : array) {
            int digit = (number / place) % range;
            frequency[digit]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int digit = (array[i] / place) % range;
            sortedValues[frequency[digit] - 1] = array[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, array, 0, array.length);
    }

    public static void bucketSort() {
        int max = max() + 1;
        List[] bucket = new List[array.length];
        for (int a : array) {
            int nr = (int) ((long) a * (long) array.length / (long) max);
            bucket[nr] = new List(a, bucket[nr]);
            List item = bucket[nr];
            while (item.next != null) {
                if (item.value < item.next.value) {
                    break;
                }
                int x = item.value;
                item.value = item.next.value;
                item.next.value = x;
                item = item.next;
            }
        }
        int j = 0;
        for (List item : bucket) {
            while (item != null) {
                array[j++] = item.value;
                item = item.next;
            }
        }
    }

    private static int max() {
        int max = array[0];
        for (int a : array) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    private static boolean more(int i, int j) {
        cntMore++;
        return array[i] > array[j];
    }

    private static boolean moreEq(int i, int j) {
        cntMore++;
        return i >= j;
    }

    private static void swap(int i, int j) {
        cnt++;
        int k = array[i];
        array[i] = array[j];
        array[j] = k;
    }
}
