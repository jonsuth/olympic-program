package main.country_list;

import main.country.Country;
import java.util.ArrayList;

/**
 * Created by Jon Suthakaran on 17/11/2016.
 * Country List class
 */
public class CountryList {
    private ArrayList<Country> countryList = new ArrayList<>();
    private static int countriesCounter = 0;
    // Counter variable to keep count of total number of countries
    // This is static and shared amongst all country objects

    /**
     * Add a country object to the country list
     * Increment counter every time a country is added
     * @param country
     */
    public void add(Country country) {
        countryList.add(countriesCounter, country);
        countriesCounter++;
    }

    /**
     * Return the number of countries stored in the country list, aka size
     * @return size
     */
    public int size() {
        return countriesCounter;
    }

    /**
     * Return true or false whether or not the country list is empty
     * @return true/false
     */
    public boolean isEmpty() {
        return countriesCounter == 0;
    }

    /**
     * Prints a formatted version of all countries along with every medal table associated with that country
     */
    public void printAllCountries() {
        for (Country country : countryList) {  // For country in country list
            System.out.println();
            System.out.println("Country " + countryList.indexOf(country) + ": " + country.getName());
            for (int i = 0; i <= country.medalTable.size(); i ++) {  // For a days results in the medal table
                System.out.println("G   S   B   Total");
                System.out.println(country.medalTable.getMedal(i, "gold") + "   "
                        + country.medalTable.getMedal(i, "silver") + "   "
                        + country.medalTable.getMedal(i, "bronze") + "   "
                        + country.medalTable.getMedal(i, "total"));
            }
        }
        System.out.println();
    }
}
