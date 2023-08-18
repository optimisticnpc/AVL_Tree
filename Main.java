import algs.TreePrinter;

public class Main {

  public static void main(String[] args) {
    // AvlTree tree = new AvlTree();

    // // Test Case
    // tree.add(5);
    // tree.add(3);
    // tree.add(8);
    // tree.add(1);
    // tree.add(4);
    // tree.add(7);
    // tree.add(9);
    // tree.add(10);
    // tree.add(2);
    // tree.add(6);

    // for (int i = 1; i <= 7; i++) {
    //   TreePrinter.print(tree.getRoot());
    //   tree.rotate(tree.search(i));
    //   System.out.println("Rotate with pivot " + i);
    //   TreePrinter.print(tree.getRoot());
    //   System.out.println();
    //   System.out.println("........................................................");
    //   System.out.println();
    // }

    // Test 2

    AvlTree tree2 = new AvlTree();

    for (int i = 1; i <= 5; i++) {
      tree2.add(i);
    }

    TreePrinter.print(tree2.getRoot());
    System.out.println();
    System.out.println("........................................................");
    System.out.println();

    tree2.rotate(tree2.search(2));
    System.out.println("Rotate with pivot " + 2);
    TreePrinter.print(tree2.getRoot());
    System.out.println();
    System.out.println("........................................................");
    System.out.println();
  }
}
