package org.laboratories.lw3_var6.list;

import java.util.Random;

public class DoublyLinkedList<T extends Object> {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (data.equals(current.object)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void addAtRandomOddPosition(T data) {
        Random random=new Random();
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        int randomIndex = random.nextInt(size);
        if (randomIndex % 2 == 0) {
            randomIndex++;
        }
        if (randomIndex == size - 1) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < randomIndex; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    public void addInFirstOddPosition(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                Node temp = current.next;
                current.next = newNode;
                newNode.prev = current;
                newNode.next = temp;
                temp.prev = newNode;
                size++;
                return;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        size++;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.object.toString());
            current = current.next;

        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        if (index == 0) {
            head.next.prev = null;
            head = head.next;
        } else if (index == size - 1) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    public int getSize() {
        return size;
    }


    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    // Клас Node
    private class Node {
        T object;
        Node prev;
        Node next;

        public Node(T data) {
            this.object = data;
            prev = null;
            next = null;
        }
    }
}
