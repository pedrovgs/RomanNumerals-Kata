package com.pedro.romannumerals.translator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Direct translation table created to contains all the basic translations between arabic and roman format.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class ArabicToRomanTranslationTable extends DirectTranslationTable {

    ArabicToRomanTranslationTable() {
        this(new LinkedHashSet<DirectTranslation>());
    }

    ArabicToRomanTranslationTable(Set<DirectTranslation> directTranslations) {
        super(directTranslations);
        initializeDirectTranslationsTrable(directTranslations);
    }

    /*
     * Auxiliary methods
     */

    private void initializeDirectTranslationsTrable(Set<DirectTranslation> directTranslations) {

        directTranslations.add(new DirectTranslation("1000", "M"));
        directTranslations.add(new DirectTranslation("900", "CM"));
        directTranslations.add(new DirectTranslation("500", "D"));
        directTranslations.add(new DirectTranslation("100", "C"));
        directTranslations.add(new DirectTranslation("90", "XC"));
        directTranslations.add(new DirectTranslation("50", "L"));
        directTranslations.add(new DirectTranslation("10", "X"));
        directTranslations.add(new DirectTranslation("9", "IX"));
        directTranslations.add(new DirectTranslation("5", "V"));
        directTranslations.add(new DirectTranslation("1", "I"));
    }


    int getBetterTranslation(String arabicNumber) {
        int number = Integer.parseInt(arabicNumber);
        for (DirectTranslation translation : directTranslations) {
            if (number - Integer.parseInt(translation.getFromValue()) >= 0) {
                return Integer.parseInt(translation.getFromValue());
            }
        }
        return 0;
    }

}
