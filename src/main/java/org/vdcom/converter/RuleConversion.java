package org.vdcom.converter;


public class RuleConversion {
    private final String source;
    private final String target;
    private final double factor;

    public RuleConversion(String source, String target, double factor) {
        this.source = source;
        this.target = target;
        this.factor = factor;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public double getFactor() {
        return factor;
    }
}

