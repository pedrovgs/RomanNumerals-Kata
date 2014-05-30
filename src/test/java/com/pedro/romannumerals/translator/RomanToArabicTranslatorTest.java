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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test created to check the correct behaviour of RomanToArabicTranslatorTest
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RomanToArabicTranslatorTest {

    private static final String EMPTY_RESULT = "";
    private static final String DIRECT_TRANSLATION_INPUT = "a";
    private static final String DIRECT_TRANSLATION_OUTPUT = "1";
    private static final String TEXT_TO_TRANSLATE = "t_t";
    private static final String TEXT_TO_TRANSLATE_TRANSLATION = "3";

    private Translator translator;

    @Mock
    private DirectTranslationTable mockedTranslationTable;

    @Before
    public void setUp() {
        initializeMocks();
        initializeTranslator();
    }

    @Test
    public void shouldReturnAnEmptyResult() {
        assertEquals(EMPTY_RESULT, translator.translate(""));
    }

    @Test
    public void shouldReturnTheDirectTranslation() {
        when(mockedTranslationTable.existsTranslationFor(DIRECT_TRANSLATION_INPUT)).thenReturn(true);
        when(mockedTranslationTable.getTranslationFor(DIRECT_TRANSLATION_INPUT)).thenReturn(DIRECT_TRANSLATION_OUTPUT);

        assertEquals(DIRECT_TRANSLATION_OUTPUT, translator.translate(DIRECT_TRANSLATION_INPUT));
    }

    @Test
    public void shouldIterateOneTimeAndAplyRecursivity() {
        when(mockedTranslationTable.existsTranslationFor(TEXT_TO_TRANSLATE)).thenReturn(false);
        when(mockedTranslationTable.existsTranslationFor("t_")).thenReturn(true);
        when(mockedTranslationTable.getTranslationFor("t_")).thenReturn("1");
        when(mockedTranslationTable.existsTranslationFor("t")).thenReturn(true);
        when(mockedTranslationTable.getTranslationFor("t")).thenReturn("2");

        assertEquals(TEXT_TO_TRANSLATE_TRANSLATION, translator.translate(TEXT_TO_TRANSLATE));
    }

    private void initializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    private void initializeTranslator() {
        translator = new RomanToArabicTranslator(mockedTranslationTable);
    }

}
