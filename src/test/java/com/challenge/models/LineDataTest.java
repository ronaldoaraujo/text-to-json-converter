package com.challenge.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class LineDataTest {
    private LocalDate currentDate;

    @Before
    public void setUp() {
        currentDate = LocalDate.now();
    }

    @Test
    public void testConstructor() {
        LineData lineData = new LineData(1, "Test", 1, 1, 10.0, currentDate);

        assertEquals(1, lineData.getUserId());
        assertEquals("Test", lineData.getUserName());
        assertEquals(1, lineData.getOrderId());
        assertEquals(1, lineData.getProductId());
        assertEquals(10.0, lineData.getProductValue(), 0.0);
        assertEquals(currentDate, lineData.getOrderDate());
    }

    @Test
    public void testSetters() {
        LineData lineData = new LineData();

        lineData.setUserId(1);
        lineData.setUserName("Test");
        lineData.setOrderId(1);
        lineData.setProductId(1);
        lineData.setProductValue(10.0);
        lineData.setOrderDate(currentDate);

        assertEquals(1, lineData.getUserId());
        assertEquals("Test", lineData.getUserName());
        assertEquals(1, lineData.getOrderId());
        assertEquals(1, lineData.getProductId());
        assertEquals(10.0, lineData.getProductValue(), 0.0);
        assertEquals(currentDate, lineData.getOrderDate());
    }

    @Test
    public void testEquals() {
        LineData lineData1 = new LineData(1, "Test", 1, 1, 10.0, currentDate);
        LineData lineData2 = new LineData(1, "Test", 1, 1, 10.0, currentDate);
        LineData lineData3 = new LineData(2, "Other", 1, 1, 12.0, currentDate);

        assertEquals(lineData1, lineData1);
        assertEquals(lineData1, lineData2);
        assertNotEquals(lineData1, lineData3);
        assertNotEquals(lineData1, null);
        assertNotEquals(lineData1, new Object());
    }

    @Test
    public void testHashCode() {
        LineData lineData1 = new LineData(1, "Test", 1, 1, 10.0, currentDate);
        LineData lineData2 = new LineData(1, "Test", 1, 1, 10.0, currentDate);

        assertEquals(lineData1.hashCode(), lineData2.hashCode());
    }
}
