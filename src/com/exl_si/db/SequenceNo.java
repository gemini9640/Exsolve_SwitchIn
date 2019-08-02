package com.exl_si.db;

public class SequenceNo {
    private Integer simerchanttotal;

    private Integer simembertotal;

    private Integer exlagenttotal;

    private Integer exlclienttotal;

    public SequenceNo(Integer simerchanttotal, Integer simembertotal, Integer exlagenttotal, Integer exlclienttotal) {
        this.simerchanttotal = simerchanttotal;
        this.simembertotal = simembertotal;
        this.exlagenttotal = exlagenttotal;
        this.exlclienttotal = exlclienttotal;
    }

    public SequenceNo() {
        super();
    }

    public Integer getSimerchanttotal() {
        return simerchanttotal;
    }

    public void setSimerchanttotal(Integer simerchanttotal) {
        this.simerchanttotal = simerchanttotal;
    }

    public Integer getSimembertotal() {
        return simembertotal;
    }

    public void setSimembertotal(Integer simembertotal) {
        this.simembertotal = simembertotal;
    }

    public Integer getExlagenttotal() {
        return exlagenttotal;
    }

    public void setExlagenttotal(Integer exlagenttotal) {
        this.exlagenttotal = exlagenttotal;
    }

    public Integer getExlclienttotal() {
        return exlclienttotal;
    }

    public void setExlclienttotal(Integer exlclienttotal) {
        this.exlclienttotal = exlclienttotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", simerchanttotal=").append(simerchanttotal);
        sb.append(", simembertotal=").append(simembertotal);
        sb.append(", exlagenttotal=").append(exlagenttotal);
        sb.append(", exlclienttotal=").append(exlclienttotal);
        sb.append("]");
        return sb.toString();
    }
}