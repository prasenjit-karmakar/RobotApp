package com.xebia.robotapp.powersource;

/**
 * @author Prasenjit
 */
public interface PowerSource {
    void charge();
    double getChargePerc();
    void setChargePerc(double perc);
}
