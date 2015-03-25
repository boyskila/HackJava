package com.hackbulgaria.corejava1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hackbulgaria.corejava.FaultyProblem5;

public class FaultyProblem5Test {

    @Test
    public void test() {
        assertEquals(1, FaultyProblem5.kthFac(0, 1));
        
        assertEquals(2, FaultyProblem5.kthFac(1, 2));
        
        assertEquals(720, FaultyProblem5.kthFac(2, 3));
    }

}
