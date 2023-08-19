public class Main {

  public static void main(String[] args) {
    AvlTree tree = new AvlTree();

    // for (int i = 1; i <= 10; i++) {
    //   tree.add(i);
    //   TreePrinter.print(tree.getRoot());
    // }

    for (int i = 1; i <= 1000000; i++) {
      tree.add(i);
    }

    System.out.println("Height: " + tree.getRoot().getHeight());
    System.out.println("Contains 1,000,000: " + tree.contains(tree.getRoot(), 1000000));

    for (int i = 500000; i <= 1000000; i++) {
      tree.remove(i);
    }
    System.out.println("Height: " + tree.getRoot().getHeight());
    System.out.println("Contains 1,000,000: " + tree.contains(tree.getRoot(), 1000000));


  }
}
