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
 * Class created to represent a direct translation. All the direct translation has the value in two different formats.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class DirectTranslation {

    private final String fromValue;
    private final String toValue;

    DirectTranslation(String fromValue, String toValue) {
        this.fromValue = fromValue;
        this.toValue = toValue;
    }

    String getFromValue() {
        return fromValue;
    }

    String getToValue() {
        return toValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectTranslation)) return false;

        DirectTranslation that = (DirectTranslation) o;

        if (!fromValue.equals(that.fromValue)) return false;
        if (!toValue.equals(that.toValue)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromValue.hashCode();
        result = 31 * result + toValue.hashCode();
        return result;
    }
}
