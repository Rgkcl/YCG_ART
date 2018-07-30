package com.art.pojo;

import java.util.Date;

public class ItemDesc {
    private long id;

    private String desc;

    private Date created;

    private Date udated;

    public long getId() {
        return id;
    }

    public void setId(long itemId) {
        this.id = itemId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUdated() {
        return udated;
    }

    public void setUdated(Date udated) {
        this.udated = udated;
    }
}