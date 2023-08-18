import algs.TreePrinter.PrintableNode;

public class Node implements PrintableNode{
  private int key;
  private int height;
  private Node left, right;
  private Node parent;

  // TODO: refactor so that setLeft and setRight also set the parent

  Node(int k, Node p) {
    height = 0;
    key = k;
    parent = p;
  }

public int getKey() {
    return key;
}

public void setKey(int key) {
    this.key = key;
}

public int getHeight() {
    return height;
}

public void setHeight(int height) {
    this.height = height;
}

public Node getLeft() {
    return left;
}

public void setLeft(Node left) {
    this.left = left;
}

public Node getRight() {
    return right;
}

public void setRight(Node right) {
    this.right = right;
}

public Node getParent() {
    return parent;
}

public void setParent(Node parent) {
    this.parent = parent;
}

@Override
public String getText() {
    return String.valueOf(key);
}




}
