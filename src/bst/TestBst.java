package bst;

import java.util.Random;
import java.util.Stack;

public class TestBst {

    private static BstTree tree1 = new BstTree();
    private static BstTree tree2 = new BstTree();
    private static int randomValue = 500000;

    public static void main(String[] args) {
        Random random = new Random();
        int n = 500000;
        init(n);
        long start = System.currentTimeMillis();
        for(int i =0; i < n/10; i++) {
            int find = random.nextInt(randomValue);
            //System.out.println("Поиск в дереве числа: " + find + ", результат: " + tree1.search(find));
        }
        print("Поиск в дереве", start, n);

        start = System.currentTimeMillis();
        for(int i =0; i < n/10; i++) {
            int find = random.nextInt(randomValue);
            boolean result = tree2.search(find);
            //System.out.println("Поиск в отсортированном дереве числа: " + find + ", результат: " + result);
        }
        print("Поиск в отсортированном дереве", start, n);


        start = System.currentTimeMillis();
        for(int i =0; i < n/10; i++) {
            int find = random.nextInt(randomValue);
            tree1.remove(find);
            //System.out.println("Удаление из дерева числа: " + find);
        }
        print("Удаление из дерева", start, n);

        start = System.currentTimeMillis();
        for(int i =0; i < n/10; i++) {
            int find = random.nextInt(randomValue);
            tree2.remove(find);
            //System.out.println("Удаление из отсортированного дерева числа: " + find);
        }
        print("Удаление из отсортированного дерева", start, n);
    }

    private static void print(String nameOperation, long start, int n) {
        System.out.println(nameOperation + ", количество нод дерева  " + n + ", время работы: " +
                (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static void init(int n) {
        Random random = new Random();
        int first = random.nextInt(randomValue);
        for (int i = 0; i < n; i++) {
            tree2.insert(first++);
        }
        for (int i = 0; i < n; i++) {
            tree1.insert(random.nextInt(randomValue));
        }
    }
}
