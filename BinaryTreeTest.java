package com.bridgelabz.binarytree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        MyBinaryTree<Integer> myTree = new MyBinaryTree<>();
        myTree.add(56);
        myTree.add(30);
        myTree.add(70);
        myTree.add(22);
        myTree.add(40);
        myTree.add(60);
        myTree.add(95);
        myTree.add(11);
        myTree.add(65);
        myTree.add(3);
        myTree.add(16);
        myTree.add(63);
        myTree.add(67);
        int size = myTree.size();
        MyTreeNode<Integer> foundNode = myTree.search(22);
        System.out.println(foundNode.key);
        System.out.println(size);
    }
}