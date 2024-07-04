package prefix_trie;

public class Trie {
    private final static int ALPHABET_SIZE = 128;
    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            node = node.next(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = go(word);
        if (node == null) return false;
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return go(prefix) != null;
    }

    private Node go(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.isExists(c)) {
                node = node.next(c);
            } else {
                return null;
            }
        }
        return node;
    }

    private static class Node {
        private final Node[] child;
        private boolean isEnd;

        public Node() {
            child = new Node[ALPHABET_SIZE];
            isEnd = false;
        }

        public boolean isExists(char c) {
            return child[c] != null;
        }

        public Node next(char c) {
            if (isExists(c)) {
                return child[c];
            } else {
                return child[c] = new Node();
            }
        }
    }
}
