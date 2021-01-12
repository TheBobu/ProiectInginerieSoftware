/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.util;

import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;

/**
 *
 * @author DENISA
 */
public class Rules {

    public static Boolean lowerThan(int compared, int limit) {
        return compared < limit;
    }

    public static Boolean greaterThan(int compared, int limit) {
        return compared > limit;
    }

    public static Boolean between(int compared, int lowerBound, int upperBound) {
        return compared <= lowerBound && compared >= upperBound;
    }

    public static Boolean lengthLowerThen(String compared, int limit) {
        return compared.length() < limit;
    }

    public static Boolean lengthGreaterThan(String compared, int limit) {
        return compared.length() > limit;
    }

    public static Boolean lengthBetween(String compared, int lowerBound, int upperBound) {
        return compared.length() <= lowerBound && compared.length() >= upperBound;
    }

    public static Boolean isStatus(String status) {
        try {
            Status.valueOf(status);
            return true;
        } catch (IllegalArgumentException | NullPointerException ex) {
            return false;
        }
    }

    public static Boolean isDepartment(String department) {
        try {
            Department.valueOf(department);
            return true;
        } catch (IllegalArgumentException | NullPointerException ex) {
            return false;
        }
    }

    public static Boolean isType(String type) {
        try {
            Type.valueOf(type);
            return true;
        } catch (IllegalArgumentException | NullPointerException ex) {
            return false;
        }
    }

    public static Boolean arrayNotEmpty(String[] array) {
        return array != null && array.length > 0;
    }

    public static Boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
