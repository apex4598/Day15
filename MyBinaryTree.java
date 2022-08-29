package com.bridgelabz.binarytree;

public class MyBinaryTree<K extends Comparable<K>> {
    MyTreeNode<K> root;
    int size;

    public void add(K key) {
        size++;
        root = this.addRecursively(root, key);
    }


    public MyTreeNode<K> addRecursively(MyTreeNode<K> current, K key) {
        if (current == null) {
            return new MyTreeNode<>(key);
        }
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0) return current;
        if (compareResult < 0) {
            current.left = addRecursively(current.left, key);
        } else {
            current.right = addRecursively(current.right, key);
        }
        return current;
    }

    public int size() {
        return size;
    }

    public MyTreeNode<K> search(K key) {
        if (root.key == key) {
            return root;
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            root = root.left;
            return search(key);
        } else if (compare > 0) {
            root = root.right;
            return search(key);
        }
        return null;
    }
}