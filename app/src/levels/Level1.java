package levels;

import java.util.Scanner;

/**
 * Created by Jon on 31/10/2016.
 */
public class Level1 {
    public static void main(String[] args) {

        if (printQuestion().toLowerCase().equals("y")) {
            printTable();
        }

    }

    private static String printQuestion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to see the GB medal table? (Y/N)");
        return sc.nextLine();
    }

    private static void printTable() {
        System.out.println("                G    S    B   Total");
        System.out.println("Great Britain   27   23   17   67");
    }
}
