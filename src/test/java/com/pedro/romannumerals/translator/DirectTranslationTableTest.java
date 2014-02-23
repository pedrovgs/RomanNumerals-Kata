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

    /*
     * Constants
     */

    private static final String FROM_VALUE = "a";
    private static final String TO_VALUE = "b";
    private static final String EMPTY_RESULT = "";

    /*
     * Test data
     */

    private DirectTranslationTable table;

    private Set<DirectTranslation> translationSet;

    /*
     * After and before methods
     */

    @Before
    public void setUp() {
        initializeTranslationSet();
        initializeDirectTranslationTable();
    }


    /*
     * Test methods
     */

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

    /*
     * Auxiliary methods
     */

    private void initializeTranslationSet() {
        translationSet = new LinkedHashSet<DirectTranslation>();
    }

    private void initializeDirectTranslationTable() {
        table = new DirectTranslationTable(translationSet);
    }
}
