package com.pedro.romannumerals.translator;

/**
 * Class created to work as translators factory. This entity will provide the client code different translators.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class TranslatorFactory {

    private static RomanToArabicDirectTranslationTable romanToArabicDirectTranslationTable = new RomanToArabicDirectTranslationTable();
    private static ArabicToRomanTranslationTable arabicToRomanTranslationTable = new ArabicToRomanTranslationTable();

    public static Translator getRomanToArabicTranslator() {
        return new RomanToArabicTranslator(romanToArabicDirectTranslationTable);
    }

    public static Translator getArabicToRomanTranslator() {
        return new ArabicToRomanTranslator(arabicToRomanTranslationTable);
    }
}
