import java.util.Scanner;

class Node {
    String value; // ubah tipe data dari int ke String
    Node leftChild;
    Node rightChild;

    public Node(String value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(String value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        while (true) {
            if (value.compareTo(current.value) < 0) { // ubah cara membandingkan nilai node dengan menggunakan metode compareTo()
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    return;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    return;
                }
                current = current.rightChild;
            }
        }
    }



    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.leftChild);
            System.out.print(node.value + " ");
            traverseInOrder(node.rightChild);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traversePreOrder(node.leftChild);
            traversePreOrder(node.rightChild);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.leftChild);
            traversePostOrder(node.rightChild);
            System.out.print(node.value + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();

        System.out.print("Masukkan jumlah node: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan nilai node ke-" + (i + 1) + ": ");
            String value = scanner.next(); // ubah input dari int ke String
            binaryTree.insert(value);
        }

        // tambahan output root
        System.out.println("\nNilai root:");
        System.out.println(binaryTree.root.value);

        System.out.println("\nIn-order traversal:");
        binaryTree.traverseInOrder(binaryTree.root);

        System.out.println("\nPre-order traversal:");
        binaryTree.traversePreOrder(binaryTree.root);

        System.out.println("\nPost-order traversal:");
        binaryTree.traversePostOrder(binaryTree.root);
    }
}