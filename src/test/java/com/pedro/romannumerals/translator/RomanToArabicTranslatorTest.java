package com.pedro.romannumerals.translator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test created to check the correct behaviour of RomanToArabicTranslatorTest
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RomanToArabicTranslatorTest extends TranslatorTest {

    /*
     * Constants
     */

    private static final String TEXT_TO_TRANSLATE_TRANSLATION = "3";

    /*
     * Override tests
     */

    @Override
    public void shouldIterateOneTimeAndAplyRecursivity() {
        when(mockedTranslationTable.existsTranslationFor(TEXT_TO_TRANSLATE)).thenReturn(false);
        when(mockedTranslationTable.existsTranslationFor("t_")).thenReturn(true);
        when(mockedTranslationTable.getTranslationFor("t_")).thenReturn("1");
        when(mockedTranslationTable.existsTranslationFor("t")).thenReturn(true);
        when(mockedTranslationTable.getTranslationFor("t")).thenReturn("2");

        assertEquals(TEXT_TO_TRANSLATE_TRANSLATION, translator.translate(TEXT_TO_TRANSLATE));

    }

    /*
     * Override methods
     */

    @Override
    protected void initializeTranslator() {
        translator = new RomanToArabicTranslator(mockedTranslationTable);
    }

}
