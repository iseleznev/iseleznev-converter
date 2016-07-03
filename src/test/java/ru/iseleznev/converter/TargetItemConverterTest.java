package ru.iseleznev.converter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.*;

@Test(groups = "unit")
public class TargetItemConverterTest {

    @Test(dataProviderClass = SourceItemGenerator.class, dataProvider = "generate")
    public void convert(SourceItem sourceItem) {
        TargetItemConverter converter = new TargetItemConverter();

        TargetItem actual = converter.convert(sourceItem);


        if (sourceItem.getDiscount() == 0) {
            assertEquals(actual.getPrice(), Double.valueOf(sourceItem.getPrice()));
        } else {
            assertEquals(actual.getPrice(),
                    (double) (sourceItem.getPrice() - (sourceItem.getPrice() * 100 / sourceItem.getDiscount())));
        }

        if (sourceItem.getCode() == null) {
            assertNull(actual.getCode());
        } else {
            assertEquals(actual.getCode(), new Integer(sourceItem.getCode()));
        }
        assertEquals(actual.getQuantity(), sourceItem.getQuantity());
    }

    private static class SourceItemGenerator {

        private static final int COUNT = 10;
        private static final int MIN_PRICE = 1000;
        private static final int MAX_PRICE = 5000;
        private static final int MAX_DISCOUNT = 100;

        @DataProvider
        private static Iterator<Object[]> generate() {
            List<Object[]> list = new ArrayList<Object[]>();
            for (int i = 0; i < COUNT; i++) {
                list.add(new Object[]{sourceItem()});
            }
            return list.iterator();
        }

        private static SourceItem sourceItem() {
            Random random = new Random();
            SourceItem sourceItem = new SourceItem();
            if (random.nextBoolean()) {
                sourceItem.setCode(Integer.toString(random.nextInt()));
            }
            sourceItem.setQuantity(random.nextInt());
            sourceItem.setDiscount(random.nextInt(MAX_DISCOUNT));
            sourceItem.setPrice(random.nextInt(MAX_PRICE) + MIN_PRICE);
            return sourceItem;
        }
    }

}