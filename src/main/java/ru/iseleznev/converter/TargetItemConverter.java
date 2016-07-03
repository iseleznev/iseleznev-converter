package ru.iseleznev.converter;

public class TargetItemConverter implements ModelConverter<SourceItem, TargetItem> {

    public TargetItem convert(SourceItem source) {
        TargetItem target = new TargetItem();
        if (source.getCode() != null) {
            target.setCode(new Integer(source.getCode()));
        }
        target.setQuantity(source.getQuantity());
        if (source.getDiscount() == 0) {
            target.setPrice(Double.valueOf(source.getPrice()));
        } else {
            target.setPrice((double) (source.getPrice() - (source.getPrice() * 100 / source.getDiscount())));
        }
        return target;
    }
}
