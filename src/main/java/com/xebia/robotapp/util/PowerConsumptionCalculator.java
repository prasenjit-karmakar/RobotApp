package com.xebia.robotapp.util;

/**
 * @author Prasenjit
 */
public class PowerConsumptionCalculator {
    private final static double maxWalkDistance = 5;
    private final static double extraBatteryPerc = 2;
    private final static double fullCharge = 100;

    public double availablePowerPerct(Double distance, Double weight, double currentPerct) {
        return currentPerct - distance* (fullCharge / maxWalkDistance + extraBatteryPerc * weight);
    }
}
