package org.laboratories.lw6_var6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        BinaryTree tree = new BinaryTree();
        System.out.println("How many values u want to add:");
        int values=scanner.nextInt();
        for (int i = 0; i < values; i++) {
            System.out.println("Add value:");
            tree.insert(scanner.nextInt());
        }

        System.out.println("Reverse Traversal of Binary Tree:");
        tree.reverseTraversal(tree.root);

        System.out.println("\nWhat value u want to find:");

        Node node = tree.find(scanner.nextInt());
        if (node != null) {
            System.out.println("Found node with value " + node.value);
        } else {
            System.out.println("Node not found");
        }
    }
}
