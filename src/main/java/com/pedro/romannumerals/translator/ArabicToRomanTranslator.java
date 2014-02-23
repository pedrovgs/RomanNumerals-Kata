package com.pedro.romannumerals.translator;

/**
 * Class created to implement a arabic to roman number format translator. This implementation is based on a recursive
 * algorithm.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class ArabicToRomanTranslator implements Translator {

    /*
     * Attributes
     */
    private ArabicToRomanTranslationTable arabicToRomanDirectTranslationTable;

    /*
     * Constructor
     */

    public ArabicToRomanTranslator(ArabicToRomanTranslationTable arabicToRomanDirectTranslationTable) {
        this.arabicToRomanDirectTranslationTable = arabicToRomanDirectTranslationTable;
    }

    /*
     * Implemented method
     */

    @Override
    public String translate(String textToTranslate) {
        return recursiveTranslation(Integer.parseInt(textToTranslate)) + "";
    }

    /*
     * Auxiliary method
     */

    private String recursiveTranslation(int arabicNumber) {
        if (arabicNumber == 0) {
            return "";
        }
        int betterTranslation = getBetterTranslation(arabicNumber + "");
        String pendingTranslation = getTranslation(betterTranslation);
        return pendingTranslation + recursiveTranslation(arabicNumber - betterTranslation);

    }

    private String getTranslation(int betterTranslation) {
        return arabicToRomanDirectTranslationTable.getTranslationFor(betterTranslation + "");
    }

    private int getBetterTranslation(String arabicNumber) {
        return arabicToRomanDirectTranslationTable.getBetterTranslation(arabicNumber);
    }


}
