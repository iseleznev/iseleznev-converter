package ru.iseleznev.converter;

import org.testng.annotations.Test;

import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

@Test(groups = "unit")
public class TargetModelConverterTest {

    @Test
    public void convert() {
        TargetItemConverter itemConverter = mock(TargetItemConverter.class);
        when(itemConverter.convert(any(SourceItem.class))).thenReturn(mock(TargetItem.class));

        TargetModelConverter modelConverter = new TargetModelConverter(itemConverter);

        SourceModel expected = sourceModel();
        TargetModel actual = modelConverter.convert(expected);

        assertEquals(actual.getClientName(), expected.getClientName());
        assertEquals(actual.getDescription(), expected.getTitle() + " " + expected.getDescription());
        assertSame(actual.getCreateDate(), expected.getCreateDate());
        assertEquals(actual.getId(), expected.getId());

        if (expected.getItemList() == null) {
            //assertNotNull(actual.getItemList());//избыточная проверка! если null - ошибка, тогда NPE и непройденный тест
            assertEquals(actual.getItemList().size(), 0);
            verifyZeroInteractions(itemConverter);
        } else {
            verify(itemConverter, times(expected.getItemList().size())).convert(any(SourceItem.class));
            verifyNoMoreInteractions(itemConverter);
        }
    }

    private SourceModel sourceModel() {
        Random random = new Random();
        SourceModel sourceModel = new SourceModel();
        sourceModel.setClientName(UUID.randomUUID().toString());
        if (random.nextBoolean()) {
            sourceModel.setTitle(UUID.randomUUID().toString());
        }
        sourceModel.setDescription(UUID.randomUUID().toString());
        sourceModel.setCreateDate(new Date());
        sourceModel.setId(random.nextLong());
        if (random.nextBoolean()) {
            sourceModel.setItemList(itemList(random));
        }
        return sourceModel;
    }

    private List<SourceItem> itemList(Random random) {
        List<SourceItem> list = new ArrayList<SourceItem>();
        int count = random.nextInt(7) + 3;
        for(int i = 0; i < count; i++) {
            list.add(mock(SourceItem.class));
        }
        return list;
    }
}