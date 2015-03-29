package com.hack.boyko.junitproblems;

public class ObjectsGlue {

    public String concat(Object glue, Object... objects) {
        String result = "";
        for (Object object : objects) {

            result += object + "" + glue;
        }
        return result.trim();
    }

    public boolean areObjectsEquals(String check, String methodResult) {

        if (check.equals(methodResult)) {
            return true;
        }
        return false;
    }
}
