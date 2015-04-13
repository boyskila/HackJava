package com.boyko.hack.servicenotavailableatthemoment;

public class ServiceNotAvailableAtTheMoment extends Exception {

    private static final String MASSAGE_INTERNET = "Unexpected termination of internet connection ";
    private static final String OPERATOR_MASSAGE = "Please contact with your administrator";

    public ServiceNotAvailableAtTheMoment() {
        super(MASSAGE_INTERNET);
    }

    public ServiceNotAvailableAtTheMoment(String str) {
        super(str);
    }

    public static void useService() throws ServiceNotAvailableAtTheMoment {

        int a = Integer.parseInt("H");
        System.out.println(a);

    }

}
