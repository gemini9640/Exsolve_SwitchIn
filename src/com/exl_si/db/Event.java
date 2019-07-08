package com.exl_si.db;

import java.math.BigDecimal;
import java.util.Date;

public class Event {
    private Integer id;

    private String eventname;

    private String merchantname;

    private Date startdate;

    private Date enddate;

    private String tagline;

    private BigDecimal price;

    private Date updatetime;

    private String location;

    private String map;

    private String description;

    private String reminder;

    private String comment;

    private Integer status;

    private String remark;

    public Event(Integer id, String eventname, String merchantname, Date startdate, Date enddate, String tagline, BigDecimal price, Date updatetime, String location, String map, String description, String reminder, String comment, Integer status, String remark) {
        this.id = id;
        this.eventname = eventname;
        this.merchantname = merchantname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.tagline = tagline;
        this.price = price;
        this.updatetime = updatetime;
        this.location = location;
        this.map = map;
        this.description = description;
        this.reminder = reminder;
        this.comment = comment;
        this.status = status;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map == null ? null : map.trim();
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", tagline=").append(tagline);
        sb.append(", price=").append(price);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", location=").append(location);
        sb.append(", map=").append(map);
        sb.append(", description=").append(description);
        sb.append(", reminder=").append(reminder);
        sb.append(", comment=").append(comment);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}