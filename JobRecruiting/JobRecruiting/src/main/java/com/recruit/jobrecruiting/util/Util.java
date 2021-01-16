/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.util;

import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

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

    public static String string(String s) {
        return s == null ? "" : s;
    }

    public static List<Status> statuses(String status) {
        List<Status> statuses = new ArrayList<>();
        try {
            statuses.add(Status.valueOf(status));
        } catch (Exception ex) {
            statuses = Arrays.asList(Status.values());
        }
        return statuses;
    }

    public static List<Type> types(String type) {
        List<Type> statuses = new ArrayList<>();
        try {
            statuses.add(Type.valueOf(type));
        } catch (Exception ex) {
            statuses = Arrays.asList(Type.values());
        }
        return statuses;
    }

    public static String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme() + "://";
        String serverName = request.getServerName();
        String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
        String contextPath = request.getContextPath();
        return scheme + serverName + serverPort + contextPath;
    }
}
