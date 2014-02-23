package com.pedro.romannumerals.translator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Translation table created to contain all the direct translations between the roman and arabic format.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class RomanToArabicDirectTranslationTable extends DirectTranslationTable {

    /*
     * Constructor
     */

    RomanToArabicDirectTranslationTable() {
        this(new LinkedHashSet<DirectTranslation>());
    }

    RomanToArabicDirectTranslationTable(Set<DirectTranslation> directTranslations) {
        super(directTranslations);
        initializeDirectTranslationsTrable(directTranslations);
    }

    /*
     * Auxiliary methods
     */

    private void initializeDirectTranslationsTrable(Set<DirectTranslation> directTranslations) {
        directTranslations.add(new DirectTranslation("I", "1"));
        directTranslations.add(new DirectTranslation("V", "5"));
        directTranslations.add(new DirectTranslation("IX", "9"));
        directTranslations.add(new DirectTranslation("X", "10"));
        directTranslations.add(new DirectTranslation("L", "50"));
        directTranslations.add(new DirectTranslation("XC", "90"));
        directTranslations.add(new DirectTranslation("C", "100"));
        directTranslations.add(new DirectTranslation("D", "500"));
        directTranslations.add(new DirectTranslation("CM", "900"));
        directTranslations.add(new DirectTranslation("M", "1000"));
    }
}
