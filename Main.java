import algs.TreePrinter;

public class Main {
    
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();

        // Test Case
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        TreePrinter.print(tree.getRoot());
    }
}
