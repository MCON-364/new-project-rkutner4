package mcon364.las.touro.edu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testGetUserName() {
        assertFalse(Main.getUserName("USERNAME").isEmpty());
        assertEquals(System.getenv("USERNAME"), Main.getUserName("USERNAME").get());
        assertTrue(Main.getUserName("NULL").isEmpty());
    }

    @Test
    void testGetGreeting() {
        assertEquals("Hello someone", Main.getGreeting("NULL"));
        assertEquals("Hello " + System.getenv("USERNAME"), Main.getGreeting("USERNAME"));
    }

    @Test
    void testProcessValues() {
        List<List<Integer>> data = List.of(
                List.of(5, 10, 15),
                List.of(20, 0, 25),
                List.of(30, 35, 40),
                List.of(45, 99, 50),
                List.of(55, 60, 65)
        );
        assertEquals(8, Main.processValues(data));
    }
}