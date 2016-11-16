package main;

import main.country.Country;

import java.util.*;

/**
 * Created by Jon on 31/10/2016.
 * Olympic Program
 */
public class OlympicProgram {
    public static void main(String[] args) {
        Country country = new Country("GB", 27, 23, 17, 67);
        System.out.println("Starting medal count Day: 0");
        printTable(country, 0);

        for (int day = 1; day <= 3; day++) {
            System.out.println("Day: " + day);
            if (printQuestion1().toLowerCase().equals("y")) {
                country = updateMedalCount(country, day);
            } else {
                country = preserveMedalCount(country, day);
            }
            printTable(country, day);
        }
    }

    private static Country updateMedalCount(Country country, int day) {
        country.setGoldMedals(getGoldCount(), day);
        country.setSilverMedals(getSilverCount(), day);
        country.setBronzeMedals(getBronzeCount(), day);
        country.updateTotal(day);
        return country;
    }

    private static Country preserveMedalCount(Country country, int day) {
        country.setGoldMedals(0, day);
        country.setSilverMedals(0, day);
        country.setBronzeMedals(0, day);
        country.updateTotal(day);
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

    private static void printTable(Country country, int day) {
        System.out.println("                G    S    B   Total");
        System.out.println("Great Britain   "
                + country.getGoldMedals(day) + "   "
                + country.getSilverMedals(day) + "   "
                + country.getBronzeMedals(day) + "   "
                + country.getTotal(day));
        System.out.println();
    }

    private static void queryMedals(Country country, int day) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\n1 = Gold \n2 = Silver \n3 = Bronze \nq = quit");
            System.out.println("Please choose an option");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    System.out.println("The Great Britain Gold medal count is: " + country.getGoldMedals(day));
                    break;
                case "2":
                    System.out.println("The Great Britain Silver medal count is: " + country.getSilverMedals(day));
                    break;
                case "3":
                    System.out.println("The Great Britain Bronze medal count is: " + country.getBronzeMedals(day));
                    break;
            }

            if (input.toLowerCase().equals("q")) {
                return;
            }
        }
    }
}