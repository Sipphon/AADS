package org.laboratories.lw4_var6.queue;

import java.util.Arrays;

class PriorityQueue {

    private int[] arr;
    private int size;

    public PriorityQueue() {
        this.arr = new int[1];
        this.size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public void add(int value) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length + 1);
        }
        arr[size++] = value;
    }

    public int remove() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        int maxValue = arr[0];
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (maxValue == arr[i]) {
                maxValue = arr[0];
                index = 0;
                break;
            }
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                index = i;
            }
        }
        for (int j = index + 1; j < arr.length; j++) {
            arr[j - 1] = arr[j];
        }
        arr = Arrays.copyOf(arr, --size);
        return maxValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class Main {

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(10);
        queue.add(20);
        queue.add(15);
        queue.add(25);
        queue.add(5);
        queue.add(6);

        System.out.println("Queue before removing: " + queue);
        int maxPriority = queue.remove();
        System.out.println("Max priority request: " + maxPriority);
        System.out.println("Queue after removing: " + queue);
        System.out.println();
        queue.add(15);
        queue.add(3);
        queue.add(5);
        queue.add(6);

        System.out.println("Queue before removing: " + queue);
        maxPriority = queue.remove();
        System.out.println("Max priority request: " + maxPriority);
        System.out.println("Queue after removing: " + queue);
        System.out.println();
        System.out.println("Queue before removing: " + queue);
        maxPriority = queue.remove();
        System.out.println("Max priority request: " + maxPriority);
        System.out.println("Queue after removing: " + queue);

    }
}

