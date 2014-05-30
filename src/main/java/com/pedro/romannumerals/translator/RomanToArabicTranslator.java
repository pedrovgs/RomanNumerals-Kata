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

/**
 * Translator implementation to translate numbers from Roman format to arabic format. This implementation it's based in
 * a recursive algorithm that evaluate char by char the possible direct translations and gets the final translation like
 * the concatenation of the partial solutions.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class RomanToArabicTranslator implements Translator {

    private DirectTranslationTable translationTable;

    public RomanToArabicTranslator(DirectTranslationTable translationTable) {
        this.translationTable = translationTable;
    }

    public String translate(String textToTranslate) {
        return recursiveTranslation(textToTranslate);
    }

    private String recursiveTranslation(String textToTranslate) {
        //Empty case of the recursive algorithm
        if (textToTranslate.isEmpty()) {
            return "";
        }

        //Base case of the recursive algorithm
        if (existDirectTranslationFor(textToTranslate)) {
            return getDirectTranslationFor(textToTranslate);
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
        return twoCharResult.isEmpty() ? oneCharResult : twoCharResult;
    }

    private boolean existDirectTranslationFor(String textToTranslate) {
        return translationTable.existsTranslationFor(textToTranslate);
    }

    private String accumulatePendingValue(String pendingValue, String futureValue) {
        int pending = Integer.parseInt(pendingValue);
        int future = Integer.parseInt(futureValue);
        return (pending + future) + "";
    }
}
