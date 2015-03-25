package com.hackbulgaria.corejava;

import java.lang.Thread.State;

public class FaultyProblem7 {
    public static int binarySearch(int element, int... array) {
        // Utils.killMeIfIGetStuck();

        int low = 0;
        int high = array.length - 1;

        int mid = (low + high) / 2;
        while (low <= high) {

            if (element > array[mid]) {
                low = mid + 1;
            } else if (element == array[mid]) {
                return mid;

            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }

        return -1; // not found
    }
}
