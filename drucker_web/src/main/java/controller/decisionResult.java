package controller;

public class decisionResult {
       /* private double x1;
    private double x2;
    private double x3;
    private String s1;
    private double x4;
    private double x5;
    private double x6;
    private double x7;
    private double x8;
    private double x9;
    private double x10;
    private String s2;
    private double x11;
    private double x12;
    private double x13;
    private double x14;
    private double x15;
    private double x16;
    private double x17;
    private double x18;*/

    private Double escaltingRate;
    private Double npv;
    private Double irr;
    private Double simplyPaybackPeriod;

    public Double getEscaltingRate() {
        return escaltingRate;
    }

    public Double getNpv() {
        return npv;
    }

    public Double getIrr() {
        return irr;
    }

    public Double getSimplyPaybackPeriod() {
        return simplyPaybackPeriod;
    }

    public void setEscaltingRate(Double escaltingRate) {
        this.escaltingRate = escaltingRate;
    }

    public void setNpv(Double npv) {
        this.npv = npv;
    }

    public void setIrr(Double irr) {
        this.irr = irr;
    }

    public void setSimplyPaybackPeriod(Double simplyPaybackPeriod) {
        this.simplyPaybackPeriod = simplyPaybackPeriod;
    }
}
