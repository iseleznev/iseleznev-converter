package ru.iseleznev.converter;

import java.util.Date;
import java.util.List;
import java.util.Stack;

public class SourceModel {

    private Long id;
    private String title;
    private Date createDate;
    private String description;
    private String clientName;
    private List<SourceItem> itemList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<SourceItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<SourceItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "SourceModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                ", clientName='" + clientName + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
