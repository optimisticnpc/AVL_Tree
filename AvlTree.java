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
      while (true) {
        // If we find that the key is already in the tree
        if (key == currentNode.getKey()) {
          return;
        }
        // If key less than current node key
        if (key < currentNode.getKey()) {
          if (currentNode.getLeft() == null) {
            Node newNode = new Node(key, currentNode);
            currentNode.setLeft(newNode);
            newNode.setParent(currentNode);
            return;
          }
          currentNode = currentNode.getLeft();
        }

        // If key greater than current node key
        if (key > currentNode.getKey()) {
          if (currentNode.getRight() == null) {
            Node newNode = new Node(key, currentNode);
            currentNode.setRight(newNode);
            newNode.setParent(currentNode);
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

  public void rotate(Node node) {
    // If node is root, do nothing
    if (node.getParent() == null) {
      return;
    }

    // Find is the node left of its parent or not
    boolean isNodeLeft;
    Node parent = node.getParent();
    if (parent.getLeft() == node) {
      isNodeLeft = true;
    } else {
      isNodeLeft = false;
    }

    Node grandparent = parent.getParent();
    // Only do the following if grandparent exists
    if (grandparent != null) {
      boolean isParentLeft;
      if (grandparent.getLeft() == parent) {
        isParentLeft = true;
      } else {
        isParentLeft = false;
      }

      // Attach node to the grandparent
      if (isParentLeft) {
        grandparent.setLeft(node);
      } else {
        grandparent.setRight(node);
      }
      node.setParent(grandparent);
    } else {
      // If grandparent does not exist, node is the new root
      node.setParent(null);
      this.root = node;
    }

    // TODO: Check all fields are updated

    if (isNodeLeft) {
      // CASE 1: Node is left of parent
      // Get the node's right child to transfer later
      Node nodeToTransfer = node.getRight();

      // Attach parent to node's right
      // Update parent field in former parent
      node.setRight(parent);
      parent.setParent(node);

      // Attach node's right to former parent's left
      if (nodeToTransfer != null) {
        parent.setLeft(nodeToTransfer);
        nodeToTransfer.setParent(parent);
      } else {
        parent.setLeft(null);
      }
    } else {
      // CASE 2: Node is right of parent
      // Get the node's left child to transfer later
      Node nodeToTransfer = node.getLeft();

      // Attach parent to node's left
      // Update parent field in former parent
      node.setLeft(parent);
      parent.setParent(node);

      // Attach node's left to former parent's right
      if (nodeToTransfer != null) {
        parent.setRight(nodeToTransfer);
        nodeToTransfer.setParent(parent);
      } else {
        parent.setRight(null);
      }
    }
  }

  public Node search(int key) {
    if (root == null) {
      return null;
    } else {
      Node currentNode = root;
      while (true) {
        if (currentNode == null) {
          return null;
        }

        // If we find that the key is already in the tree
        if (key == currentNode.getKey()) {
          return currentNode;
        }
        // If key less than current node key
        if (key < currentNode.getKey()) {
          currentNode = currentNode.getLeft();
        }

        // If key greater than current node key
        if (key > currentNode.getKey()) {
          currentNode = currentNode.getRight();
        }
      }
    }
  }
}
