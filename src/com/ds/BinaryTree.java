package com.ds;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        }
        else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println(" Inserted " + value + " to right of " + node.value);
                node.right = new Node(value);
            }
            }
        }
    }

    public class BinaryTree {

        private Node root;

        public static void main(String args[]) {
            BinaryTree bt = new BinaryTree();
            bt.root = new Node(5);
        }
    }
