package main.country;

/**
 * Created by Jon Suthakaran on 03/11/2016.
 * Level 4 implementation of Country class
 */
public class CountryLevel4 {
    private String name;
    private int[] goldHistory = new int[4];
    private int[] silverHistory = new int[4];
    private int[] bronzeHistory = new int[4];
    private int[] totalHistory = new int[4];


    public CountryLevel4(String name) {
        this.name = name;
    }

    public CountryLevel4(String name, int goldMedals, int silverMedals, int bronzeMedals) {
        this.name = name;
        this.goldHistory[0] = goldMedals;
        this.silverHistory[0] = silverMedals;
        this.bronzeHistory[0] = bronzeMedals;
    }

    public CountryLevel4(String name, int goldMedals, int silverMedals, int bronzeMedals, int total) {
        this.name = name;
        this.goldHistory[0] = goldMedals;
        this.silverHistory[0] = silverMedals;
        this.bronzeHistory[0] = bronzeMedals;
        this.totalHistory[0] = total;
    }

    public String getName() {
        return name;
    }

    public int getGoldMedals(int day) {
        return goldHistory[day];
    }

    public void setGoldMedals(int goldMedals, int day) {
        this.goldHistory[day] = this.goldHistory[day-1] + goldMedals;
    }

    public int getSilverMedals(int day) {
        return silverHistory[day];
    }

    public void setSilverMedals(int silverMedals, int day) {
        this.silverHistory[day] = this.silverHistory[day-1] + silverMedals;
    }

    public int getBronzeMedals(int day) {
        return bronzeHistory[day];
    }

    public void setBronzeMedals(int bronzeMedals, int day) {
        this.bronzeHistory[day] = this.bronzeHistory[day-1] + bronzeMedals;
    }

    public int getTotal(int day) {
        return totalHistory[day];
    }

    public void updateTotal(int day) {
        this.totalHistory[day] = this.goldHistory[day] + this.silverHistory[day] + this.bronzeHistory[day];
    }
}

