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
 * Translation table created to contain all the direct translations between the roman and arabic format.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class RomanToArabicDirectTranslationTable extends DirectTranslationTable {

    RomanToArabicDirectTranslationTable() {
        this(new LinkedHashSet<DirectTranslation>());
    }

    RomanToArabicDirectTranslationTable(Set<DirectTranslation> directTranslations) {
        super(directTranslations);
        initializeDirectTranslationsTrable(directTranslations);
    }

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
