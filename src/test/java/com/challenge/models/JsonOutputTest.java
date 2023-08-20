package com.challenge.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

public class JsonOutputTest {

    @Test
    public void testConstructor() {
        JsonOutput jsonOutput = new JsonOutput(new ArrayList<>());
        assertEquals(0, jsonOutput.getUsers().size());
    }

    @Test
    public void testSetters() {
        JsonOutput jsonOutput = new JsonOutput();
        jsonOutput.setUsers(new ArrayList<>());
        assertEquals(0, jsonOutput.getUsers().size());
    }

    @Test
    public void testEquals() {
        JsonOutput jsonOutput1 = new JsonOutput(new ArrayList<>());
        JsonOutput jsonOutput2 = new JsonOutput(new ArrayList<>());
        Object object = new Object();

        assertEquals(jsonOutput1, jsonOutput2);
        assertEquals(jsonOutput1, jsonOutput1);
        assertNotEquals(jsonOutput1, object);
    }

    @Test
    public void testHashCode() {
        JsonOutput jsonOutput1 = new JsonOutput(new ArrayList<>());
        JsonOutput jsonOutput2 = new JsonOutput(new ArrayList<>());

        assertEquals(jsonOutput1.hashCode(), jsonOutput2.hashCode());
    }
}
