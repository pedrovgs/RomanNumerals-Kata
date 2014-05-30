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

import java.util.Set;

/**
 * Class created to represent a translation table. This entity contains a set of direct translations and use it to
 * translate from one value to other.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class DirectTranslationTable {

    private Set<DirectTranslation> directTranslations;

    DirectTranslationTable(Set<DirectTranslation> directTranslations) {
        this.directTranslations = directTranslations;
    }

    String getTranslationFor(String textToTranslate) {
        return searchTranslation(textToTranslate);
    }


    boolean existsTranslationFor(String textToTranslate) {
        return !searchTranslation(textToTranslate).isEmpty();
    }

    Set<DirectTranslation> getDirectTranslations() {
        return directTranslations;
    }

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
