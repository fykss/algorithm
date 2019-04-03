package tree;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Set<Integer> randoms1 = Stream.generate(() -> (int) (Math.random() * 100))
                .limit(20).collect(Collectors.toSet());
        Set<Integer> randoms2 = Stream.generate(() -> (int) (Math.random() * 100 + 100))
                .limit(20).collect(Collectors.toSet());

        randoms1.forEach(item -> binaryTree.add(item));

        List<Optional<Node>> collect = randoms1
                .stream()
                .map(item -> binaryTree.contains(item))
                .filter(Optional::isPresent)
                .collect(Collectors.toList());
        System.out.println(collect.size() == randoms1.size() ? "Ales good" : "Smth went wrong");

        List<Optional<Node>> collect2 = randoms2
                .stream()
                .map(item -> binaryTree.contains(item))
                .filter(Optional::isPresent)
                .collect(Collectors.toList());
        System.out.println(collect2.size() == 0 ? "Ales good" : "Smth went wrong");
    }
}
