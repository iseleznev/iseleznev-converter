package ru.iseleznev.converter;

public class SourceItem {

    private String code;
    private Integer price;
    private Integer discount;
    private Integer quantity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SourceItem{" +
                "code='" + code + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", quantity=" + quantity +
                '}';
    }
}
