import algs.TreePrinter;

public class TestRemove {

  public static void main(String[] args) {

    AvlTree tree = new AvlTree();

    for (int i = 1; i <= 15; i++) {
      tree.add(i);
    }

    TreePrinter.print(tree.getRoot());
    tree.remove(12);
    TreePrinter.print(tree.getRoot());
    tree.remove(14);
    TreePrinter.print(tree.getRoot());
    tree.remove(15);
    TreePrinter.print(tree.getRoot());


  }
}
