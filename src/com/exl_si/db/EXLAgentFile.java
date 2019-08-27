package com.exl_si.db;

public class EXLAgentFile {
    private String id;

    private String agentid;

    private String type;

    private Integer index;

    private String nameOld;

    private String nameNew;

    private String path;

    public EXLAgentFile(String id, String agentid, String type, Integer index, String nameOld, String nameNew, String path) {
        this.id = id;
        this.agentid = agentid;
        this.type = type;
        this.index = index;
        this.nameOld = nameOld;
        this.nameNew = nameNew;
        this.path = path;
    }

    public EXLAgentFile() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
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

    public String getNameOld() {
        return nameOld;
    }

    public void setNameOld(String nameOld) {
        this.nameOld = nameOld == null ? null : nameOld.trim();
    }

    public String getNameNew() {
        return nameNew;
    }

    public void setNameNew(String nameNew) {
        this.nameNew = nameNew == null ? null : nameNew.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", agentid=").append(agentid);
        sb.append(", type=").append(type);
        sb.append(", index=").append(index);
        sb.append(", nameOld=").append(nameOld);
        sb.append(", nameNew=").append(nameNew);
        sb.append(", path=").append(path);
        sb.append("]");
        return sb.toString();
    }
}