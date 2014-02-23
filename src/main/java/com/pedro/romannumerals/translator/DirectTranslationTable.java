package com.pedro.romannumerals.translator;

import java.util.Set;

/**
 * Class created to represent a translation table. This entity contains a set of direct translations and use it to
 * translate from one value to other.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class DirectTranslationTable {

    /*
     * Attributes
     */

    private Set<DirectTranslation> directTranslations;

    /*
     * Constructor
     */

    DirectTranslationTable(Set<DirectTranslation> directTranslations) {
        this.directTranslations = directTranslations;
    }

    /*
     * Public methods
     */

    String getTranslationFor(String textToTranslate) {
        return searchTranslation(textToTranslate);
    }


    boolean existsTranslationFor(String textToTranslate) {
        return !searchTranslation(textToTranslate).isEmpty();
    }


    /*
     * Auxiliary methods
     */

    private String searchTranslation(String textToTranslate) {
        String res = "";
        for (DirectTranslation translation : directTranslations) {
            if (translation.getFromValue().equals(textToTranslate)) {
                res = translation.getToValue();
                break;
            }
        }
        return res;
    }

}
