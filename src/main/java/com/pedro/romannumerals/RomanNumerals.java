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

import com.pedro.romannumerals.translator.Translator;
import com.pedro.romannumerals.translator.TranslatorFactory;

/**
 * Main class of the RomanNumerals application. This application translate numbers from the roman format to the arabic
 * format using a recursive algorithm implemented in Translator and RomanToArabicTranslator classes.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RomanNumerals {

    private Translator romanToArabicTranslator;
    private Translator arabicToRomanTranslator;

    public RomanNumerals() {
        this.romanToArabicTranslator = TranslatorFactory.getRomanToArabicTranslator();
        this.arabicToRomanTranslator = TranslatorFactory.getArabicToRomanTranslator();
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

    /**
     * Translate a number from the arabic format to the roman format.
     *
     * @param arabicNumber to translate
     * @return the translated version of the arabic number in roman format.
     */
    public String fromArabicToRoman(Integer arabicNumber) {
        return arabicToRomanTranslator.translate(arabicNumber + "");
    }
}
