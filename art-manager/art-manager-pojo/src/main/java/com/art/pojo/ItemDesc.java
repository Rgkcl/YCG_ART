package com.art.pojo;

import java.io.Serializable;
import java.util.Date;

public class ItemDesc implements Serializable {
    @Override
	public String toString() {
		return "ItemDesc [id=" + id + ", created=" + created + ", updated=" + updated + ", itemDesc=" + itemDesc + "]";
	}

	private long id;

    private Date created;

    private Date updated;

    private String itemDesc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }
}