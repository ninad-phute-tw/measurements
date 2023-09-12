package org.example;

import java.util.Objects;

public class Measurement {

    private final int value;

    private final String unit;

    public Measurement(int value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Measurement) {
            Measurement measurement = (Measurement) obj;
            return this.getCentimeterValue() == measurement.getCentimeterValue();
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

    public int getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public int getCentimeterValue() {
        if (this.getUnit().equals("M")) {
            return this.getValue() * 100;
        }
        return this.getValue();
    }
}