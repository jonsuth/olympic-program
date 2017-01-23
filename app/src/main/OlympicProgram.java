package main;

import main.country.Country;
import main.country_list.CountryList;
import java.util.*;

/**
 * Created by Jon on 31/10/2016.
 * Olympic Program
 */
public class OlympicProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        CountryList countryList = new CountryList();

        System.out.println("Welcome to the olympic medal program!");

        while (true) {
            if (countryList.isEmpty()) {
                System.out.println("This is your first visit, please add a country");
                countryList.add(createCountry());
            }

            System.out.println("1. Add new country to the program");
            System.out.println("2. Select country to update medal data");
            System.out.println("3. Sort medal data");
            System.out.println("4. View all countries");
            System.out.println("5. Quit");
            input = sc.nextLine();

            if (input.equals("1")) {
                countryList.add(createCountry());
            } else if (input.equals("2")) {
                SelectedCountryUpdate(countryList);
            } else if (input.equals("3")) {
                SortMedalTable(countryList);
            } else if (input.equals("4")) {
                ViewAllCountries(countryList);
            } else if (input.equals("5")) {
                break;
            }
        }
    }

    /**
     * Creates a country object and asks for the name, gold, silver and bronze medal count for the current day.
     * @return country
     */
    private static Country createCountry() {
        Scanner sc = new Scanner(System.in);
        String name;
        int gold;
        int silver;
        int bronze;
        System.out.println();
        System.out.println("Please enter the name of the country?");
        name = sc.nextLine();
        Country country = new Country(name);

        updateCountry(country);

        System.out.println("Country added successfully!");
        System.out.println();
        return country;
    }

    /**
     * Given the country list, searches for a country and updates the medal data
     * @param countryList list of countries
     */
    private static void SelectedCountryUpdate(CountryList countryList) {
        Country country = searchCountry(countryList);
        System.out.println("Country Selected: " + country.getName());
        updateCountry(country);
    }

    /**
     *
     * @param countryList list of countries
     */
    private static void SortMedalTable(CountryList countryList) {
        System.out.println();

        Country tempCountry;
        int firstTotal;
        int secondTotal;

        for (int i = 0; i < countryList.size(); i++) { // Outer loop
            for (int j = 0; j < countryList.size() - i - 1; j++) { // Inner loop
                firstTotal = countryList.getCountry(j).medalTable.getTotal();
                secondTotal = countryList.getCountry(j+1).medalTable.getTotal();

                if (Integer.compare(firstTotal, secondTotal) > 0) {
                    tempCountry = countryList.getCountry(j);
                    countryList.set(j, countryList.getCountry(j+1));
                    countryList.set(j+1, tempCountry);
                }
            }
        }

        countryList.printAllCountries();
    }

    /**
     *
     * @param countryList list of countries
     */
    private static void ViewAllCountries(CountryList countryList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. View all countries with medal data");
        System.out.println("2. View all countries without medal data");
        String input = sc.nextLine();

        if (input.equals("1")) {
            countryList.printAllCountriesWithMedals();
        } else if (input.equals("2")) {
            countryList.printAllCountries();
        }
        System.out.println();
    }

    /**
     * Searches for a country given the name
     * @param countryList list of countries
     * @return country/null
     */
    private static Country searchCountry(CountryList countryList) {
        Scanner sc = new Scanner(System.in);
        String name;

        while (true) {
            System.out.println();
            System.out.println("Please enter the name of the country? (Press 'q' to quit)");
            name = sc.nextLine();
            if (name.toLowerCase().equals("q")) {
                break;
            }
            Country country = countryList.searchCountry(name);
            if (country == null) {
                System.out.println("No such country found, please try again");
            } else {
                return country;
            }
        }

        return null;

    }

    /**
     * Updates the medal data for a country, takes the country object as a parameter
     * @param country list of countries
     */
    private static void updateCountry(Country country) {
        Scanner sc = new Scanner(System.in);
        int gold;
        int silver;
        int bronze;

        System.out.println("What is the gold medal count of " + country.getName() + " for today?");
        gold = sc.nextInt();
        sc.nextLine();

        System.out.println("What is the silver medal count of " + country.getName() + " for today?");
        silver = sc.nextInt();
        sc.nextLine();

        System.out.println("What is the bronze medal count of " + country.getName() + "  for today?");
        bronze = sc.nextInt();
        sc.nextLine();

        country.medalTable.addMedals(gold, silver, bronze);
    }

}