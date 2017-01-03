package main.medal_table;

import java.util.ArrayList;

/**
 * Created by Jon Suthakaran on 17/11/2016.
 * Class for medal table
 */
public class MedalTable {
    private ArrayList<Integer> goldMedals = new ArrayList<>();
    private ArrayList<Integer> silverMedals = new ArrayList<>();
    private ArrayList<Integer> bronzeMedals= new ArrayList<>();
    private ArrayList<Integer> totalMedals = new ArrayList<>();
    private int day = 0;

    /**
     * Add gold, silver and bronze medal numbers to their respective Arraylist
     * Calls the updateTotal method after all three medal types are added
     * @param gold
     * @param silver
     * @param bronze
     */
    public void addMedals(int gold, int silver, int bronze) {
        this.goldMedals.add(this.day, gold);
        this.silverMedals.add(this.day, silver);
        this.bronzeMedals.add(this.day, bronze);
        updateTotal();
    }

    /**
     * Updates the total number of medals
     * Whenever any medals are added they must be added together
     * so that they can be added to the total and the day can be updated
     */
     private void updateTotal() {
        this.totalMedals.add(this.day,
                goldMedals.get(this.day) + silverMedals.get(this.day) + bronzeMedals.get(this.day));
        this.day++;
    }

    /**
     * Return the size of the medalTable
     * This is the number of medal records a country has
     * @return size
     */
    public int size() {
        return totalMedals.size() - 1;
    }

    /**
     * Get the medal count for for a specific medal type on a specific day
     * @param day
     * @param medalType = gold/silver/bronze/total
     * @return medal count for chosen medal and day
     */
    public int getMedal(int day, String medalType) {
        switch (medalType) {
            case "gold":
                return goldMedals.get(day);
            case "silver":
                return silverMedals.get(day);
            case "bronze":
                return bronzeMedals.get(day);
            case "total":
                return totalMedals.get(day);
        }
        return 0;
    }
}
