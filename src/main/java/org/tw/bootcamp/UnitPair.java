package org.tw.bootcamp;

import java.util.Objects;

public class UnitPair {
    private final String from;
    private final String to;

    public UnitPair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitPair unitPair = (UnitPair) o;
        return Objects.equals(from, unitPair.from) && Objects.equals(to, unitPair.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
