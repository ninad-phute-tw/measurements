package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Test
    public void shouldBeEqualForTwoSeparateOneCmReadings() {
        final int value = 1;
        final String unit = "CM";
        final Measurement measurement1 = new Measurement(value, unit);
        final Measurement measurement2 = new Measurement(value, unit);

        boolean result = measurement1.equals(measurement2);

        assertTrue(result);
    }

    @Test
    public void shouldBeTrueForSameReading() {
        final int value = 1;
        final String unit = "CM";
        final Measurement measurement = new Measurement(value, unit);

        boolean result = measurement.same(measurement);

        assertTrue(result);
    }

    @Test
    public void shouldFailForDifferentReading() {
        final int value1 = 1;
        final int value2 = 3;
        final String unit = "CM";
        final Measurement measurement1 = new Measurement(value1, unit);
        final Measurement measurement2 = new Measurement(value2, unit);

        boolean result = measurement1.equals(measurement2);

        assertFalse(result);
    }
}