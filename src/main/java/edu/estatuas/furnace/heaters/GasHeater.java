package edu.estatuas.furnace.heaters;

import java.util.Locale;

public class GasHeater implements Heater {

    private final double MAXTEMP;


    public GasHeater() {
        this.MAXTEMP = 50.0d;
    }

    public GasHeater(double temp) {
        this.MAXTEMP = temp;
    }

    public double getMaxTemp() {
        return MAXTEMP;
    }

    @Override
    public double heatUp(double currentTemp){
        double increasingTemp = currentTemp;
        System.out.println("The heating up process is starting at " + increasingTemp + "ºC");
        while (increasingTemp < MAXTEMP){
            increasingTemp += Math.round(((1d + Math.random()*2)*10))/10d;
            System.out.printf(Locale.US,"The temperature has increased to => %.1fºC%n", increasingTemp);
        }
        emissionWarning(currentTemp, increasingTemp);
        return increasingTemp;
    }

    @Override
    public double heatUp(double currentTemp, double desiredTemp){
        boolean possible = false;
        double increasingTemp = currentTemp;
        if (desiredTemp > MAXTEMP) {
            System.out.println("This heater is not able to reach the desired temperature!");
        } else {
            possible = true;
            System.out.println("The heating up process is starting at " + increasingTemp + "ºC");
        }

        while (increasingTemp < desiredTemp && possible){
            increasingTemp += Math.round(((1d + Math.random()*2)*10))/10d;
            System.out.printf(Locale.US, "The temperature has increased to => %.1fºC%n", increasingTemp);
        }
        emissionWarning(currentTemp, increasingTemp);
        return increasingTemp;
    }

    private void emissionWarning(double startingTemp, double finalTemp){
        double calculatedEmissions = (finalTemp - startingTemp) * (1d+Math.random()*2);
        System.out.printf(Locale.US, "This heater has emitted %.1f kg. of CO2.", calculatedEmissions);
        System.out.println(" \n");
    }

    public void blowUp(){
        System.out.println("WARNING! The secret autodestruction method has been turned on!");
        int  i = 5;
        while (i > 0){
            i--;
            System.out.println("Blowing up in " + i);
        }
        System.out.println("\n\n\n\n\nKABOOM!\n\n\n");
    }
}
