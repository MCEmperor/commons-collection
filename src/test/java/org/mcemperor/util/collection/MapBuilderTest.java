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
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
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
    void buildMethodWithUnmodifiableReturnsUnmodifiableMap() {
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
    void buildMethodReturnsSequencedMapIfOrdered() {
        Map<Integer, String> map = MapBuilder.ofOrdered(1, "alpha", 2, "bravo")
            .build();

        assertThat(map).isInstanceOf(SequencedMap.class);
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
            .containsExactly(
                entry("four", 4),
                entry("one", 1),
                entry("three", 3),
                entry("two", 2));
    }
}
