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
    public int day = 0;

    private int goldMedalTotal;
    private int silverMedalTotal;
    private int bronzeMedalTotal;

    /**
     * Add gold, silver and bronze medal numbers to their respective Arraylist
     * Calls the updateTotal method after all three medal types are added
     * @param gold
     * @param silver
     * @param bronze
     */
    public void addMedals(int gold, int silver, int bronze) {
        this.goldMedals.add(this.day, gold + goldMedalTotal);
        this.silverMedals.add(this.day, silver + silverMedalTotal);
        this.bronzeMedals.add(this.day, bronze + bronzeMedalTotal);
        updateTotal();
    }

    /**
     * Updates the total number of medals
     * Whenever any medals are added they must be added together
     * so that they can be added to the total and the day can be updated
     * Updates the totals for gold, silver and bronze
     */
     private void updateTotal() {
         this.goldMedalTotal = goldMedals.get(this.day);
         this.silverMedalTotal = silverMedals.get(this.day);
         this.bronzeMedalTotal = bronzeMedals.get(this.day);
         this.totalMedals.add(this.day,this.goldMedalTotal + this.silverMedalTotal + this.bronzeMedalTotal);
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

    public int getTotal() {
        return this.totalMedals.get(day-1);
    }
}
