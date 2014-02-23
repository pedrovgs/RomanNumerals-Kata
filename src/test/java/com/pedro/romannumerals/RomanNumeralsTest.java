package com.pedro.romannumerals;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test class created to check the correct behaviour of RomanNumerals. This test contain integration test methods that
 * checks all the application is working and translating properly from one languaje to other.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RomanNumeralsTest {

    /*
     * Constants
     */

    /*
     * Test data
     */

    private RomanNumerals romanNumerals;

    /*
     * Before and after methods
     */

    @Before
    public void setUp() {
        initializeRomanNumerals();
    }

    /*
     * Test methods
     */

    @Test
    public void shouldTranslateTheDirectTranslations() {
        Map<String, Integer> romanNumbers = getDirectTranslations();
        for (String romanNumber : romanNumbers.keySet()) {
            Integer arabicTranslation = romanNumerals.fromRomanToArabic(romanNumber);
            Integer expectedTranslation = romanNumbers.get(romanNumber);

            assertEquals(expectedTranslation, arabicTranslation);
        }
    }

    @Test
    public void shouldTransformNotDirectTranslations() {
        Map<String, Integer> romanNumbers = getNotDirectTranslations();
        for (String romanNumber : romanNumbers.keySet()) {
            Integer arabicTranslation = romanNumerals.fromRomanToArabic(romanNumber);
            Integer expectedTranslation = romanNumbers.get(romanNumber);

            assertEquals(expectedTranslation, arabicTranslation);
        }
    }

    /*
     * Auxiliary methods
     */

    private void initializeRomanNumerals() {
        romanNumerals = new RomanNumerals();
    }


    private Map<String, Integer> getDirectTranslations() {
        Map<String, Integer> directTranslations = new HashMap<String, Integer>();
        directTranslations.put("I", 1);
        directTranslations.put("V", 5);
        directTranslations.put("X", 10);
        directTranslations.put("L", 50);
        directTranslations.put("C", 100);
        directTranslations.put("D", 500);
        directTranslations.put("M", 1000);
        return directTranslations;
    }

    public Map<String, Integer> getNotDirectTranslations() {
        Map<String, Integer> directTranslations = new HashMap<String, Integer>();
        directTranslations.put("MMM", 3000);
        directTranslations.put("MMVIII", 2008);
        directTranslations.put("LXXVIII", 78);
        directTranslations.put("XI", 11);
        directTranslations.put("XX", 20);
        directTranslations.put("XCIX", 99);
        directTranslations.put("MCMXC", 1990);
        return directTranslations;
    }
}
