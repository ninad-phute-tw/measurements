package org.tw.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    public void shouldBeEqualForTwoSeparateOneCmReadings() {
        final double value = 1;
        final String unit = "CM";
        final Length length1 = new Length(value, unit);
        final Length length2 = new Length(value, unit);

        assertEquals(length1, length2);
    }

    @Test
    public void shouldBeTrueForSameReading() {
        final double value = 1;
        final String unit = "CM";
        final Length length1 = new Length(value, unit);
        final Length length2 = length1;

        boolean result = length1.same(length2);

        assertTrue(result);
    }

    @Test
    public void shouldFailEqualityCheckForDifferentReading() {
        final double value1 = 1;
        final double value2 = 3;
        final String unit = "CM";
        final Length length1 = new Length(value1, unit);
        final Length length2 = new Length(value2, unit);

        assertNotEquals(length1, length2);
    }

    @Test
    public void shouldFailSimilarityCheckForDifferentReading() {
        final double value1 = 1;
        final double value2 = 3;
        final String unit = "CM";
        final Length length1 = new Length(value1, unit);
        final Length length2 = new Length(value2, unit);

        boolean result = length1.same(length2);

        assertFalse(result);
    }

    @Test
    public void shouldEvaluateToTrueFor1mEqualTo100cm() {
        final double value1 = 1;
        final String unit1 = "M";
        final double value2 = 100;
        final String unit2 = "CM";
        final Length length1 = new Length(value1, unit1);
        final Length length2 = new Length(value2, unit2);

        assertEquals(length1, length2);
    }

    @Test
    public void shouldEvaluateToTrueFor100cmEqualTo1m() {
        final double value1 = 100;
        final String unit1 = "CM";
        final double value2 = 1;
        final String unit2 = "M";
        final Length length1 = new Length(value1, unit1);
        final Length length2 = new Length(value2, unit2);

        assertEquals(length1, length2);
    }

    @Test
    public void shouldEvaluateToFalseFor1mEqualTo10cm() {
        final double value1 = 1;
        final String unit1 = "M";
        final double value2 = 10;
        final String unit2 = "CM";
        final Length length1 = new Length(value1, unit1);
        final Length length2 = new Length(value2, unit2);

        assertNotEquals(length1, length2);
    }

    @Test
    public void shouldEvaluateToFalseFor10cmEqualTo1m() {
        final double value1 = 10;
        final String unit1 = "CM";
        final double value2 = 1;
        final String unit2 = "M";
        final Length length1 = new Length(value1, unit1);
        final Length length2 = new Length(value2, unit2);

        assertNotEquals(length1, length2);
    }

    @Test
    public void shouldEvaluate1mPlus100cmTo2m() {
        final double value1 = 1;
        final String unit1 = "M";
        final double value2 = 100;
        final String unit2 = "CM";
        final Length length1 = new Length(value1, unit1);
        final Length length2 = new Length(value2, unit2);
        final double expectedValue = 2;
        final String expectedUnit = "M";
        final Length expectedLength = new Length(expectedValue, expectedUnit);

        assertEquals(expectedLength, length1.add(length2));
    }

    @Test
    public void shouldEvaluate200cmPlus1mTo300cm() {
        final double value1 = 200;
        final String unit1 = "CM";
        final double value2 = 1;
        final String unit2 = "M";
        final Length length1 = new Length(value1, unit1);
        final Length length2 = new Length(value2, unit2);
        final double expectedValue = 300;
        final String expectedUnit = "CM";
        final Length expectedLength = new Length(expectedValue, expectedUnit);

        assertEquals(expectedLength, length1.add(length2));
    }
}