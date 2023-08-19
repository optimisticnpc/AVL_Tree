import algs.TreePrinter;
import java.util.Scanner;

public class TerminalInterface {
  public static void main(String[] args) {
    AvlTree tree = new AvlTree();

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Please enter a number to generate a tree (15 will add 1 to 15):");
      String number = scanner.nextLine();

      // If input is not and integer, ask again
      while (!number.matches("\\d+")) {
        System.out.println("Please enter a valid number:");
        number = scanner.nextLine();
      }

      int num = Integer.parseInt(number);
      for (int i = 1; i <= num; i++) {
        tree.add(i);
      }

      // Keep running until user quits
      while (true) {

        TreePrinter.print(tree.getRoot());
        System.out.println("Would you like to add or remove?");
        System.out.println("Type a for add, r for remove, or q to quit:");

        String choice = scanner.nextLine();
        // If invalid input, ask again
        while (!choice.matches("[aArRqQ]")) {
          System.out.println("Please enter a valid choice:");
          choice = scanner.nextLine();
        }

        // If add
        if (choice.matches("[aA]")) {
          System.out.println("Please enter a number to add:");
          String addNumber = scanner.nextLine();
          // If input is not an integer, ask again
          while (!addNumber.matches("\\d+")) {
            System.out.println("Please enter a valid number:");
            addNumber = scanner.nextLine();
          }
          int addNum = Integer.parseInt(addNumber);
          tree.add(addNum);
        }

        // If remove
        if (choice.matches("[rR]")) {
          System.out.println("Please enter a number to remove:");
          String removeNumber = scanner.nextLine();
          // If input is not an integer, ask again
          while (!removeNumber.matches("\\d+")) {
            System.out.println("Please enter a valid number:");
            removeNumber = scanner.nextLine();
          }
          int removeNum = Integer.parseInt(removeNumber);
          tree.remove(removeNum);
        }

        // If quit
        if (choice.matches("[qQ]")) {
          System.out.println("Goodbye!");
          // Exit system
          System.exit(0);
        }
      }

    } catch (Throwable e) {
      System.err.println(e);
    }
  }
}
