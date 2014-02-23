package com.pedro.romannumerals.translator;

/**
 * Translator specialization implemented to create an implementation to accumulatePendingValue. One of the fundamental
 * parts of the recursive algorithm. This class changes his fathers behaviour to, instead of concatenate results, sum
 * the integer value returned.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RomanToArabicTranslator extends Translator {

    public RomanToArabicTranslator(DirectTranslationTable translationTable) {
        super(translationTable);
    }

    @Override
    protected String accumulatePendingValue(String pendingValue, String futureValue) {
        int pending = Integer.parseInt(pendingValue);
        int future = Integer.parseInt(futureValue);
        return (pending+future)+"";
    }
}
