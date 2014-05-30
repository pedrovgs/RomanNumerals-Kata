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
 * Class created to implement a arabic to roman number format translator. This implementation is based on a recursive
 * algorithm.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class ArabicToRomanTranslator implements Translator {

    private ArabicToRomanTranslationTable arabicToRomanDirectTranslationTable;

    public ArabicToRomanTranslator(ArabicToRomanTranslationTable arabicToRomanDirectTranslationTable) {
        this.arabicToRomanDirectTranslationTable = arabicToRomanDirectTranslationTable;
    }

    @Override
    public String translate(String textToTranslate) {
        return recursiveTranslation(Integer.parseInt(textToTranslate)) + "";
    }

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
