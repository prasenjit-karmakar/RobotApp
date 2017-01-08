package com.xebia.robotapp.robot;

import com.xebia.robotapp.object.Object;
import com.xebia.robotapp.powersource.Battery;
import com.xebia.robotapp.robot.parts.Chest;
import com.xebia.robotapp.robot.parts.Head;
import com.xebia.robotapp.robot.parts.SimpleChest;
import com.xebia.robotapp.robot.parts.SimpleHead;
import com.xebia.robotapp.util.Constants;
import com.xebia.robotapp.util.PowerConsumptionCalculator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Prasenjit
 */
public class SimpleRobotTest {
    private Head head;
    private Chest chest;
    private PowerConsumptionCalculator powerConsumptionCalculator;
    @Before
    public void setUp()
    {
        head = new SimpleHead();
        chest= new SimpleChest();
        powerConsumptionCalculator = new PowerConsumptionCalculator();
    }
    @Test
    public void testRobotCanWalkMaxFiveKm() throws Exception {
        SimpleRobot r = new SimpleRobot(new Battery(), head, chest,powerConsumptionCalculator);
        r.walk(5.0);
        Assert.assertEquals(r.getPowerSource().getChargePerc(),0.0);

    }

    @Test
    public void testRobotCannotCarryMoreThanTenKg(){
        SimpleRobot r = new SimpleRobot(new Battery(), head, chest,powerConsumptionCalculator);
        try {
            r.carry(new Object(11.0), 1.0);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(),Constants.OVERWEIGHT);
        }
    }
    @Test
    public void testSuccessfulScan() throws Exception {
        SimpleRobot r = new SimpleRobot(new Battery(), head, chest,powerConsumptionCalculator);
        r.scan("barcode");
    }

    @Test
    public void testUnSuccessfulScan(){
        SimpleRobot r = new SimpleRobot(new Battery(), head, chest,powerConsumptionCalculator);
        try {
            r.scan("");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(),Constants.SCAN_FAILURE);
        }
    }
}
