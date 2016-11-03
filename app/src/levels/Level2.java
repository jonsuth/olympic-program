package levels;

import java.util.*;

/**
 * Created by Jon on 31/10/2016.
 * Level 2 of program
 */
public class Level2 {
    public static void main(String[] args) {

        if (printQuestion().toLowerCase().equals("y")) {
            getMedalCount();
        }


    }

    private static void getMedalCount() {
        final int GOLD = 27;
        final int SILVER = 23;
        final int BRONZE = 17;
        final int TOTAL = 67;
        int gold = getGoldCount() + GOLD;
        int silver = getSilverCount() + SILVER;
        int bronze = getBronzeCount() + BRONZE;
        int total = TOTAL + gold + silver + bronze;
        printTable(gold, silver, bronze, total);
    }

    private static int getGoldCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the gold medal count for today?");
        return sc.nextInt();
    }

    private static int getSilverCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the silver medal count for today?");
        return sc.nextInt();
    }

    private static int getBronzeCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the bronze medal count for today?");
        return sc.nextInt();
    }

    private static String printQuestion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to see the GB medal table? (Y/N)");
        return sc.nextLine();
    }

    private static void printTable(int gold, int silver, int bronze, int total) {
        System.out.println("                G    S    B   Total");
        System.out.println("Great Britain   " + gold + "   " + silver + "   " + bronze + "   " + total);
    }
}
