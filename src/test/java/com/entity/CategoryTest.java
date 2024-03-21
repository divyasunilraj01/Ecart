package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoryTest {

    private category Category;

    @Before
    public void setUp() {
        // Initialize a Category object for testing
        Category = new category();
        Category.setCid(1);
        Category.setCname("Electronics");
    }

    @Test
    public void testGetCid() {
        assertEquals(1, Category.getCid());
    }

    @Test
    public void testSetCid() {
        Category.setCid(2);
        assertEquals(2, Category.getCid());
    }

    @Test
    public void testGetCname() {
        assertEquals("Electronics", Category.getCname());
    }

    @Test
    public void testSetCname() {
        Category.setCname("Clothing");
        assertEquals("Clothing", Category.getCname());
    }
}
