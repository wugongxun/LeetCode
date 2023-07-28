package com.wgx.fifty.day39;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgx
 * @since 2023/5/5 11:04
 */
public class LRU缓存 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
//        System.out.println(lruCache.get(2));
//        lruCache.put(2, 6);
//        System.out.println(lruCache.get(1));
//        lruCache.put(1, 5);
//        lruCache.put(1, 2);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));

    }
}

class LRUCache {
    Map<Integer, LinkedNode> map;
    int size;
    int capacity;
    LinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if (node == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            map.put(key, newNode);
            tail.prev.next = newNode;
            newNode.prev = tail.prev;
            newNode.next = tail;
            tail.prev = newNode;
            ++size;
            if (size > capacity) {
                LinkedNode remove = head.next;
                head.next = remove.next;
                head.next.prev = head;
                remove.next = null;
                remove.prev = null;
                map.remove(remove.key);
                --size;
            }
        } else {
            node.value = value;
            moveToTail(node);
        }
    }

    public void moveToTail(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}

class LinkedNode {
    int key;
    int value;
    LinkedNode prev;
    LinkedNode next;
    public LinkedNode() {}

    public LinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}