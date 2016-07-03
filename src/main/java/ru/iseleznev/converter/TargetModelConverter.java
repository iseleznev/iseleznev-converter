package ru.iseleznev.converter;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.ArrayList;

public class TargetModelConverter implements ModelConverter<SourceModel, TargetModel> {

    private TargetItemConverter itemConverter;

    public TargetModelConverter(TargetItemConverter itemConverter) {
        this.itemConverter = itemConverter;
    }

    public TargetModel convert(SourceModel source) {
        TargetModel target = new TargetModel();
        target.setClientName(source.getClientName());
        target.setCreateDate(source.getCreateDate());
        target.setDescription(source.getTitle() + " " + source.getDescription());
        target.setId(source.getId());
        target.setItemList(new ArrayList<TargetItem>());
        if (source.getItemList() != null) {
            target.getItemList().addAll(Lists.transform(source.getItemList(), new Function<SourceItem, TargetItem>() {
                public TargetItem apply(SourceItem input) {
                    return itemConverter.convert(input);
                }
            }));
        }
        return target;
    }
}
