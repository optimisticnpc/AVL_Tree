import algs.TreePrinter.PrintableNode;

public class Node implements PrintableNode {
  private int key;
  private int height;
  private Node left, right;
  private Node parent;


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

  public void setLeft(Node node) {
    // Automatically sets the parent field of the child to reduce code
    this.left = node;
    if (node != null) {
      node.parent = this;
    }
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node node) {
    // Automatically sets the parent field of the child to reduce code
    this.right = node;
    if (node != null) {
      node.parent = this;
    }
  }

  @Override
  public String getText() {
    return String.valueOf(key);
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }


  public int getBalanceFactor(Node node) {
    return node.getLeft().getHeight() - node.getRight().getHeight();
  }
}
