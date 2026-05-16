package me.nubi.leetcode.q146;


public class LRUCache {
    private int[] store = new int[10001];
    private Queue queue;

    public static class Node {
        Node next;
        Node pre;
        int data;

    }

    public static class Queue {
        private Node head = null;
        private Node tail = null;
        private int capacity =0;
        private int length = 0;
        private Node[] value2Node;
        public Queue(int capacity) {
            this.length = 0;
            this.capacity = capacity;
            this.value2Node = new Node[10000];
        }

        public int pop() {
            if (this.length == 0) {
                return -1;
            }
            int value = this.tail.data;
            this.value2Node[value] = null;
            this.length--;
            if (this.tail.pre == null) {
                this.tail = null;
                this.head = null;
            } else {
                this.tail.pre.next = null;
                this.tail = this.tail.pre;
            }
            return value;
        }

        public int push(int value) {
            if (this.length == this.capacity) {
                return -1;
            }
            if (this.length == 0) {
                this.head = new Node();
                this.head.data = value;
                this.value2Node[value] = this.head;
                this.tail = this.head;
            } else {
                Node node = new Node();
                node.data = value;
                this.head.pre = node;
                node.next = this.head;
                this.head = node;
                this.value2Node[value] = node;
                if (this.length == 1) {
                    this.tail = this.head.next;
                }
            }
            this.length++;
            return 0;
        }

        public int remove(int value) {
            Node node = this.value2Node[value];
            if (node == null) {
                return 0;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            } else {
                this.tail = node.pre;
            }
            if (node.pre != null) {
                node.pre.next = node.next;
            } else {
                this.head = node.next;
            }
            this.value2Node[value] = null;
            this.length--;
            return 1;
        }

        public int length() {
            return this.length;
        }
    }

    public LRUCache(int capacity) {
        this.queue = new Queue(capacity);
        for (int i=0; i<10001; i++) {
            this.store[i] = -1;
        }
    }

    public int get(int key) {
        int value = store[key];
        if (value!=-1) {
            if (this.queue.remove(key) == 1) {
                this.queue.push(key);
            }
            return store[key];
        }
        return -1;
    }

    public void put(int key, int value) {
        int e = store[key];
        store[key] = value;
        if (e != -1) {
            this.queue.remove(key);
            this.queue.push(key);
            return;
        }

        if (this.queue.length == this.queue.capacity) {
            e = this.queue.pop();
            store[e] = -1;
        }
        this.queue.push(key);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */