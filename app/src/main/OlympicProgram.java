package main;

import main.country.Country;

import java.util.*;

/**
 * Created by Jon on 31/10/2016.
 * Olympic Program
 */
public class OlympicProgram {
    public static void main(String[] args) {
        Country country = new Country("Great Britain", 27, 23, 17, 67);
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
        queryMedals(country);
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
        System.out.println("Would you like to see medal counts for specific days? (Y/N)");
        return sc.nextLine();
    }

    private static void printTable(Country country, int day) {
        System.out.println("                G    S    B   Total");
        System.out.println(country.getName() + "   "
                + country.getGoldMedals(day) + "   "
                + country.getSilverMedals(day) + "   "
                + country.getBronzeMedals(day) + "   "
                + country.getTotal(day));
        System.out.println();
    }

    private static void queryMedals(Country country) {
        Scanner sc = new Scanner(System.in);
        String input;
        if (printQuestion2().toLowerCase().equals("y")) {
            while (true) {
                System.out.println("What day would you like to see medal counts for ('q' to quit, 'a' for all)?");
                input = sc.nextLine();
                if (input.toLowerCase().equals("q")) {
                    break;
                } else if (input.toLowerCase().equals("a")) {
                    for (int day = 0; day <= country.getSize(); day ++) {
                        System.out.println("Medal count for day: " + day);
                        printTable(country, day);
                    }
                } else if (Integer.parseInt(input) <= country.getSize() && Integer.parseInt(input) >= 0) {
                    System.out.println("Medal count for day: " + input);
                    printTable(country, Integer.parseInt(input));
                } else {
                    System.out.println("Error - Day does not exist, please try again");
                }
            }
        }
    }
}