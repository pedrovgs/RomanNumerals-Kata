package com.pedro.romannumerals;

import com.pedro.romannumerals.translator.Translator;
import com.pedro.romannumerals.translator.TranslatorFactory;

/**
 * Main class of the RomanNumerals application. This application translate numbers from the roman format to the arabic
 * format using a recursive algorithm implemented in Translator and RomanToArabicTranslator classes.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RomanNumerals {

    /*
     * Attributes
     */

    private Translator romanToArabicTranslator;


    /*
     * Public constructor
     */

    public RomanNumerals() {
        this.romanToArabicTranslator = TranslatorFactory.getRomanToArabicTranslator();
    }


    /**
     * Translate a number from the roman format to the arabic format.
     *
     * @param romanNumber to translate.
     * @return the translated version of the roman number in arabic format.
     */
    public int fromRomanToArabic(final String romanNumber) {
        String translationResult = romanToArabicTranslator.translate(romanNumber);
        return Integer.parseInt(translationResult);
    }


}
