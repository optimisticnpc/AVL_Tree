public class AvlTree {
    Node root;

    public AvlTree() {
        root = null;
    }


    public void add(int key) {
        if (root == null) {
            root = new Node(key, null);
            return;
        } else {
            Node currentNode = root;
            while (true ) {

                // If we find that the key is already in the tree
                if (key == currentNode.getKey()) {
                    return;
                }
                // If key less than current node key
                if (key < currentNode.getKey()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new Node(key, currentNode));
                        return;
                    }
                    currentNode = currentNode.getLeft();
                }

                // If key greater than current node key
                if (key > currentNode.getKey()) {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new Node(key, currentNode));
                        return;
                    }
                    currentNode = currentNode.getRight();
                }
            }
        }
    }


    public Node getRoot() {
        return root;
    }
    

}