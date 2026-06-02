package me.nubi.leetcode.q146;

import java.util.*;

public class Solution {

    public static class LRUCache {
        private Map<Integer, Node> map;
        private LinkedNodeList queue;
        private int capacity;

        public static class LinkedNodeList {
            private Node head = null;
            private Node tail = null;
            private int size;

            public void addLast(Node node) {
                if (head == null) {
                    head = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                }
                tail = node;
                size++;
            }

            public Node removeFirst() {
                Node node = head;
                head = head.next;
                size--;
                if (head == null) {
                    tail = null;
                } else {
                    head.prev = null;
                }
                node.next = null;
                node.prev = null;
                return node;
            }

            private void removeNode(Node node) {
                if (node == null) {
                    return;
                }
                if (node.prev != null) {
                    node.prev.next = node.next;
                    if (node.next == null) {
                        tail = node.prev;
                    } else {
                        node.next.prev = node.prev;
                    }
                    size--;
                    node.next = null;
                    node.prev = null;
                } else {
                    removeFirst();
                }
            }

            public int size() {
                return size;
            }
        }

        public static class Node {
            public int key;
            public int value;
            public Node next;
            public Node prev;
        }

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            queue = new LinkedNodeList();
            this.capacity = capacity;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                queue.removeNode(node);
                queue.addLast(node);
            } else {
                Node node;
                if (queue.size() == capacity) {
                    node = queue.removeFirst();
                    map.remove(node.key);
                } else {
                    node = new Node();
                }
                node.key = key;
                node.value = value;
                queue.addLast(node);
                map.put(key, node);
            }
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = (map.get(key));
                queue.removeNode(node);
                queue.addLast(node);
                map.put(key, node);
                return node.value;
            } else {
                return -1;
            }
        }
    }
}
