public class AvlTree {
  // Add, update and balance function based of the functions in
  // in this video (with modifcations): https://www.youtube.com/watch?v=1QSYxIKXXP4

  Node root;

  public AvlTree() {
    root = null;
  }

  public void add(int key) {
    if (!contains(root, key)) {
      root = add(root, key);
    }
  }

  private Node add(Node root, int key) {
    if (root == null) {
      return new Node(key);
    } else if (key < root.getKey()) {
      root.setLeft(add(root.getLeft(), key));
    } else {
      root.setRight(add(root.getRight(), key));
    }

    update(root);
    return balance(root);
  }

  private Node balance(Node node) {
    // Left heavy subtree
    if (node.getBalanceFactor() == -2) {
      if (node.getLeft().getBalanceFactor() <= 0) {
        // In the left node, the left subtree is heavier or equal
        return rotate(node.getLeft());
      } else {
        // In the left node, the right subtree is heavier
        // Rotate the same node twice
        Node nodeToRotate = node.getLeft().getRight();
        rotate(nodeToRotate);
        return rotate(nodeToRotate);
      }

      // Right heavy subtree
    } else if (node.getBalanceFactor() == 2) {
      if (node.getRight().getBalanceFactor() >= 0) {
        // In the right node, the right subtree is heavier or equal
        return rotate(node.getRight());
      } else {
        // In the right node, the left subtree is heavier
        // Rotate the same node twice
        Node nodeToRotate = node.getRight().getLeft();
        rotate(nodeToRotate);
        return rotate(nodeToRotate);
      }
    }
    return node;
  }

  private void update(Node node) {
    int leftHeight = -1;
    int rightHeight = -1;

    if (node.getLeft() != null) {
      leftHeight = node.getLeft().getHeight();
    }
    if (node.getRight() != null) {
      rightHeight = node.getRight().getHeight();
    }

    node.setHeight(Math.max(leftHeight, rightHeight) + 1);

    node.setBalanceFactor(rightHeight - leftHeight);
  }

  public Node getRoot() {
    return root;
  }

  public Node rotate(Node node) {
    // If node is root, do nothing
    if (node.getParent() == null) {
      return node;
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

      // Attach node's right to former parent's left
      if (nodeToTransfer != null) {
        parent.setLeft(nodeToTransfer);
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

      // Attach node's left to former parent's right
      if (nodeToTransfer != null) {
        parent.setRight(nodeToTransfer);
      } else {
        parent.setRight(null);
      }
    }

    // TODO: check if I need all of these
    update(parent); // Update the (former) parent first because it is lower
    update(node);
    if (grandparent != null) {
      update(grandparent);
    }

    return node;
  }

  public Node search(Node root, int key) {
    if (root == null) {
      return null;
    } else {
      Node currentNode = root;
      while (true) {
        if (currentNode == null) {
          return null;
        }

        // If we find the key, return the node
        if (key == currentNode.getKey()) {
          return currentNode;
        }
        // If key less than current node key
        if (key < currentNode.getKey()) {
          currentNode = currentNode.getLeft();
        }
        // If key greater than current node key
        else if (key > currentNode.getKey()) {
          currentNode = currentNode.getRight();
        }
      }
    }
  }

  public boolean contains(int key) {
    return search(this.root, key) != null;
  }

  public boolean contains(Node root, int key) {
    return search(root, key) != null;
  }

  public void remove(int key) {
    Node node = search(root, key);
    // If node doesn't exist return
    if (node == null) {
      return;
    }

    // If node has 0 or 1 children
    if (node.getLeft() == null || node.getRight() == null) {
      simpleRemove(node);
    } else {
      // If node has 2 children
      // In the right subtree, find the node with the smallest key
      Node currentNode = node.getRight();
      while (currentNode.getLeft() != null) {
        currentNode = currentNode.getLeft();
      }
      // Replace the key of the node to be removed with the
      // key of the smallest node in the subtree
      node.setKey(currentNode.getKey());
      // Remove the smallest node in the subtree
      simpleRemove(currentNode);
    }
  }

  public void simpleRemove(Node node) {
    Node parent = node.getParent();
    // Node is root
    if (parent == null) {
      // If node has no children
      if (node.getLeft() == null && node.getRight() == null) {
        root = null;
      }
      // If node has one child
      else if (node.getLeft() != null && node.getRight() == null) {
        root = node.getLeft();
        node.getLeft().setParent(null);
      } else if (node.getLeft() == null && node.getRight() != null) {
        root = node.getRight();
        node.getRight().setParent(null);
      }
      return;
    }

    // Case 1: No descendants
    if (node.getLeft() == null && node.getRight() == null) {
      replaceNodeWith(parent, node, null);
    }

    // Case 2: One Child
    // Has left child
    if (node.getLeft() != null && node.getRight() == null) {
      Node leftChild = node.getLeft();
      replaceNodeWith(parent, node, leftChild);
    }

    // Has right child
    if (node.getLeft() == null && node.getRight() != null) {
      Node rightChild = node.getRight();
      replaceNodeWith(parent, node, rightChild);
    }
    // TODO: Learn recursion

    Node currentNode = parent;
    while (currentNode != null) {
      update(currentNode);
      balance(currentNode);
      currentNode = currentNode.getParent();
    }
  }

  private void replaceNodeWith(Node parent, Node node, Node replacement) {
    if (parent.getLeft() == node) {
      parent.setLeft(replacement);
    } else {
      parent.setRight(replacement);
    }
  }
}
