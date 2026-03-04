package org.mcemperor.util.collection;

import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SequencedMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MapBuilderTest {

    private static final String A = "one";
    private static final String B = "two";
    private static final String C = "three";
    private static final String D = "four";
    private static final String E = "five";
    private static final String F = "six";
    private static final String G = "seven";
    private static final String H = "eight";
    private static final String I = "nine";
    private static final String J = "ten";

    private static final List<MapBuilder<String, Integer, Map<String, Integer>>> OF_BUILDERS = List.of(
        MapBuilder.of(A, 1),
        MapBuilder.of(A, 1, B, 2),
        MapBuilder.of(A, 1, B, 2, C, 3),
        MapBuilder.of(A, 1, B, 2, C, 3, D, 4),
        MapBuilder.of(A, 1, B, 2, C, 3, D, 4, E, 5),
        MapBuilder.of(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6),
        MapBuilder.of(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6, G, 7),
        MapBuilder.of(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6, G, 7, H, 8),
        MapBuilder.of(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6, G, 7, H, 8, I, 9),
        MapBuilder.of(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6, G, 7, H, 8, I, 9, J, 10)
    );

    private static final List<MapBuilder<String, Integer, ? extends Map<String, Integer>>> OF_ORDERED_BUILDERS = List.of(
        MapBuilder.ofOrdered(A, 1),
        MapBuilder.ofOrdered(A, 1, B, 2),
        MapBuilder.ofOrdered(A, 1, B, 2, C, 3),
        MapBuilder.ofOrdered(A, 1, B, 2, C, 3, D, 4),
        MapBuilder.ofOrdered(A, 1, B, 2, C, 3, D, 4, E, 5),
        MapBuilder.ofOrdered(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6),
        MapBuilder.ofOrdered(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6, G, 7),
        MapBuilder.ofOrdered(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6, G, 7, H, 8),
        MapBuilder.ofOrdered(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6, G, 7, H, 8, I, 9),
        MapBuilder.ofOrdered(A, 1, B, 2, C, 3, D, 4, E, 5, F, 6, G, 7, H, 8, I, 9, J, 10)
    );

    private static Map<String, Integer> entries(int count, Supplier<Map<String, Integer>> supplier) {
        return Stream.of(
            entry(A, 1),
            entry(B, 2),
            entry(C, 3),
            entry(D, 4),
            entry(E, 5),
            entry(F, 6),
            entry(G, 7),
            entry(H, 8),
            entry(I, 9),
            entry(J, 10))
            .limit(count)
            .collect(Collectors.toMap(MapEntry::getKey, MapEntry::getValue, (left, right) -> left, supplier));
    }

    static Stream<Arguments> ofMethodOverloads() {
        return IntStream.range(0, OF_BUILDERS.size())
            .mapToObj(i -> arguments(OF_BUILDERS.get(i), entries(i + 1, HashMap::new)));
    }

    @ParameterizedTest
    @MethodSource
    void ofMethodOverloads(MapBuilder<String, Integer, Map<String, Integer>> builder, Map<String, Integer> entries) {
        var map = builder.build();

        assertThat(map).containsExactlyInAnyOrderEntriesOf(entries);
    }

    static Stream<Arguments> ofOrderedMethodOverloads() {
        return IntStream.range(0, OF_ORDERED_BUILDERS.size())
            .mapToObj(i -> arguments(OF_ORDERED_BUILDERS.get(i), entries(i + 1, LinkedHashMap::new)));
    }

    @ParameterizedTest
    @MethodSource
    void ofOrderedMethodOverloads(MapBuilder<String, Integer, Map<String, Integer>> builder, Map<String, Integer> entries) {
        var map = builder.build();

        assertThat(map).containsExactlyEntriesOf(entries);
    }

    @Test
    void ofEntriesMethodReturnsNormalMap() {
        var result = MapBuilder.ofEntries(
            Map.entry("one", "alpha"),
            Map.entry("two", "bravo"),
            Map.entry("three", "charlie"),
            Map.entry("four", "delta"),
            Map.entry("five", "echo")
        ).build();

        assertThat(result)
            .containsOnly(
                entry("five", "echo"),
                entry("four", "delta"),
                entry("three", "charlie"),
                entry("two", "bravo"),
                entry("one", "alpha")
            );
    }

    @Test
    void ofOrderedEntriesMethodReturnsMapWithSpecifiedOrder() {
        Map<String, String> result = MapBuilder.ofOrderedEntries(
            Map.entry("one", "alpha"),
            Map.entry("two", "bravo"),
            Map.entry("three", "charlie"),
            Map.entry("four", "delta"),
            Map.entry("five", "echo")
        ).build();

        assertThat(result)
            .isInstanceOf(SequencedMap.class)
            .containsExactly(
                entry("one", "alpha"),
                entry("two", "bravo"),
                entry("three", "charlie"),
                entry("four", "delta"),
                entry("five", "echo")
            );
    }

    @Test
    void buildMethodWithoutMutableReturnsUnmodifiableMap() {
        Map<String, Integer> map = MapBuilder.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4)
            .build();

        assertThat(map)
            .isUnmodifiable()
            .containsOnly(
                entry("one", 1),
                entry("two", 2),
                entry("three", 3),
                entry("four", 4)
            );
    }

    @Test
    void buildMethodWithMutableReturnsMutableMap() {
        Map<String, Integer> map = MapBuilder.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4)
            .mutable()
            .build();

        assertThatNoException()
            .isThrownBy(() -> map.put("five", 5));
    }

    @Test
    void buildMethodReturnsSequencedMapIfOrdered() {
        Map<Integer, String> map = MapBuilder.ofOrdered(1, "alpha", 2, "bravo")
            .build();

        assertThat(map)
            .isInstanceOf(SequencedMap.class)
            .isUnmodifiable();
    }

    @Test
    void buildMethodReturnsMutableSequencedMapIfOrderedAndMutable() {
        Map<Integer, String> map = MapBuilder.ofOrdered(1, "alpha", 2, "bravo")
            .mutable()
            .build();

        assertThat(map).isInstanceOf(SequencedMap.class);
        assertThatNoException().isThrownBy(() -> map.put(3, "charlie"));
    }

    @Test
    void buildMethodReturnsSortedMapIfSorted() {
        Map<String, Integer> map = MapBuilder.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4)
            .sorted(Comparator.naturalOrder())
            .build();

        assertThat(map)
            .isInstanceOf(SortedMap.class)
            .isUnmodifiable()
            .containsExactly(
                entry("four", 4),
                entry("one", 1),
                entry("three", 3),
                entry("two", 2));
    }

    @Test
    void buildMethodReturnsMutableSortedMapIfSortedAndMutable() {
        Map<String, Integer> map = MapBuilder.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4)
            .sorted(Comparator.naturalOrder())
            .mutable()
            .build();

        assertThatNoException().isThrownBy(() -> map.put("five", 5));
        assertThat(map)
            .isInstanceOf(SortedMap.class)
            .containsExactly(
                entry("five", 5),
                entry("four", 4),
                entry("one", 1),
                entry("three", 3),
                entry("two", 2));
    }

    static Stream<Comparator<?>> ofMapMethodWithSortedMapReturnsSortedMapInstance() {
        return Stream.of(
            Comparator.naturalOrder(),
            null
        );
    }

    @ParameterizedTest
    @MethodSource
    void ofMapMethodWithSortedMapReturnsSortedMapInstance(Comparator<String> comparator) {
        SortedMap<String, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.put("one", 1);
        sortedMap.put("two", 2);
        sortedMap.put("three", 3);

        Map<String, Integer> result = MapBuilder.ofMap(sortedMap)
            .put("four", 4)
            .put("five", 5)
            .build();

        assertThat(result)
            .isInstanceOf(SortedMap.class)
            .containsExactly(
                entry("five", 5),
                entry("four", 4),
                entry("one", 1),
                entry("three", 3),
                entry("two", 2)
            );
    }

    @Test
    void ofMapMethodWithSortedMapWithNullComparatorAndNonComparablesThrows() {
        class SomethingNonComparable { }

        assertThatExceptionOfType(ClassCastException.class)
            .isThrownBy(() -> MapBuilder.ofMap(new TreeMap<>())
                .put(new SomethingNonComparable(), 1)
                .build());
    }
}
