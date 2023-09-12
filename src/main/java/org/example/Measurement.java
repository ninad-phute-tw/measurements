package org.example;

public class Measurement {

    private final int value;

    private final String unit;

    public Measurement(int value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean equals(Measurement measurement) {
        return this.getValue() == measurement.getValue()
                && this.getUnit().equals(measurement.getUnit());
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
}