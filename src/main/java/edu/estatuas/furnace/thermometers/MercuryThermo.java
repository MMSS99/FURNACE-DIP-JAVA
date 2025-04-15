package edu.estatuas.furnace.thermometers;

public class MercuryThermo implements Thermometer{
    private double currentTemp = 0;
    private final double MAX_TEMP;

    public MercuryThermo(double currentTemp) {
        this.currentTemp = currentTemp;
        this.MAX_TEMP = 30d;
    }

    public MercuryThermo(double currentTemp, double MAX_TEMP) {
        this.currentTemp = currentTemp;
        this.MAX_TEMP = MAX_TEMP;
    }

    public void updateTemp(double changedTemp){
        this.currentTemp = changedTemp;
    }

    public void readTemp(){
        int mercuryTemp = (int) Math.round(currentTemp);

        if (mercuryTemp < MAX_TEMP){
            System.out.println("It looks like the temperature is somewhere around " + mercuryTemp + "ºC...\n ");
        } else {
            System.out.println("The temperature seems to be higher than " + (int)MAX_TEMP + "ºC, but that's as much as this thing can meassure.\n ");
        };
    }
}
