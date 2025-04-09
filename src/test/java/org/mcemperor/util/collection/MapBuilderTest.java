package org.mcemperor.util.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class MapBuilderTest {

    @Test
    void put_addsEntryToMap() {
        Map<String, Integer> map = new MapBuilder<String, Integer>()
            .put("one", 1)
            .build();

        assertThat(map).containsEntry("one", 1);
    }

    @Test
    void insertionOrder_setsInsertionOrder() {
        Map<String, Integer> map = new MapBuilder<String, Integer>()
            .insertionOrder()
            .put("three", 3)
            .put("one", 1)
            .put("two", 2)
            .put("four", 4)
            .build();

        assertThat(map).containsExactly(
            entry("three", 3),
            entry("one", 1),
            entry("two", 2),
            entry("four", 4)
        );
    }

    @Test
    void sortedOrder_setsSortedOrderWithComparator() {
        Map<String, Integer> map = new MapBuilder<String, Integer>()
            .sortedOrder(Comparator.reverseOrder())
            .put("one", 1)
            .put("two", 2)
            .put("three", 3)
            .build();

        assertThat(map).containsExactly(
            entry("two", 2),
            entry("three", 3),
            entry("one", 1)
        );
    }

    @Test
    void naturalOrder_setsNaturalOrder() {
        Map<String, Integer> map = new MapBuilder<String, Integer>()
            .naturalOrder()
            .put("one", 1)
            .put("two", 2)
            .put("three", 3)
            .build();

        assertThat(map).containsExactly(
            entry("one", 1),
            entry("three", 3),
            entry("two", 2)
        );
    }

    @Test
    void build_returnsUnmodifiableMap_noOrder() {
        Map<String, Integer> map = new MapBuilder<String, Integer>()
            .put("one", 1)
            .put("two", 2)
            .build();

        assertThat(map)
            .isUnmodifiable()
            .containsExactlyInAnyOrderEntriesOf(Map.of(
                "one", 1,
                "two", 2
            ));
    }

    @Test
    void build_returnsUnmodifiableMap_naturalOrder() {
        Map<String, Integer> map = new MapBuilder<String, Integer>()
            .naturalOrder()
            .put("one", 1)
            .put("two", 2)
            .put("three", 3)
            .build();

        assertThat(map)
            .isUnmodifiable()
            .containsExactly(
                entry("one", 1),
                entry("three", 3),
                entry("two", 2)
            );
    }

    @Test
    void build_returnsUnmodifiableMap_comparatorOrder() {
        Map<String, Integer> map = new MapBuilder<String, Integer>()
            .sortedOrder(Comparator.reverseOrder())
            .put("one", 1)
            .put("two", 2)
            .put("three", 3)
            .build();

        assertThat(map)
            .isUnmodifiable()
            .containsExactly(
                entry("two", 2),
                entry("three", 3),
                entry("one", 1)
            );
    }

    @Test
    void build_returnsUnmodifiableMap_insertionOrder() {
        Map<String, Integer> map = new MapBuilder<String, Integer>()
            .insertionOrder()
            .put("one", 1)
            .put("two", 2)
            .put("three", 3)
            .build();

        assertThat(map)
            .isUnmodifiable()
            .containsExactly(
                entry("one", 1),
                entry("two", 2),
                entry("three", 3)
            );
    }
}

