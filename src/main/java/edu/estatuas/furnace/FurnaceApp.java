package edu.estatuas.furnace;

import edu.estatuas.furnace.heaters.GasHeater;
import edu.estatuas.furnace.heaters.Heater;
import edu.estatuas.furnace.heaters.WoodStove;
import edu.estatuas.furnace.rooms.Room;
import edu.estatuas.furnace.thermometers.DigitalThermo;
import edu.estatuas.furnace.thermometers.MercuryThermo;
import edu.estatuas.furnace.thermometers.Thermometer;

public class FurnaceApp {
    public static void main(String[] args) {

        /* We have a living room that is freezing, colder even that it's previous owner, with him being six feet under.
        This is the only room of the house that we want to operate on - therefore, we use a Singleton pattern.
         */


        Room livingRoom  = Room.getInstance();

        /* When we move in, the room already has an old, banged up wood stove with 10 wood logs piled to it's side.
        We'll bring in a mercury thermometer to check its temperature.
         */

        System.out.println("\t\t ***OLD STOVE***");
        int initialLogs = 10;
        Heater furnace = new WoodStove(initialLogs);
        Thermometer thermometer = new MercuryThermo(livingRoom.getTemperature());

        // We check the temperature before doing anything, just in case. It's a bit cold, so we'll get the stove going.
        // We want to get it up to 50C, so it radiates some good heat.

        System.out.println("\t\t ***NOT ENOUGH LOGS***");
        thermometer.readTemp();
        double desiredTemperature = 50d;
        livingRoom.updateTemperature(furnace.heatUp(livingRoom.getTemperature(), desiredTemperature));

        // Damn! We don't have enough logs. We'll have to get some...
        // Yet, furnace is of the Heater interface, form which we cannot get the .chopLogs() method that WoodStove has.
        // We downcast the interface.

        System.out.println("\t\t ***GETTING EXTRA LOGS/THERMO MAXED***");
        ((WoodStove)furnace).chopLogs();
        livingRoom.updateTemperature(furnace.heatUp(livingRoom.getTemperature(), desiredTemperature));
        ((MercuryThermo)thermometer).updateTemp(livingRoom.getTemperature());
        thermometer.readTemp();

        // Suddenly, the sun is right next to this house... literally. Thankfully, we are made out of vibecode so we survive.

        System.out.println("\t\t ***THE SUN IS A DEADLY LAZER***");
        livingRoom.updateTemperature(5500d);
        ((MercuryThermo)thermometer).updateTemp(livingRoom.getTemperature());
        thermometer.readTemp();

        // But the stove is another matter...
        ((WoodStove)furnace).chopLogs();
        livingRoom.updateTemperature(furnace.heatUp(livingRoom.getTemperature()));

        // After the sun moves on to cook another planet, we now find ourselves without a stove!
        // Also, the mercury is now floating around on the ground - it's container melted. We'll need a new thermometer.
        // Those new fancy thermometers link up to rooms, so let's get one of those!

        System.out.println("\t\t ***INSTALLING DIGITAL THERMOMETER***");
        livingRoom.updateTemperature(10d);
        thermometer = new DigitalThermo(livingRoom.getTemperature());

        // Oh no, we forgot to link it! It's a class method that it's not contained in the instance again...

        ((DigitalThermo)thermometer).linkRoom(livingRoom);
        thermometer.readTemp();

        // Much better... now let's get that new stove in! Damn, this thing can go up to 100ºC with no issue!

        System.out.println("\t\t ***INSTALLING GAS HEATER***");
        furnace = new GasHeater(100d);
        livingRoom.updateTemperature(furnace.heatUp(livingRoom.getTemperature()));
        thermometer.readTemp();

        // Let's let the room cool off, and let's have the new furnace hover at 24ºC... FOREVER.
        System.out.println("\t\t ***COOLING ROOM***");
        livingRoom.coolOff();
        thermometer.readTemp();

        System.out.println("\t\t ***GAS HEATER HOVERING***");
        desiredTemperature = 24d;
        livingRoom.updateTemperature(furnace.heatUp(livingRoom.getTemperature(), desiredTemperature));
        thermometer.readTemp();

        // ... wait, there's a strange noise coming from the stove!

        System.out.println("\t\t ***LEAST EXPLOSIVE EVENING***");
        ((GasHeater)furnace).blowUp();







    }
}