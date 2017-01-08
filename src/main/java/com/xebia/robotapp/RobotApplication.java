package com.xebia.robotapp;

import com.xebia.robotapp.object.Object;
import com.xebia.robotapp.powersource.Battery;
import com.xebia.robotapp.robot.Robot;
import com.xebia.robotapp.robot.SimpleRobot;
import com.xebia.robotapp.robot.parts.SimpleChest;
import com.xebia.robotapp.robot.parts.SimpleHead;
import com.xebia.robotapp.util.PowerConsumptionCalculator;

/**
 * @author Prasenjit
 */
public class RobotApplication {
    public static void main(String[] args) {
        Robot robot1 = new SimpleRobot(new Battery(), new SimpleHead(), new SimpleChest(), new PowerConsumptionCalculator());
        try {
            robot1.walk(3.5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Robot robot2 = new SimpleRobot(new Battery(), new SimpleHead(), new SimpleChest(), new PowerConsumptionCalculator());
        try {
            robot2.carry(new Object(3.0), 2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
