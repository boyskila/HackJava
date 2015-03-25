package com.hackbulgaria.corejava1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hackbulgaria.corejava.FaultyProblem4;

public class FaultyProblem4Test {

    @Test
    public void testFloats() {
        for (float i = 2; i < 97; i++) {
            for (float j = 3; j < i * 17; j++) {
                float a = i / j;
                float b = 1 / (j / i);
                System.out.println(a + ", " + b);
                assertTrue(FaultyProblem4.areEqual(a, b));
            }
        }
    }

    @Test
    public void testAgainFloats() {
        assertTrue(FaultyProblem4.areEqual(0f / 6, 0f / 5));
        assertTrue(FaultyProblem4.areEqual(401f / 399, 1f / (399f / 401)));
    }

    @Test
    public void testInts() {
        assertTrue(FaultyProblem4.areEqual(4, 4));
        assertTrue(FaultyProblem4.areEqual(0, 0));
        assertTrue(FaultyProblem4.areEqual(500, 500));

        // Защо са верни горните, а този тест
        // фейлва? ^^^
        assertTrue(FaultyProblem4.areEqual(new Integer(511), (Integer) 511));
    }

    @Test
    public void testSubstringEquality() throws Exception {
        String a = "how do you do";
        String b = "how do you do";

        assertTrue(FaultyProblem4.haveEqualSubstrings(a, b));

        a = "Bearded Man";
        b = "Non-bearded Man";
        assertFalse(FaultyProblem4.haveEqualSubstrings(a, b));

        a = "Speaks";
        b = "Freaky";
        assertFalse(FaultyProblem4.haveEqualSubstrings(a, b));
    }

}
