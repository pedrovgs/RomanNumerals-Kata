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
package com.pedro.romannumerals.translator;

/**
 * Class created to work as translators factory. This entity will provide the client code different translators.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public final class TranslatorFactory {

    private TranslatorFactory() {
    }

    private static RomanToArabicDirectTranslationTable romanToArabicDirectTranslationTable = new RomanToArabicDirectTranslationTable();
    private static ArabicToRomanTranslationTable arabicToRomanTranslationTable = new ArabicToRomanTranslationTable();

    public static Translator getRomanToArabicTranslator() {
        return new RomanToArabicTranslator(romanToArabicDirectTranslationTable);
    }

    public static Translator getArabicToRomanTranslator() {
        return new ArabicToRomanTranslator(arabicToRomanTranslationTable);
    }
}
