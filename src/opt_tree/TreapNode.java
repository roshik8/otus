package opt_tree;


import java.util.Random;

public class TreapNode {
    private int key;
    private final int priority;
    private TreapNode left;
    private TreapNode right;

    public TreapNode(int key) {
        this.key = key;
        Random random = new Random();
        this.priority = random.nextInt();
    }

    public int getKey() {
        return key;
    }

    public int getPriority() {
        return priority;
    }

    public TreapNode getLeft() {
        return left;
    }

    public TreapNode getRight() {
        return right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(TreapNode left) {
        this.left = left;
    }

    public void setRight(TreapNode right) {
        this.right = right;
    }
}
