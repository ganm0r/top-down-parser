package app;

import java.util.Scanner;

import topdownparser.TopDownParser;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nTop-down Parser:\n\nCFG:\n\n" +
                         "E  -> TE'\n" +
                         "E' -> +TE' | @\n" +
                         "T  -> FT'\n" +
                         "T' -> *FT' | @\n" +
                         "F  -> (E)\n");

        int option = 0;

        while(option != 2) {
            System.out.print("\n1. Parse string\n2. Exit\n\nOperation = ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("\nParse string = ");
                    char[] parseStringCharacterArray = scanner.nextLine().toCharArray();

                    TopDownParser topDownParser = new TopDownParser(parseStringCharacterArray);
                    if(topDownParser.result()) {
                        System.out.print("\n[RESULT] String accepted\n");
                    } else {
                        System.out.print("\n[RESULT] Error, string not accepted\n");
                    }

                    break;

                case 2:
                    break;
            
                default:
                    System.out.print("\n[Error] Invalid operation\n\n");
                    continue;
            }
        }

        scanner.close();
    }
}
