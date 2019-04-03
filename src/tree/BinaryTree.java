package tree;

import java.util.Optional;

public class BinaryTree {

    class Node {
        int value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;

    private Optional<Node> contains(Node from, int val) {
        if (from == null) return Optional.empty();
        if (val == from.value) {
            return Optional.of(from);
        }
        if (val < from.value) {
            return contains(from.left, val);
        } else {
            return contains(from.right, val);
        }
    }

    public Optional<Node> contains(int val) {
        return contains(root, val);
    }

    private void add(Node from, int val) {
        if (val < from.value) {
            if (from.left == null) {
                from.left = new Node(val);
            } else {
                add(from.left, val);
            }
        } else if (val > from.value) {
            if (from.right == null) {
                from.right = new Node(val);
            } else {
                add(from.right, val);
            }
        }
    }

    void add(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            add(root, val);
        }
    }

    void remove(int value) {
        throw new IllegalStateException("Not implement yet");
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();




        binaryTree.add(30);
        binaryTree.add(20);
        binaryTree.add(40);
        binaryTree.add(50);
        binaryTree.add(60);

        System.out.println(binaryTree.contains(30).isPresent());
        System.out.println(binaryTree.contains(31).isPresent());
        System.out.println(binaryTree.contains(40).isPresent());
        System.out.println(binaryTree.contains(50).isPresent());
        System.out.println(binaryTree.contains(60).isPresent());
    }
}
