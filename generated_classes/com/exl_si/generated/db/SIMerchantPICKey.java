package com.exl_si.generated.db;

public class SIMerchantPICKey {
    private String merchantid;

    private String username;

    public SIMerchantPICKey(String merchantid, String username) {
        this.merchantid = merchantid;
        this.username = username;
    }

    public SIMerchantPICKey() {
        super();
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantid=").append(merchantid);
        sb.append(", username=").append(username);
        sb.append("]");
        return sb.toString();
    }
}