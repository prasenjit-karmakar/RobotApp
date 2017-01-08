package com.xebia.robotapp.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Prasenjit
 */
public class PowerConsumptionCalculatorTest {
    private PowerConsumptionCalculator powerConsumptionCalculator;

    @Before
    public void setUp() {
        powerConsumptionCalculator = new PowerConsumptionCalculator();
    }

    @Test
    public void testBatteryConsumption() {
        Assert.assertEquals(powerConsumptionCalculator.availablePowerPerct(2.0, 3.0, 100.0), 48.0, 0.0);
    }
}
