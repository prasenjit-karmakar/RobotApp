package com.xebia.robotapp.powersource;

/**
 * @author Prasenjit
 */
public class Battery implements PowerSource {
    private final static double fullCharge = 100;
    private double chargePerc;

    public Battery() {
        charge();
    }

    public void charge() {
        if (chargePerc < fullCharge) {
            System.out.println("Charging battery");
            chargePerc = fullCharge;
        } else
            System.out.println("Already charged");
    }

    public double getChargePerc() {
        return chargePerc;
    }

    public void setChargePerc(double chargePerc) {
        this.chargePerc = chargePerc;
    }
}
