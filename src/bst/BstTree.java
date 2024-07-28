package bst;

import java.util.Stack;

public class BstTree {
    private BstNode root;

    public BstTree() {
    }

    public void insert(int key) {
        addKey(key);
    }

    public boolean search(int key) {
        return getNode(key) != null;
    }

    public void remove(int key) {
        deleteKey(key);
    }

    //добавление с помощью рекурсии, не использую потому что не хватает стека при количестве нод больше 10000
    private BstNode addKey(BstNode node, int key) {
        if (node == null) {
            return new BstNode(key);
        }
        if (key < node.getKey()) {
            node.setLeft(addKey(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(addKey(node.getRight(), key));
        }
        return node;
    }

    public void addKey(int key) {
        BstNode current = root, parent = null;
        while (current != null) {
            if (key == current.getKey()) {
                current.setKey(key);
                return;
            } else {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
        }
        BstNode newNode = new BstNode(key);
        if (parent == null) {
            root = newNode;
        } else {
            if (key < parent.getKey()) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
    }

    //поиск с помощью рекурсии, не использую потому что не хватает стека при количестве нод больше 10000
    private BstNode getNode(BstNode node, int key) {
        if (node == null || node.getKey() == key) {
            return node;
        } else if (key < node.getKey()) {
            return getNode(node.getLeft(), key);
        }
        return getNode(node.getRight(), key);
    }

    private BstNode getNode(int key) {
        BstNode current = root;
        while (current != null) {
            if (key == current.getKey()) {
                return current;
            }
            if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    //удаление с помощью рекурсии, не использую потому что не хватает стека при количестве нод больше 10000
    private BstNode deleteKey(BstNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.getKey()) {
            node.setLeft(deleteKey(node.getLeft(), key));
            return node;
        } else if (key > node.getKey()) {
            node.setRight(deleteKey(node.getRight(), key));
            return node;
        }

        if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        } else {
            int min = getMinNode(node.getRight()).getKey();
            node.setKey(min);

            node.setRight(deleteKey(node.getRight(), min));
            return node;
        }
    }

    private BstNode getMinNode(BstNode node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return getMinNode(node.getLeft());
        }
    }

    public void deleteKey(int key) {
        BstNode current = root, parent = null;
        while (current != null) {
            if (key == current.getKey()) {
                break;
            } else {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
        }
        if (current == null) {
            return;
        }
        if (current.getRight() == null) {
            if (parent == null) {
                root = current.getLeft();
            } else {
                if (current == parent.getLeft()) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
        } else {
            BstNode leftMost = current.getRight();
            parent = null;
            while (leftMost.getLeft() != null) {
                parent = leftMost;
                leftMost = leftMost.getLeft();
            }
            if (parent != null) {
                parent.setLeft(leftMost.getRight());
            } else {
                current.setRight(leftMost.getRight());
            }
            current.setKey(leftMost.getKey());
        }
    }
}
