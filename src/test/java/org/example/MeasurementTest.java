package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Test
    public void shouldBeEqualForTwoSeparateOneCmReadings() {
        final double value = 1;
        final String unit = "CM";
        final Measurement measurement1 = new Measurement(value, unit);
        final Measurement measurement2 = new Measurement(value, unit);

        assertEquals(measurement1, measurement2);
    }

    @Test
    public void shouldBeTrueForSameReading() {
        final double value = 1;
        final String unit = "CM";
        final Measurement measurement1 = new Measurement(value, unit);
        final Measurement measurement2 = measurement1;

        boolean result = measurement1.same(measurement2);

        assertTrue(result);
    }

    @Test
    public void shouldFailEqualityCheckForDifferentReading() {
        final double value1 = 1;
        final double value2 = 3;
        final String unit = "CM";
        final Measurement measurement1 = new Measurement(value1, unit);
        final Measurement measurement2 = new Measurement(value2, unit);

        assertNotEquals(measurement1, measurement2);
    }

    @Test
    public void shouldFailSimilarityCheckForDifferentReading() {
        final double value1 = 1;
        final double value2 = 3;
        final String unit = "CM";
        final Measurement measurement1 = new Measurement(value1, unit);
        final Measurement measurement2 = new Measurement(value2, unit);

        boolean result = measurement1.same(measurement2);

        assertFalse(result);
    }

    @Test
    public void shouldEvaluateToTrueFor1mEqualTo100cm() {
        final double value1 = 1;
        final String unit1 = "M";
        final double value2 = 100;
        final String unit2 = "CM";
        final Measurement measurement1 = new Measurement(value1, unit1);
        final Measurement measurement2 = new Measurement(value2, unit2);

        assertEquals(measurement1, measurement2);
    }

    @Test
    public void shouldEvaluateToTrueFor100cmEqualTo1m() {
        final double value1 = 100;
        final String unit1 = "CM";
        final double value2 = 1;
        final String unit2 = "M";
        final Measurement measurement1 = new Measurement(value1, unit1);
        final Measurement measurement2 = new Measurement(value2, unit2);

        assertEquals(measurement1, measurement2);
    }

    @Test
    public void shouldEvaluateToFalseFor1mEqualTo10cm() {
        final double value1 = 1;
        final String unit1 = "M";
        final double value2 = 10;
        final String unit2 = "CM";
        final Measurement measurement1 = new Measurement(value1, unit1);
        final Measurement measurement2 = new Measurement(value2, unit2);

        assertNotEquals(measurement1, measurement2);
    }

    @Test
    public void shouldEvaluateToFalseFor10cmEqualTo1m() {
        final double value1 = 10;
        final String unit1 = "CM";
        final double value2 = 1;
        final String unit2 = "M";
        final Measurement measurement1 = new Measurement(value1, unit1);
        final Measurement measurement2 = new Measurement(value2, unit2);

        assertNotEquals(measurement1, measurement2);
    }

    @Test
    public void shouldEvaluate1mPlus100cmTo2m() {
        final double value1 = 1;
        final String unit1 = "M";
        final double value2 = 100;
        final String unit2 = "CM";
        final Measurement measurement1 = new Measurement(value1, unit1);
        final Measurement measurement2 = new Measurement(value2, unit2);
        final double expectedValue = 2;
        final String expectedUnit = "M";
        final Measurement expectedMeasurement = new Measurement(expectedValue, expectedUnit);

        assertEquals(expectedMeasurement, measurement1.add(measurement2));
    }

    @Test
    public void shouldEvaluate200cmPlus1mTo300cm() {
        final double value1 = 200;
        final String unit1 = "CM";
        final double value2 = 1;
        final String unit2 = "M";
        final Measurement measurement1 = new Measurement(value1, unit1);
        final Measurement measurement2 = new Measurement(value2, unit2);
        final double expectedValue = 300;
        final String expectedUnit = "CM";
        final Measurement expectedMeasurement = new Measurement(expectedValue, expectedUnit);

        assertEquals(expectedMeasurement, measurement1.add(measurement2));
    }
}