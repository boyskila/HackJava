package com.hack.boyko.junitproblems;

public class ObjectsGlueFactory {

    public static ObjectsGlue createObjectsGlueInstance() {
        return new ObjectsGlue();
    }

    public static void main(String[] args) {
        final ObjectsGlue glue = ObjectsGlueFactory.createObjectsGlueInstance();

        System.out.println(glue.concat(" ", "Днес", "видях", 5, "ходещи", "медузи", ')', 4, ')'));
        System.out.println(glue.areObjectsEquals("Днес видях 5 ходещи медузи ) 4)",
                glue.concat(" ", "Днес", "видях", 5, "ходещи", "медузи", ')', 4, ')')));
    }

}
