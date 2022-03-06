package project;

import java.util.Scanner;

public class InputCollector {

  private static InputCollector inputCollector = new InputCollector();
  private static boolean isOptionTurn = true;

  private InputCollector() {

  }

  public static InputCollector getInputCollector() {
    return inputCollector;
  }

  protected static String getUserInput(String prompt) {
    Scanner userInputReader = new Scanner(System.in);

    if (isOptionTurn) {
      showInputMenu();
      isOptionTurn = false;
      System.out.println(prompt);
      return Integer.toString(userInputReader.nextInt());
    }
    System.out.println(prompt);
    return userInputReader.nextLine();
  }

  private static void showInputMenu() {
    System.out.println("\n+====== Contact App =====+");
    System.out.println("| [1] List all contacts  |");
    System.out.println("| [2] Add new contact    |");
    System.out.println("| [3] Remove contact     |");
    System.out.println("| [4] Update contact     |");
    System.out.println("| [5] Quit program       |");
    System.out.println("+=========================+");
  }

  protected static void setAsOptionTurn() {
    isOptionTurn = true;
  }

}
