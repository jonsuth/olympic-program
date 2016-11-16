package main.country;

import java.util.ArrayList;

/**
 * Created by Jon Suthakaran on 03/11/2016.
 * Country class
 */
public class Country {
    private String name;
    private ArrayList<Integer> goldHistory = new ArrayList<Integer>();
    private ArrayList<Integer> silverHistory = new ArrayList<Integer>();
    private ArrayList<Integer> bronzeHistory = new ArrayList<Integer>();
    private ArrayList<Integer> totalHistory = new ArrayList<Integer>();


    public Country(String name) {
        this.name = name;
    }

    public Country(String name, int goldMedals, int silverMedals, int bronzeMedals) {
        this.name = name;
        this.goldHistory.add(0, goldMedals);
        this.silverHistory.add(0, silverMedals);
        this.bronzeHistory.add(0, bronzeMedals);
    }

    public Country(String name, int goldMedals, int silverMedals, int bronzeMedals, int total) {
        this.name = name;
        this.goldHistory.add(0, goldMedals);
        this.silverHistory.add(0, silverMedals);
        this.bronzeHistory.add(0, bronzeMedals);
        this.totalHistory.add(0, total);
    }

    public String getName() {
        return name;
    }

    public int getGoldMedals(int day) {
        return goldHistory.get(day);
    }

    public void setGoldMedals(int goldMedals, int day) {
        this.goldHistory.add(day, this.goldHistory.get(day-1) + goldMedals);
    }

    public int getSilverMedals(int day) {
        return silverHistory.get(day);
    }

    public void setSilverMedals(int silverMedals, int day) {
        this.silverHistory.add(day, this.silverHistory.get(day-1) + silverMedals);
    }

    public int getBronzeMedals(int day) {
        return bronzeHistory.get(day);
    }

    public void setBronzeMedals(int bronzeMedals, int day) {
        this.bronzeHistory.add(day, this.bronzeHistory.get(day-1) + bronzeMedals);
    }

    public int getTotal(int day) {
        return totalHistory.get(day);
    }

    public void updateTotal(int day) {
        this.totalHistory.add(day, this.goldHistory.get(day)
                + this.silverHistory.get(day)
                + this.bronzeHistory.get(day));
    }

    public int getSize() {
        return totalHistory.size() - 1;
    }
}

