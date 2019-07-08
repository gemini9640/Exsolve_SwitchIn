package com.exl_si.db;

public class EventPicture {
    private Integer eventId;

    private String type;

    private Integer index;

    private String url;

    public EventPicture(Integer eventId, String type, Integer index, String url) {
        this.eventId = eventId;
        this.type = type;
        this.index = index;
        this.url = url;
    }

    public EventPicture() {
        super();
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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
        sb.append(", eventId=").append(eventId);
        sb.append(", type=").append(type);
        sb.append(", index=").append(index);
        sb.append(", url=").append(url);
        sb.append("]");
        return sb.toString();
    }
}