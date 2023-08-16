public class Node {
    int key;
    int height;

    Node left, right;
    Node parent;

    Node(int k, Node p) {
        height = 0;
        key = k;
        parent = p;
    }

}
