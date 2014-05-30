/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

    private RomanNumerals romanNumerals;

    @Before
    public void setUp() {
        initializeRomanNumerals();
    }

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

    @Test
    public void usingConnectingTranslatrsWithTheSameValuesShouldReturnsEquivalentTranslations() {
        for (int i = 1; i <= 3000; i++) {
            String romanTranslation = romanNumerals.fromArabicToRoman(i);
            int arabicTranslation = romanNumerals.fromRomanToArabic(romanTranslation);

            assertEquals(i, arabicTranslation);
        }
    }

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

    private Map<String, Integer> getNotDirectTranslationsRomanArabic() {
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

    private Map<Integer, String> getNotDirectTranslationsArabicRoman() {
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
