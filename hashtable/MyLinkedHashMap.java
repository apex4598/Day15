package com.bridgelabz.hashtable;

import java.util.ArrayList;

public class MyLinkedHashMap<K,V> {
    public int numBuckets;
    ArrayList<MyLinkedList<K, V>> myBucketArray;

    public MyLinkedHashMap() {
        this.numBuckets = 10;
        this.myBucketArray = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            myBucketArray.add(null);
        }
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K, V> myLinkedList = myBucketArray.get(index);
        if (myLinkedList == null) return null;
        MyMapNode<K, V> myMapNode = myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public int getBucketIndex(K key) {
        int hashcode = Math.abs(key.hashCode());
        int index = hashcode % numBuckets;
        System.out.println("Key: " + key + " hashcode: " + hashcode + " index: " + index);
        return index;
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K, V> myLinkedList = myBucketArray.get(index);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList<>();
            myBucketArray.set(index, myLinkedList);
        }
        MyMapNode<K, V> myMapNode = myLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList.append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "MyLinkedHashMap{" +
                "numBuckets=" + numBuckets +
                ", myBucketArray=" + myBucketArray +
                '}';
    }
}