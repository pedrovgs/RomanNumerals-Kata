package com.pedro.romannumerals.translator;

/**
 * Class created to represent a translator service. This implementation it's based in a recursive algorithm that evaluate
 * char by char the possible direct translations and gets the final translation like the concatenation of the partial
 * solutions.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Translator {


    /*
     * Attributes
     */

    private DirectTranslationTable translationTable;

    /*
     * Constructor
     */

    public Translator(DirectTranslationTable translationTable) {
        this.translationTable = translationTable;
    }

    /*
     * Public methods
     */

    public String translate(String textToTranslate) {
        return recursiveTranslation(textToTranslate);
    }

    /*
     * Auxiliary methods
     */

    private String recursiveTranslation(String textToTranslate) {
        //Empty case of the recursive algorithm
        if (textToTranslate.isEmpty()) {
            return "";
        }

        //Base case of the recursive algorithm
        if (existDirectTranslationFor(textToTranslate)) {
            String directTranslationFound = getDirectTranslationFor(textToTranslate);
            return directTranslationFound;
        }

        String directTranslation = getDirectTranslationFor(textToTranslate);
        String textTranslated = getSubsetToEvaluate(textToTranslate);
        String nextTranslation = textToTranslate.substring(getNextTranslationOffset(textTranslated), textToTranslate.length());
        return accumulatePendingValue(directTranslation, recursiveTranslation(nextTranslation));
    }

    private int getNextTranslationOffset(String textTranslated) {
        int offset = textTranslated.length();
        if (textTranslated.isEmpty()) {
            offset = 2;
        }
        return offset;
    }

    private String getSubsetToEvaluate(String textToTranslate) {
        String subset = "";
        if (textToTranslate.length() >= 2 && translationTable.existsTranslationFor(textToTranslate.substring(0, 2))) {
            subset = textToTranslate.substring(0, 2);
        } else {
            subset = textToTranslate.charAt(0) + "";
        }
        return subset;
    }


    private String getDirectTranslationFor(String textToTranslate) {
        String oneCharResult = translationTable.getTranslationFor(textToTranslate);
        String subsetToEvaluate = getSubsetToEvaluate(textToTranslate);
        String twoCharResult = translationTable.getTranslationFor(subsetToEvaluate);
        String result = twoCharResult.isEmpty() ? oneCharResult : twoCharResult;
        return result;
    }

    private boolean existDirectTranslationFor(String textToTranslate) {
        return translationTable.existsTranslationFor(textToTranslate);
    }

    /*
     * Protected methods
     */

    protected String accumulatePendingValue(String pendingValue, String futureValue) {
        return pendingValue + futureValue;
    }
}
