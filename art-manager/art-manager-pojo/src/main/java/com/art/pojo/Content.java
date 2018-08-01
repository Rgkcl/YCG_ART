package com.art.pojo;

import java.io.Serializable;
import java.util.Date;

public class Content implements Serializable {
   

	private Long id;

    private Long categoryId;

    private String title;

    private String url;

    private String pic;

    private Date created;

    private Date updated;

    private String content;

    private Long price;
    @Override
   	public String toString() {
   		return "Content [id=" + id + ", categoryId=" + categoryId + ", title=" + title + ", url=" + url + ", pic=" + pic
   				+ ", created=" + created + ", updated=" + updated + ", content=" + content + ", price=" + price + "]";
   	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}