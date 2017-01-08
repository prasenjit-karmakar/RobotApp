package com.xebia.robotapp.robot;

import com.xebia.robotapp.object.Object;

/**
 * @author Prasenjit
 */
public abstract class Robot {
    public abstract void walk(Double distance) throws Exception;
    public abstract void carry(Object object, Double distance) throws Exception;
    public abstract  void scan(String barCode) throws Exception;
}
