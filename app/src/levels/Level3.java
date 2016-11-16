
package levels;

import main.country.CountryLevel3;

import java.util.Scanner;

/**
 * Created by Jon Suthakaran on 03/11/2016.
 * Level 3 of program
 */

public class Level3 {
    public static void main(String[] args) {
        CountryLevel3 country = new CountryLevel3("GB", 27, 23, 17, 67);
        printTable(country);

        if (printQuestion1().toLowerCase().equals("y")) {
            country = updateMedalCount(country);
            printTable(country);
        }

        if (printQuestion2().toLowerCase().equals("y")) {
            queryMedals(country);
        }
    }

    private static CountryLevel3 updateMedalCount(CountryLevel3 country) {
        country.setGoldMedals(getGoldCount());
        country.setSilverMedals(getSilverCount());
        country.setBronzeMedals(getBronzeCount());
        country.updateTotal();
        return country;
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

    private static String printQuestion1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to update the medal table? (Y/N)");
        return sc.nextLine();
    }

    private static String printQuestion2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to see specific medal counts? (Y/N)");
        return sc.nextLine();
    }

    private static void printTable(CountryLevel3 country) {
        System.out.println("                G    S    B   Total");
        System.out.println("Great Britain   " + country.getGoldMedals() + "   " + country.getSilverMedals() + "   "
                + country.getBronzeMedals() + "   "
                + country.getTotal());
        System.out.println();
    }

    private static void queryMedals(CountryLevel3 country) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\n1 = Gold \n2 = Silver \n3 = Bronze \nq = quit");
            System.out.println("Please choose an option");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    System.out.println("The Great Britain Gold medal count is: " + country.getGoldMedals());
                    break;
                case "2":
                    System.out.println("The Great Britain Silver medal count is: " + country.getSilverMedals());
                    break;
                case "3":
                    System.out.println("The Great Britain Bronze medal count is: " + country.getBronzeMedals());
                    break;
            }

            if (input.toLowerCase().equals("q")) {
                return;
            }
        }
    }

}

