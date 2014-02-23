package com.pedro.romannumerals.translator;

/**
 * Class created to represent a direct translation. All the direct translation has the value in two different formats.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class DirectTranslation {

    /*
     * Attributes
     */

    private final String fromValue;
    private final String toValue;

    /*
     * Constructor
     */

    DirectTranslation(String fromValue, String toValue) {
        this.fromValue = fromValue;
        this.toValue = toValue;
    }

    /*
     * Getters and setters
     */

    String getFromValue() {
        return fromValue;
    }

    String getToValue() {
        return toValue;
    }

    /*
     * Equals/hashCode implementation
     */

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
