package com.exl_si.db;

import com.exl_si.db.vo.SubFile;

public class VoucherPicture extends SubFile{
    private String id;

    private String voucherId;

    private String type;

    private Integer indx;

    private String nameOld;

    private String nameNew;

    private String path;

    public VoucherPicture(String id, String voucherId, String type, Integer indx, String nameOld, String nameNew, String path) {
        this.id = id;
        this.voucherId = voucherId;
        this.type = type;
        this.indx = indx;
        this.nameOld = nameOld;
        this.nameNew = nameNew;
        this.path = path;
    }

    public VoucherPicture() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId == null ? null : voucherId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getIndx() {
        return indx;
    }

    public void setIndx(Integer indx) {
        this.indx = indx;
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
        sb.append(", voucherId=").append(voucherId);
        sb.append(", type=").append(type);
        sb.append(", indx=").append(indx);
        sb.append(", nameOld=").append(nameOld);
        sb.append(", nameNew=").append(nameNew);
        sb.append(", path=").append(path);
        sb.append("]");
        return sb.toString();
    }
}