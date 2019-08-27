package com.exl_si.db;

public class EXLClientFile {
    private String id;

    private String clientid;

    private String type;

    private Integer index;

    private String nameOld;

    private String nameNew;

    private String path;

    public EXLClientFile(String id, String clientid, String type, Integer index, String nameOld, String nameNew, String path) {
        this.id = id;
        this.clientid = clientid;
        this.type = type;
        this.index = index;
        this.nameOld = nameOld;
        this.nameNew = nameNew;
        this.path = path;
    }

    public EXLClientFile() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
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
        sb.append(", clientid=").append(clientid);
        sb.append(", type=").append(type);
        sb.append(", index=").append(index);
        sb.append(", nameOld=").append(nameOld);
        sb.append(", nameNew=").append(nameNew);
        sb.append(", path=").append(path);
        sb.append("]");
        return sb.toString();
    }
}