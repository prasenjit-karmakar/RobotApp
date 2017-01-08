package com.xebia.robotapp.rules;

import java.util.ArrayList;
import java.util.List;

import com.xebia.robotapp.object.Object;
import com.xebia.robotapp.util.Constants;

/**
 * @author Prasenjit
 */
public class RuleValidator {
    private static final double maxWeight = 10;
    private static List<Rule> rules = new ArrayList<>();

    public static Validation executeRules(Object object,Double distance) {
        Rule invalidInputRule = (object1,distance1) -> {
            if (object.getWeight()<0 || distance<0)
                return new Validation(false, Constants.INVALID_INPUT);
            else
                return new Validation(true, Constants.VALIDATION_SUCCESS);
        };
        rules.add(invalidInputRule);
        Rule overWeightRule = (object1,distance1) -> {
            if (object.getWeight() >= maxWeight)
                return new Validation(false, Constants.OVERWEIGHT);
            else
                return new Validation(true, Constants.VALIDATION_SUCCESS);
        };
        rules.add(overWeightRule);
        Validation validation = null;
        for (Rule rule : rules) {
            validation = rule.check(object,distance);
            if (!validation.isValid())
                break;
        }
        return validation;
    }

}
