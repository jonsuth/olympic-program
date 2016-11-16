package main.country;

/**
 * Created by Jon Suthakaran on 16/11/2016.
 * Level 3 implementation of Country class
 */
public class CountryLevel3 {
    private String name;
    private int goldMedals = 0;
    private int silverMedals = 0;
    private int bronzeMedals = 0;
    private int total;

    public CountryLevel3(String name) {
        this.name = name;
    }

    public CountryLevel3(String name, int goldMedals, int silverMedals, int bronzeMedals) {
        this.name = name;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
    }

    public CountryLevel3(String name, int goldMedals, int silverMedals, int bronzeMedals, int total) {
        this.name = name;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
        this.total = total;
    }

    public int getGoldMedals() {
        return goldMedals;
    }

    public void setGoldMedals(int goldMedals) {
        this.goldMedals = this.goldMedals + goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public void setSilverMedals(int silverMedals) {
        this.silverMedals = this.silverMedals + silverMedals;
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    public void setBronzeMedals(int bronzeMedals) {
        this.bronzeMedals = this.bronzeMedals + bronzeMedals;
    }

    public int getTotal() {
        return total;
    }

    public void updateTotal() {
        this.total = this.goldMedals + this.silverMedals + this.bronzeMedals;
    }
}

