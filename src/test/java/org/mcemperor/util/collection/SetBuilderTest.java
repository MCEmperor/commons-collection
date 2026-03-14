package org.mcemperor.util.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SetBuilderTest {

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

    private static final List<SetBuilder<String, Set<String>>> OF_BUILDERS = List.of(
        SetBuilder.of(A),
        SetBuilder.of(A, B),
        SetBuilder.of(A, B, C),
        SetBuilder.of(A, B, C, D),
        SetBuilder.of(A, B, C, D, E),
        SetBuilder.of(A, B, C, D, E, F),
        SetBuilder.of(A, B, C, D, E, F, G),
        SetBuilder.of(A, B, C, D, E, F, G, H),
        SetBuilder.of(A, B, C, D, E, F, G, H, I),
        SetBuilder.of(A, B, C, D, E, F, G, H, I, J)
    );

    private static final List<SetBuilder<String, SequencedSet<String>>> OF_ORDERED_BUILDERS = List.of(
        SetBuilder.ofOrdered(A),
        SetBuilder.ofOrdered(A, B),
        SetBuilder.ofOrdered(A, B, C),
        SetBuilder.ofOrdered(A, B, C, D),
        SetBuilder.ofOrdered(A, B, C, D, E),
        SetBuilder.ofOrdered(A, B, C, D, E, F),
        SetBuilder.ofOrdered(A, B, C, D, E, F, G),
        SetBuilder.ofOrdered(A, B, C, D, E, F, G, H),
        SetBuilder.ofOrdered(A, B, C, D, E, F, G, H, I),
        SetBuilder.ofOrdered(A, B, C, D, E, F, G, H, I, J)
    );

    private static Set<String> entries(int count, Supplier<Set<String>> supplier) {
        return Stream.of(A, B, C, D, E, F, G, H, I, J)
            .limit(count)
            .collect(Collectors.toCollection(supplier));
    }

    static Stream<Arguments> ofMethodOverloads() {
        return IntStream.range(0, OF_BUILDERS.size())
            .mapToObj(i -> arguments(OF_BUILDERS.get(i), entries(i + 1, HashSet::new)));
    }

    @ParameterizedTest
    @MethodSource
    void ofMethodOverloads(SetBuilder<String, Set<String>> builder, Set<String> elements) {
        var set = builder.build();

        assertThat(set).containsExactlyInAnyOrderElementsOf(elements);
    }

    static Stream<Arguments> ofOrderedMethodOverloads() {
        return IntStream.range(0, OF_ORDERED_BUILDERS.size())
            .mapToObj(i -> arguments(OF_ORDERED_BUILDERS.get(i), entries(i + 1, LinkedHashSet::new)));
    }

    @ParameterizedTest
    @MethodSource
    void ofOrderedMethodOverloads(SetBuilder<String, Set<String>> builder, Set<String> elements) {
        var set = builder.build();

        assertThat(set).containsExactlyElementsOf(elements);
    }

    @Test
    void buildMethodWithoutMutableReturnsUnmodifiableSet() {
        Set<String> set = SetBuilder.of(A, B, C, D).build();

        assertThat(set)
            .isUnmodifiable()
            .containsOnly(A, B, C, D);
    }

    @Test
    void buildMethodWithMutableReturnsMutableSet() {
        Set<String> set = SetBuilder.of(A, B, C, D)
            .mutable()
            .build();

        assertThatNoException()
            .isThrownBy(() -> set.add(E));
    }

    @Test
    void buildMethodReturnsSequencedSetIfOrdered() {
        Set<String> set = SetBuilder.ofOrdered(B, A)
            .build();

        assertThat(set)
            .isInstanceOf(SequencedSet.class)
            .isUnmodifiable()
            .containsExactly(B, A);
    }

    @Test
    void buildMethodReturnsMutableSequencedSetIfOrderedAndMutable() {
        Set<String> set = SetBuilder.ofOrdered(B, A)
            .mutable()
            .build();

        assertThatNoException().isThrownBy(() -> set.add(C));
        assertThat(set)
            .isInstanceOf(SequencedSet.class)
            .containsExactly(B, A, C);
    }

    @Test
    void buildMethodReturnsSortedSetIfSorted() {
        Set<String> set = SetBuilder.of(A, B, C, D)
            .sorted(Comparator.naturalOrder())
            .build();

        assertThat(set)
            .isInstanceOf(SortedSet.class)
            .isUnmodifiable()
            .containsExactly(D, A, C, B); // Lexical order
    }

    @Test
    void buildMethodReturnsMutableSortedSetIfSortedAndMutable() {
        Set<String> set = SetBuilder.of(A, B, C, D)
            .sorted(Comparator.naturalOrder())
            .mutable()
            .build();

        assertThatNoException().isThrownBy(() -> set.add(E));
        assertThat(set)
            .isInstanceOf(SortedSet.class)
            .containsExactly(E, D, A, C, B); // Lexical order
    }

    static Stream<Comparator<?>> ofCollectionMethodWithSortedSetReturnsSortedSetInstance() {
        return Stream.of(
            Comparator.naturalOrder(),
            null
        );
    }

    @ParameterizedTest
    @MethodSource
    void ofCollectionMethodWithSortedSetReturnsSortedSetInstance(Comparator<String> comparator) {
        SortedSet<String> sortedSet = new TreeSet<>(comparator);
        sortedSet.add(A);
        sortedSet.add(B);
        sortedSet.add(C);

        Set<String> result = SetBuilder.ofCollection(sortedSet)
            .add(D)
            .add(E)
            .build();

        assertThat(result)
            .isInstanceOf(SortedSet.class)
            .containsExactly(E, D, A, C, B); // Lexical order
    }

    @Test
    void ofCollectionMethodWithSortedSetWithNullComparatorAndNonComparablesThrows() {
        class SomethingNonComparable { }

        assertThatExceptionOfType(ClassCastException.class)
            .isThrownBy(() -> SetBuilder.ofCollection(new TreeSet<>())
                .add(new SomethingNonComparable())
                .build());
    }
}
