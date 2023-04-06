package org.laboratories.lw6_var6;

import java.util.ArrayList;


public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(int value) {
        root = insertNode(root, value);
    }

    Node insertNode(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else if (value > node.value) {
            node.right = insertNode(node.right, value);
        }

        return node;
    }

    void reverseTraversal(Node node) {
        if (node != null) {
            reverseTraversal(node.right);
            System.out.print(node.value + " ");
            reverseTraversal(node.left);
        }
    }

    public Node find(int value) {
        Node current = root;

        ArrayList<Node> path = new ArrayList<>();

        while (current != null) {
            path.add(current);
            if (value == current.value) {

                System.out.print("Path: ");
                for (Node node : path) {
                    System.out.print(node.value + " ");
                }
                System.out.println();
                return current;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }



}
