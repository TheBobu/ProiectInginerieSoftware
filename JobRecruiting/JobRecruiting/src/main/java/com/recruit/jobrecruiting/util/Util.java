/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DENISA
 */
public class Util {

    public static <T> List<T> detachEntities(List<? extends Detachable> inputArray) {

        List<T> output = new ArrayList<>();
        inputArray.forEach((Detachable element) -> {
            output.add((T) element.detach());
        });
        return output;
    }

    public static int number(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
