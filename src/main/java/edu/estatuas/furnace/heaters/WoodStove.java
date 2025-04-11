package edu.estatuas.furnace.heaters;

import java.util.Locale;

public class WoodStove {

    private int woodLogs;
    private final double STOVE_RESISTANCE = 1538d;

    public WoodStove(){
        woodLogs = 0;
    }

    public WoodStove(int woodLogs) {
        this.woodLogs = woodLogs;
    }

    public void chopLogs(){
        int choppedLogs = (int)Math.round(Math.random()*10);
        this.woodLogs += choppedLogs;
        System.out.println("You have chopped " + choppedLogs + " logs.");
    }

    public double heatUp(double currentTemp) {
        double increasingTemp = currentTemp;

        int usedLogs = 0;
        boolean stoveMolten = false;
        while (this.woodLogs > 0 && !stoveMolten){
            this.woodLogs--;
            usedLogs++;
            increasingTemp = addLog(increasingTemp);

            if (this.woodLogs == 0){
                System.out.println("You have run out of logs!");
            }

            if (increasingTemp > STOVE_RESISTANCE){
                stoveMolten = true;
                System.out.println("Your stove is so hot that it's melting away!");
            }


        }

        System.out.println("You have used " + usedLogs + " logs.");
        System.out.printf(Locale.US, "Your stove is burning at %.1fºC.", increasingTemp);
        System.out.println(" \n");
        return increasingTemp;
    }

    public double heatUp(double currentTemp, double desiredTemp) {
        double increasingTemp = currentTemp;

        int usedLogs = 0;
        boolean stoveMolten = false;
        while (this.woodLogs > 0 && !stoveMolten && increasingTemp <= desiredTemp){
            this.woodLogs--;
            usedLogs++;
            increasingTemp = addLog(increasingTemp);

            if (this.woodLogs == 0){
                System.out.println("You have run out of logs!");
            }

            if (increasingTemp > STOVE_RESISTANCE){
                stoveMolten = true;
                System.out.println("Your stove is so hot that it's melting away!");
            }


        }

        System.out.println("You have used " + usedLogs + " logs.");
        System.out.printf(Locale.US, "Your stove is burning at %.1fºC.", increasingTemp);
        System.out.println(" \n");
        return increasingTemp;
    }

    private double addLog(double currentTemp){
        currentTemp += Math.round(((1d + Math.random()*4)*10))/10d;
        System.out.printf("You throw a log into the fire, increasing the temperature to %.1fºC%n", currentTemp);

        return currentTemp;
    }

}
