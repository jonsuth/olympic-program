package levels;

import main.country.Country;
import main.country_list.CountryList;
import java.util.*;

/**
 * Created by Jon on 31/10/2016.
 * Olympic Program
 */
public class Level6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        CountryList countryList = new CountryList();

        System.out.println("Welcome to the olympic medal program");

        while (true) {

            if (countryList.isEmpty()) {
                System.out.println("This is your first visit, please add a country");
                countryList.add(createCountry());
            }

            System.out.println("1. Add new country to the program");
            System.out.println("2. Select country");
            System.out.println("3. Quit");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    countryList.add(createCountry());
                    break;
                case "2":
                    countryList.printAllCountries();
                    break;
            }
            if (input.equals("3")) {
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

        System.out.println("Country added successfully!");
        System.out.println();
        return country;
    }
}