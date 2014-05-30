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

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Test created to check the correct behaviour of DirectTranslationTable.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class DirectTranslationTableTest {

    private static final String FROM_VALUE = "a";
    private static final String TO_VALUE = "b";
    private static final String EMPTY_RESULT = "";

    private DirectTranslationTable table;

    private Set<DirectTranslation> translationSet;

    @Before
    public void setUp() {
        initializeTranslationSet();
        initializeDirectTranslationTable();
    }

    @Test
    public void shouldFindTheTranslation() {
        DirectTranslation translation = new DirectTranslation(FROM_VALUE, TO_VALUE);
        translationSet.add(translation);

        assertTrue(table.existsTranslationFor(FROM_VALUE));
        assertEquals(TO_VALUE, table.getTranslationFor(FROM_VALUE));
    }

    @Test
    public void shouldNotFindTheTranslation() {
        DirectTranslation translation = new DirectTranslation(FROM_VALUE, TO_VALUE);
        translationSet.add(translation);

        assertFalse(table.existsTranslationFor(TO_VALUE));
        assertEquals(EMPTY_RESULT, table.getTranslationFor(TO_VALUE));
    }

    private void initializeTranslationSet() {
        translationSet = new LinkedHashSet<DirectTranslation>();
    }

    private void initializeDirectTranslationTable() {
        table = new DirectTranslationTable(translationSet);
    }
}
