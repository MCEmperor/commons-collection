package org.mcemperor.util.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ListBuilderTest {

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

    private static final List<ListBuilder<String, List<String>>> OF_BUILDERS = List.of(
        ListBuilder.of(A),
        ListBuilder.of(A, B),
        ListBuilder.of(A, B, C),
        ListBuilder.of(A, B, C, D),
        ListBuilder.of(A, B, C, D, E),
        ListBuilder.of(A, B, C, D, E, F),
        ListBuilder.of(A, B, C, D, E, F, G),
        ListBuilder.of(A, B, C, D, E, F, G, H),
        ListBuilder.of(A, B, C, D, E, F, G, H, I),
        ListBuilder.of(A, B, C, D, E, F, G, H, I, J)
    );

    private static List<String> entries(int count, Supplier<List<String>> supplier) {
        return Stream.of(A, B, C, D, E, F, G, H, I, J)
            .limit(count)
            .collect(Collectors.toCollection(supplier));
    }

    static Stream<Arguments> ofMethodOverloads() {
        return IntStream.range(0, OF_BUILDERS.size())
            .mapToObj(i -> arguments(OF_BUILDERS.get(i), entries(i + 1, ArrayList::new)));
    }

    @ParameterizedTest
    @MethodSource
    void ofMethodOverloads(ListBuilder<String, List<String>> builder, List<String> elements) {
        var list = builder.build();

        assertThat(list).containsExactlyElementsOf(elements);
    }

    @Test
    void buildMethodWithoutMutableReturnsUnmodifiableList() {
        List<String> list = ListBuilder.of(A, B, C, D).build();

        assertThat(list)
            .isUnmodifiable()
            .containsExactly(A, B, C, D);
    }

    @Test
    void buildMethodWithMutableReturnsMutableList() {
        List<String> list = ListBuilder.of(A, B, C, D)
            .mutable()
            .build();

        assertThatNoException()
            .isThrownBy(() -> list.add(E));
    }

    @Test
    void ofCollectionMethodWithListReturnsListInstance() {
        List<String> initialList = List.of(A, B, C, D);
        List<String> result = ListBuilder.ofCollection(initialList)
            .build();

        assertThat(result)
            .isInstanceOf(List.class)
            .containsExactly(A, B, C, D);
    }
}
