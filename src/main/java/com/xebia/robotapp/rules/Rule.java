package com.xebia.robotapp.rules;

import com.xebia.robotapp.object.Object;

/**
 * @author Prasenjit
 */
@FunctionalInterface
public interface Rule {
    Validation check(Object object, Double distance);
}
