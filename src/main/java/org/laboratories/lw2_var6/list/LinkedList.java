package org.laboratories.lw2_var6.list;

import org.laboratories.lw2_var6.Human;

import java.util.NoSuchElementException;

public class LinkedList {
    private ObjectNode head;
    private int size;

    public int getSize() {
        return size;
    }

    public void addFirstObject(Human object) {
        head = new ObjectNode(object, head);
        size++;
    }

    public void addLastObject(Human object) {
        ObjectNode newNode = new ObjectNode(object);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        ObjectNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public void insertObject(int index, Human object) {
        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirstObject(object);
            return;
        }
        if (index == size) {
            addLastObject(object);
            return;
        }
        ObjectNode current = head;
        for (int i = 0; i < index - 1; i++) {

            current = current.next;
        }
        current.next = new ObjectNode(object, current.next);
        size++;
    }

    public void removeFirstObject() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
    }

    public void removeLastObject() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {

            head = null;
            size = 0;
            return;
        }
        ObjectNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void removeObject(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirstObject();
            return;
        }
        ObjectNode current = head;
        for (int i = 0; i < index - 1; i++) {

            current = current.next;
        }
        ObjectNode toRemove = current.next;
        current.next = current.next.next;
        toRemove = null;
        size--;
    }

    public Human getObject(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int counter = 0;

        ObjectNode current = head;
        while (current != null) {
            if (counter == index) {
                return current.object;
            }
            current = current.next;
            counter++;
        }
        throw new IndexOutOfBoundsException();
    }

    public void clear() {

        ObjectNode current = head;
        while (current != null) {
            ObjectNode previous = current;
            current = current.next;
            previous = null;
        }
        head = null;
        size = 0;
    }

    public void print() {

        ObjectNode current = head;
        while (current != null) {

            System.out.println(current.object.toString());
            current = current.next;
        }
    }

    public boolean contains(Human object) {

        ObjectNode current = head;

        while (current != null) {

            if (current.object.equals(object)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void getPhonesFromOperators(String phoneOperator) {
        final String[] VODAFONE = {"050", "099", "095"};
        final String[] KYIVSTAR = {"067", "068", "098", "096"};
        final String[] LIFECELL = {"063"};

        LinkedList linkedList = new LinkedList();
        ObjectNode current = head;
        while (current != null) {
            if ("VODAFONE".equalsIgnoreCase(phoneOperator)) {
                for (String el : VODAFONE) {
                    if (current.object.getPhone().startsWith(el)) {
                        linkedList.addLastObject(current.object);
                    }
                }
            } else if ("KYIVSTAR".equalsIgnoreCase(phoneOperator)) {
                for (String el : KYIVSTAR) {
                    if (current.object.getPhone().startsWith(el)) {
                        linkedList.addLastObject(current.object);
                    }
                }
            } else if ("LIFECELL".equalsIgnoreCase(phoneOperator)) {
                for (String el : LIFECELL) {
                    if (current.object.getPhone().startsWith(el)) {
                        linkedList.addLastObject(current.object);
                    }
                }
            }
            current = current.next;
        }
        linkedList.print();
    }

    public void getHumansWhichLiveTheSameStreet(String street) {
        LinkedList linkedList = new LinkedList();
        ObjectNode current = head;
        while (current != null) {
            if (current.object.getAddress().equalsIgnoreCase(street)) {
                linkedList.addLastObject(current.object);
            }
            current = current.next;
        }
        linkedList.print();
    }


    private static class ObjectNode {
        Human object;
        ObjectNode next;

        public ObjectNode(Human object, ObjectNode next) {
            this.object = object;
            this.next = next;
        }

        public ObjectNode(Human object) {
            this.object = object;
            this.next = null;
        }
    }
}
