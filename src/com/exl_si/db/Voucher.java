package com.exl_si.db;

import java.util.Date;

public class Voucher {
    private String id;

    private String voucherTitle;

    private String merchantId;

    private String voucherType;

    private Date createtime;

    private Date startDate;

    private Date endDate;

    private String endTime;

    private String startTime;

    private Date updateTime;

    private Integer quantity;

    private String csphone;

    private String geographic;

    private String address;

    private Integer isOnline;

    private String instagram;

    private String facebook;

    private String map;

    private Integer status;

    private String tnc;

    private String description;

    private String reminder;

    private String remark;

    private String rejectReason;

    public Voucher(String id, String voucherTitle, String merchantId, String voucherType, Date createtime, Date startDate, Date endDate, String endTime, String startTime, Date updateTime, Integer quantity, String csphone, String geographic, String address, Integer isOnline, String instagram, String facebook, String map, Integer status, String tnc, String description, String reminder, String remark, String rejectReason) {
        this.id = id;
        this.voucherTitle = voucherTitle;
        this.merchantId = merchantId;
        this.voucherType = voucherType;
        this.createtime = createtime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.endTime = endTime;
        this.startTime = startTime;
        this.updateTime = updateTime;
        this.quantity = quantity;
        this.csphone = csphone;
        this.geographic = geographic;
        this.address = address;
        this.isOnline = isOnline;
        this.instagram = instagram;
        this.facebook = facebook;
        this.map = map;
        this.status = status;
        this.tnc = tnc;
        this.description = description;
        this.reminder = reminder;
        this.remark = remark;
        this.rejectReason = rejectReason;
    }

    public Voucher() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVoucherTitle() {
        return voucherTitle;
    }

    public void setVoucherTitle(String voucherTitle) {
        this.voucherTitle = voucherTitle == null ? null : voucherTitle.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType == null ? null : voucherType.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCsphone() {
        return csphone;
    }

    public void setCsphone(String csphone) {
        this.csphone = csphone == null ? null : csphone.trim();
    }

    public String getGeographic() {
        return geographic;
    }

    public void setGeographic(String geographic) {
        this.geographic = geographic == null ? null : geographic.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram == null ? null : instagram.trim();
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook == null ? null : facebook.trim();
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map == null ? null : map.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTnc() {
        return tnc;
    }

    public void setTnc(String tnc) {
        this.tnc = tnc == null ? null : tnc.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder == null ? null : reminder.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", voucherTitle=").append(voucherTitle);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", voucherType=").append(voucherType);
        sb.append(", createtime=").append(createtime);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", endTime=").append(endTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", quantity=").append(quantity);
        sb.append(", csphone=").append(csphone);
        sb.append(", geographic=").append(geographic);
        sb.append(", address=").append(address);
        sb.append(", isOnline=").append(isOnline);
        sb.append(", instagram=").append(instagram);
        sb.append(", facebook=").append(facebook);
        sb.append(", map=").append(map);
        sb.append(", status=").append(status);
        sb.append(", tnc=").append(tnc);
        sb.append(", description=").append(description);
        sb.append(", reminder=").append(reminder);
        sb.append(", remark=").append(remark);
        sb.append(", rejectReason=").append(rejectReason);
        sb.append("]");
        return sb.toString();
    }
}