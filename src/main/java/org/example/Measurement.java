package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Measurement {

    private final Map<UnitPair, Double> conversionMap = new HashMap<>();

    private final double value;

    private final String unit;

    public Measurement(double value, String unit) {
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
        if (obj instanceof Measurement) {
            Measurement measurement = (Measurement) obj;
            UnitPair pair = new UnitPair(measurement.getUnit(), this.unit);
            return this.getValue() ==
                    measurement.getValue() * conversionMap.get(pair);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public boolean same(Measurement measurement) {
        return this == measurement;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return unit;
    }

    public Measurement add(Measurement measurement) {
        UnitPair pair = new UnitPair(measurement.getUnit(), this.getUnit());
        double result = this.getValue()
                + measurement.getValue() * conversionMap.get(pair);
        return new Measurement(result, this.getUnit());
    }
}