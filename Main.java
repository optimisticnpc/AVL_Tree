import algs.TreePrinter;

public class Main {

  public static void main(String[] args) {
    AvlTree tree = new AvlTree();

    // for (int i = 1; i <= 10; i++) {
    //   tree.add(i);
    //   TreePrinter.print(tree.getRoot());
    // }

    for (int i = 1; i <= 15; i++) {
      tree.add(i);
    }

    System.out.println("Height: " + tree.getRoot().getHeight());
    System.out.println(tree.contains(tree.getRoot(), 1000000));



  }
}
