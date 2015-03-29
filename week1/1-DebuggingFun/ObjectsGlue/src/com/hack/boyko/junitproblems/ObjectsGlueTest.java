package com.hack.boyko.junitproblems;

import static org.junit.Assert.*;

import org.junit.Test;

public class ObjectsGlueTest {

    private final ObjectsGlue glue = ObjectsGlueFactory.createObjectsGlueInstance();

    @Test
    public void concat() {

        assertEquals("Днес видях 5 ходещи медузи и куче което ходи на ръце:)",
                glue.concat(" ", "Днес", "видях", 5, "ходещи", "медузи", "и куче", "което", "ходи", "на", "ръце:)"));
        assertEquals("Днес видях 5 ходещи медузи ) 4 )",
                glue.concat(" ", "Днес", "видях", 5, "ходещи", "медузи", ')', 4, ')'));
    }

}
