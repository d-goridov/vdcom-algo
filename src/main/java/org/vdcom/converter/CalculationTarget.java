package org.vdcom.converter;

public class CalculationTarget {
    private final double sourceValue;
    private final String sourceUnit;
    private final String targetUnit;

    public CalculationTarget(double sourceValue, String sourceUnit, String targetUnit) {
        this.sourceValue = sourceValue;
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }

    @Override
    public String toString() {
        return sourceValue + " " + sourceUnit + " = ? " + targetUnit;
    }
}
