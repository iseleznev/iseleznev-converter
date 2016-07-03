package ru.iseleznev.converter;

import java.util.*;

public class ConverterApp {

    public static void main(String[] args) {
        SourceModel source = new SourceModel();
        source.setId(1L);
        source.setClientName("Иванов Иван Иванович");
        source.setDescription(UUID.randomUUID().toString());
        source.setCreateDate(new Date());
        source.setTitle("Заказ");
        source.setItemList(list());

        TargetModel target = new TargetModelConverter(new TargetItemConverter()).convert(source);
        System.out.println(target);
    }

    private static List<SourceItem> list() {
        List<SourceItem> list = new ArrayList<SourceItem>();
        int count = new Random().nextInt(5) + 1;
        for (int i = 0; i < count; i++) {
            list.add(sourceItem());
        }
        return list;
    }

    private static SourceItem sourceItem() {
        Random random = new Random();
        SourceItem item = new SourceItem();
        item.setPrice(random.nextInt());
        if (random.nextBoolean()) {
            item.setQuantity(random.nextInt());
        }
        item.setCode(Integer.toString(random.nextInt()));
        return item;
    }
}
