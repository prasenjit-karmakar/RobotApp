package com.xebia.robotapp.robot;

import com.xebia.robotapp.object.Object;
import com.xebia.robotapp.powersource.PowerSource;
import com.xebia.robotapp.robot.parts.Chest;
import com.xebia.robotapp.robot.parts.Head;
import com.xebia.robotapp.rules.RuleValidator;
import com.xebia.robotapp.rules.Validation;
import com.xebia.robotapp.util.Constants;
import com.xebia.robotapp.util.PowerConsumptionCalculator;

/**
 * @author Prasenjit
 */
public class SimpleRobot extends Robot {
    private final static double thresholdLowPerc = 15;
    private final PowerSource powerSource;
    private final Head head;
    private final Chest chest;
    private final PowerConsumptionCalculator powerConsumptionCalculator;

    public SimpleRobot(PowerSource powerSource, Head head, Chest chest, PowerConsumptionCalculator powerConsumptionCalculator) {
        this.powerSource = powerSource;
        this.head = head;
        this.chest = chest;
        this.powerConsumptionCalculator = powerConsumptionCalculator;
    }

    public void walk(Double distance) {
        System.out.println("Robot is walking");
        powerSource.setChargePerc(powerConsumptionCalculator.availablePowerPerct(distance, 0d, powerSource.getChargePerc()));
        lowBatteryAlert();
        System.out.println("Battery remaining after walking " + distance + " km is:" + powerSource.getChargePerc() + " %");
    }

    public void carry(Object object, Double distance) throws Exception {
        Validation validation = RuleValidator.executeRules(object, distance);
        if (validation != null && !validation.isValid()) {
            chest.display(validation.getMessage());
            throw new Exception(validation.getMessage());
        } else {
            System.out.println("Carrying object");
            powerSource.setChargePerc(powerConsumptionCalculator.availablePowerPerct(distance, object.getWeight(), powerSource.getChargePerc()));
            lowBatteryAlert();
            System.out.println("Battery remaining after walking " + distance + " km with a weight of " + object.getWeight() + " kg is:" + powerSource.getChargePerc() + " %");
        }
    }


    @Override
    public void scan(String barCode) throws Exception {
        if (barCode != null && !barCode.isEmpty()) {
            System.out.println("Scanning barcode");
        } else {
            chest.display(Constants.SCAN_FAILURE);
            throw new Exception(Constants.SCAN_FAILURE);
        }
    }

    public void lowBatteryAlert(){
        if (powerSource.getChargePerc() < thresholdLowPerc) {
            head.indicator(Constants.LOW_BATTERY);
        }
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }
}
