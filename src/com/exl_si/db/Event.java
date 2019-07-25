package com.exl_si.db;

import java.math.BigDecimal;
import java.util.Date;

public class Event {
    private Integer id;

    private String eventname;

    private String merchantname;

    private Date createtime;

    private Date startdate;

    private Date enddate;

    private String tagline;

    private BigDecimal price;

    private Date updatetime;

    private String csphone;

    private String location;

    private String address;

    private String map;

    private Integer maxpax;

    private Integer maxpaxperregister;

    private Integer status;

    private String comment;

    private String description;

    private String reminder;

    private String remark;

    public Event(Integer id, String eventname, String merchantname, Date createtime, Date startdate, Date enddate, String tagline, BigDecimal price, Date updatetime, String csphone, String location, String address, String map, Integer maxpax, Integer maxpaxperregister, Integer status, String comment, String description, String reminder, String remark) {
        this.id = id;
        this.eventname = eventname;
        this.merchantname = merchantname;
        this.createtime = createtime;
        this.startdate = startdate;
        this.enddate = enddate;
        this.tagline = tagline;
        this.price = price;
        this.updatetime = updatetime;
        this.csphone = csphone;
        this.location = location;
        this.address = address;
        this.map = map;
        this.maxpax = maxpax;
        this.maxpaxperregister = maxpaxperregister;
        this.status = status;
        this.comment = comment;
        this.description = description;
        this.reminder = reminder;
        this.remark = remark;
    }

    public Event() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname == null ? null : eventname.trim();
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname == null ? null : merchantname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline == null ? null : tagline.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCsphone() {
        return csphone;
    }

    public void setCsphone(String csphone) {
        this.csphone = csphone == null ? null : csphone.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map == null ? null : map.trim();
    }

    public Integer getMaxpax() {
        return maxpax;
    }

    public void setMaxpax(Integer maxpax) {
        this.maxpax = maxpax;
    }

    public Integer getMaxpaxperregister() {
        return maxpaxperregister;
    }

    public void setMaxpaxperregister(Integer maxpaxperregister) {
        this.maxpaxperregister = maxpaxperregister;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eventname=").append(eventname);
        sb.append(", merchantname=").append(merchantname);
        sb.append(", createtime=").append(createtime);
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", tagline=").append(tagline);
        sb.append(", price=").append(price);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", csphone=").append(csphone);
        sb.append(", location=").append(location);
        sb.append(", address=").append(address);
        sb.append(", map=").append(map);
        sb.append(", maxpax=").append(maxpax);
        sb.append(", maxpaxperregister=").append(maxpaxperregister);
        sb.append(", status=").append(status);
        sb.append(", comment=").append(comment);
        sb.append(", description=").append(description);
        sb.append(", reminder=").append(reminder);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}