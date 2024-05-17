package org.feefo.jobtitles;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class NormalizerTest {

    private Normalizer normalizer;

    @BeforeEach
    public void setUp() {
         normalizer = new Normalizer(Arrays.asList( "Software Engineer", "Quantity Surveyor", "Accountant"));

    }
    @Test
    @DisplayName("Should return 'Software Engineer' for job titles containing 'Engineer'")
    void testNormalizeEngineerTitles() {


        assertEquals("Software Engineer", normalizer.normalize("Java Engineer"));
        assertEquals("Software Engineer", normalizer.normalize("C# Engineer"));
    }
    @Test
    @DisplayName("Should return 'Accountant' for variations of 'Accountant'")
    void testNormalizeAccountantTitles() {

        assertEquals("Accountant", normalizer.normalize("Accountant"));
        assertEquals("Accountant", normalizer.normalize("Chief Accountant"));
    }
    @Test
    @DisplayName("Should return the input if it matches a normalized title exactly")
    void testNormalizeExactMatches() {


        assertEquals("Quantity Surveyor", normalizer.normalize("Quantity Surveyor"));
        assertEquals("Software Engineer", normalizer.normalize("Software Engineer"));
    }
    @Test
    @DisplayName("Should return null if no match is found")
    void testNormalizeNoMatch() {


        assertEquals("has no title found", normalizer.normalize("Doctor"));
        assertEquals("has no title found", normalizer.normalize("Lawyer"));
    }

    @Test
    @DisplayName("Should handle empty input gracefully")
    void testNormalizeEmptyInput() {

        assertEquals("has no title found", normalizer.normalize(""));
    }
}
