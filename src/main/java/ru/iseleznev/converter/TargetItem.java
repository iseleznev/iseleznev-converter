package ru.iseleznev.converter;

public class TargetItem {

    private Integer code;
    private Double price;
    private Integer quantity;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TargetItem{" +
                "code=" + code +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
