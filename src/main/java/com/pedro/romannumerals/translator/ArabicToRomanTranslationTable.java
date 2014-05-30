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
        for (DirectTranslation translation : getDirectTranslations()) {
            if (number - Integer.parseInt(translation.getFromValue()) >= 0) {
                return Integer.parseInt(translation.getFromValue());
            }
        }
        return 0;
    }

}
