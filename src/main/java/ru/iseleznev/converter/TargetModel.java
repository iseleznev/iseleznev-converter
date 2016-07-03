package ru.iseleznev.converter;

import java.util.Date;
import java.util.List;

public class TargetModel {

    private Long id;
    private String description;
    private Date createDate;
    private String clientName;
    private List<TargetItem> itemList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<TargetItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TargetItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "TargetModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", clientName='" + clientName + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
