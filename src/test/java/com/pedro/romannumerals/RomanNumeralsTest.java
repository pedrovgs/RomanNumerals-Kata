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
    public void shouldTranslateTheDirectTranslationsROMAN_ARABIC() {
        Map<String, Integer> romanNumbers = getDirectTranslationsRomanArabic();
        for (String romanNumber : romanNumbers.keySet()) {
            Integer arabicTranslation = romanNumerals.fromRomanToArabic(romanNumber);
            Integer expectedTranslation = romanNumbers.get(romanNumber);

            assertEquals(expectedTranslation, arabicTranslation);
        }
    }

    @Test
    public void shouldTransformNotDirectTranslationsROMAN_ARABIC() {
        Map<String, Integer> romanNumbers = getNotDirectTranslationsRomanArabic();
        for (String romanNumber : romanNumbers.keySet()) {
            Integer arabicTranslation = romanNumerals.fromRomanToArabic(romanNumber);
            Integer expectedTranslation = romanNumbers.get(romanNumber);

            assertEquals(expectedTranslation, arabicTranslation);
        }
    }

    @Test
    public void shouldTranslateDirectTranslationsARABIC_ROMAN() {
        Map<Integer, String> arabicNumbers = getDirectTranslationsArabicRoman();
        for (Integer arabicNumber : arabicNumbers.keySet()) {
            String romanTranslation = romanNumerals.fromArabicToRoman(arabicNumber);
            String expectedTranslation = arabicNumbers.get(arabicNumber);

            assertEquals(expectedTranslation, romanTranslation);
        }
    }

    @Test
    public void shouldTranslateNotDirectTranslationARABIC_ROMAN() {
        Map<Integer, String> arabicNumbers = getNotDirectTranslationsArabicRoman();
        for (Integer arabicNumber : arabicNumbers.keySet()) {
            String romanTranslation = romanNumerals.fromArabicToRoman(arabicNumber);
            String expectedTranslation = arabicNumbers.get(arabicNumber);

            assertEquals(expectedTranslation, romanTranslation);
        }
    }

    /*
     * Auxiliary methods
     */

    private void initializeRomanNumerals() {
        romanNumerals = new RomanNumerals();
    }


    private Map<String, Integer> getDirectTranslationsRomanArabic() {
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

    public Map<String, Integer> getNotDirectTranslationsRomanArabic() {
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


    private Map<Integer, String> getDirectTranslationsArabicRoman() {
        Map<Integer, String> directTranslations = new HashMap<Integer, String>();
        directTranslations.put(1, "I");
        directTranslations.put(5, "V");
        directTranslations.put(10, "X");
        directTranslations.put(50, "L");
        directTranslations.put(100, "C");
        directTranslations.put(500, "D");
        directTranslations.put(1000, "M");
        return directTranslations;
    }

    public Map<Integer, String> getNotDirectTranslationsArabicRoman() {
        Map<Integer, String> directTranslations = new HashMap<Integer, String>();
        directTranslations.put(3000, "MMM");
        directTranslations.put(2008, "MMVIII");
        directTranslations.put(78, "LXXVIII");
        directTranslations.put(11, "XI");
        directTranslations.put(20, "XX");
        directTranslations.put(99, "XCIX");
        directTranslations.put(1990, "MCMXC");
        return directTranslations;
    }
}
