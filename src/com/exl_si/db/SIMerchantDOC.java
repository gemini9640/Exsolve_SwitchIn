package com.exl_si.db;

public class SIMerchantDOC {
    private String merchantid;

    private String type;

    private Integer index;

    private String url;

    public SIMerchantDOC(String merchantid, String type, Integer index, String url) {
        this.merchantid = merchantid;
        this.type = type;
        this.index = index;
        this.url = url;
    }

    public SIMerchantDOC() {
        super();
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantid=").append(merchantid);
        sb.append(", type=").append(type);
        sb.append(", index=").append(index);
        sb.append(", url=").append(url);
        sb.append("]");
        return sb.toString();
    }
}