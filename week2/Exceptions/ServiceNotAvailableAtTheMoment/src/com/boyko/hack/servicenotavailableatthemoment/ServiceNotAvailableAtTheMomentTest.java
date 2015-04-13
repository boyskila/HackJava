package com.boyko.hack.servicenotavailableatthemoment;

public class ServiceNotAvailableAtTheMomentTest {

    public static void main(String[] args) throws ServiceNotAvailableAtTheMoment {

        try {

            ServiceNotAvailableAtTheMoment.useService();

        } catch (Exception e) {
            throw new ServiceNotAvailableAtTheMoment();
        }
    }

}
