package org.laboratories.lw4_var6.stack;

import java.util.Scanner;

class Node {
    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
        next = null;
    }
}

class Stack {
    Node top;

    Stack() {
        top = null;
    }

    void push(Object data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    Object pop() {
        if (top == null) {
            return null;
        }
        Object data = top.data;
        top = top.next;
        return data;
    }

    Object peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack numberStack = new Stack();
        Stack wordStack = new Stack();

        while (true) {
            System.out.print("Enter a number or a word (or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numberStack.push(number);
            } catch (NumberFormatException e) {
                wordStack.push(input);
            }
        }

        int maxNumber = Integer.MIN_VALUE;
        while (!numberStack.isEmpty()) {
            int number = (int) numberStack.pop();
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        System.out.println("Maximum number: " + maxNumber);

        String shortestWord = null;
        while (!wordStack.isEmpty()) {
            String word = (String) wordStack.pop();
            if (shortestWord == null || word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }
        System.out.println("Shortest word: " + shortestWord);
    }
}
