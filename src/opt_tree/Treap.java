package opt_tree;

public class Treap {

    private TreapNode root;

    public Treap() {
    }

    public void insert(int key) {
        root = addKey(root, key);
    }

    public boolean search(int key) {
        return getNode(root, key) != null;
    }

    public void remove(int key) {
        root = deleteKey(root, key);
    }


    private TreapNode merge(TreapNode t1, TreapNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        if (t1.getPriority() > t2.getPriority()) {
            t1.setRight(merge(t1.getRight(), t2));
            return t1;
        } else {
            t2.setLeft(merge(t1, t2.getLeft()));
            return t2;
        }
    }

    private TreapNode[] split(TreapNode root, int x) {
        TreapNode[] result = new TreapNode[2];
        if (root == null) {
            return result;
        }

        if (root.getKey() < x) {
            TreapNode[] t = split(root.getRight(), x);
            root.setRight(t[0]);
            result[0] = root;
            result[1] = t[1];
        } else {
            TreapNode[] t = split(root.getLeft(), x);
            root.setLeft(t[1]);
            result[0] = t[0];
            result[1] = root;
        }

        return result;
    }

    private TreapNode getNode(TreapNode node, int key) {
        if (node == null || node.getKey() == key) {
            return node;
        } else if (key < node.getKey()) {
            return getNode(node.getLeft(), key);
        }
        return getNode(node.getRight(), key);
    }

    private TreapNode addKey(TreapNode root, int key) {
        TreapNode node = new TreapNode(key);
        if (root == null) return node;
        if (node.getPriority() > root.getPriority()) {
            TreapNode[] t = split(root, node.getKey());
            node.setLeft(t[0]);
            node.setRight(t[1]);
            return node;
        } else {
            if (node.getKey() < root.getKey()) {
                root.setLeft(addKey(root.getLeft(), node.getKey()));
                return root;
            } else {
                root.setRight(addKey(root.getRight(), node.getKey()));
                return root;
            }
        }
    }

    private TreapNode deleteKey(TreapNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.getKey() == key) {
            return merge(root.getLeft(), root.getRight());
        } else if (key < root.getKey()) {
            root.setLeft(deleteKey(root.getLeft(), key));
            return root;
        } else {
            root.setRight(deleteKey(root.getRight(), key));
            return root;
        }
    }
}
