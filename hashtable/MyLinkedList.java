package com.bridgelabz.hashtable;

public class MyLinkedList<K,V> {
    MyMapNode<K, V> head;
    MyMapNode<K, V> tail;

    public MyMapNode<K, V> search(K key) {
        MyMapNode<K, V> tempNode = head;
        while (tempNode != null && tempNode.getNext() != null) {
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }

    public void append(MyMapNode<K, V> myNode) {
        if (head == null) {
            head = myNode;
        }
        if (tail != null) {
            tail.setNext(myNode);
        }
        tail =myNode;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}