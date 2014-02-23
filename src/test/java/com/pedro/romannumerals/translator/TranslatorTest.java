package com.pedro.romannumerals.translator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test created to check the correctness of Translator
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class TranslatorTest {

    /*
     * Constants
     */

    private static final String EMPTY_RESULT = "";
    private static final String DIRECT_TRANSLATION_INPUT = "a";
    private static final String DIRECT_TRANSLATION_OUTPUT = "1";
    protected static final String TEXT_TO_TRANSLATE = "t_t";
    private static final String TEXT_TO_TRANSLATE_TRANSLATION ="12";

    /*
     * Test data
     */

    protected Translator translator;

    /*
     * Mocks
     */

    @Mock
    protected DirectTranslationTable mockedTranslationTable;

    /*
     * Before and after methods
     */

    @Before
    public void setUp() {
        initializeMocks();
        initializeTranslator();
    }


    /*
     * Test methods
     */

    @Test
    public void shouldReturnAnEmptyResult() {
        assertEquals(EMPTY_RESULT, translator.translate(""));
    }

    @Test
    public void shouldReturnTheDirectTranslation(){
        when(mockedTranslationTable.existsTranslationFor(DIRECT_TRANSLATION_INPUT)).thenReturn(true);
        when(mockedTranslationTable.getTranslationFor(DIRECT_TRANSLATION_INPUT)).thenReturn(DIRECT_TRANSLATION_OUTPUT);

        assertEquals(DIRECT_TRANSLATION_OUTPUT,translator.translate(DIRECT_TRANSLATION_INPUT));
    }

    @Test
    public void shouldIterateOneTimeAndAplyRecursivity(){
        when(mockedTranslationTable.existsTranslationFor(TEXT_TO_TRANSLATE)).thenReturn(false);
        when(mockedTranslationTable.existsTranslationFor("t_")).thenReturn(true);
        when(mockedTranslationTable.getTranslationFor("t_")).thenReturn("1");
        when(mockedTranslationTable.existsTranslationFor("t")).thenReturn(true);
        when(mockedTranslationTable.getTranslationFor("t")).thenReturn("2");

        assertEquals(TEXT_TO_TRANSLATE_TRANSLATION, translator.translate(TEXT_TO_TRANSLATE));
    }

    /*
     * Auxiliary methods
     */


    private void initializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    protected void initializeTranslator() {
        translator = new Translator(mockedTranslationTable);
    }

}
