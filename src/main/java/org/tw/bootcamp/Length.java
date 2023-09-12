package org.tw.bootcamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Length {

    private final Map<UnitPair, Double> conversionMap = new HashMap<>();

    private final double value;

    private final String unit;

    public Length(double value, String unit) {
        prepareMap();
        this.value = value;
        this.unit = unit;
    }

    private void prepareMap() {
        conversionMap.put(new UnitPair("M", "CM"), 100.0);
        conversionMap.put(new UnitPair("CM", "M"), 0.01);
        conversionMap.put(new UnitPair("CM", "CM"), 1.0);
        conversionMap.put(new UnitPair("M", "M"), 1.0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Length) {
            Length length = (Length) obj;
            UnitPair pair = new UnitPair(length.getUnit(), this.unit);
            return this.getValue() ==
                    length.getValue() * conversionMap.get(pair);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public boolean same(Length length) {
        return this == length;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return unit;
    }

    public Length add(Length length) {
        UnitPair pair = new UnitPair(length.getUnit(), this.getUnit());
        double result = this.getValue()
                + length.getValue() * conversionMap.get(pair);
        return new Length(result, this.getUnit());
    }
}