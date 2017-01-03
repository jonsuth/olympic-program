package main.country;

import main.medal_table.MedalTable;

/**
 * Created by Jon Suthakaran on 03/11/2016.
 * Country class
 */
public class Country {
    private String name;
    public MedalTable medalTable = new MedalTable();

    /**
     * Constructor for country
     * @param name
     */
    public Country(String name) {
        this.name = name;
    }

    /**
     * Return the name of the country
     * @return name
     */
    public String getName() {
        return name;
    }

}

