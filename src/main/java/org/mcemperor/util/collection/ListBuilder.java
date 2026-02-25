package org.mcemperor.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SequencedSet;
import java.util.Set;
import java.util.SortedSet;

/**
 * A builder class for creating {@link List}s.
 *
 * @param <V> The type of values within the list.
 * @param <L> The type of list created by this builder.
 */
public class ListBuilder<V, L extends List<V>> {

    /**
     * The internal list to store the values.
     */
    private final List<V> internalList;

    /**
     * Whether this builder should produce an unmodifiable List instance.
     */
    private boolean unmodifiable = true;

    /**
     * Constructs a new ListBuilder instance.
     *
     * @param internalList The list to store values added to the builder.
     */
    private ListBuilder(List<V> internalList) {
        this.internalList = internalList;
    }

    /**
     * Creates a new builder.
     *
     * @return A new ListBuilder.
     * @param <V> The type of values contained in this list.
     * @param <L> The type of list.
     */
    private static <V, L extends List<V>> ListBuilder<V, L> newBuilder() {
        return new ListBuilder<>(new ArrayList<>());
    }

    /**
     * Constructs a new ListBuilder initially with the given value.
     *
     * @param value The value.
     * @return A new ListBuilder instance with the given value.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V value) {
        return ListBuilder.<V, L>newBuilder()
            .add(value);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2, V v3) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2)
            .add(v3);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2, V v3, V v4) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2, V v3, V v4, V v5) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2, V v3, V v4, V v5, V v6) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @param v7 The seventh value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2, V v3, V v4, V v5, V v6, V v7) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6)
            .add(v7);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @param v7 The seventh value.
     * @param v8 The eighth value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6)
            .add(v7)
            .add(v8);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @param v7 The seventh value.
     * @param v8 The eighth value.
     * @param v9 The ninth value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8, V v9) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6)
            .add(v7)
            .add(v8)
            .add(v9);
    }

    /**
     * Constructs a new ListBuilder initially with the given values.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @param v7 The seventh value.
     * @param v8 The eighth value.
     * @param v9 The ninth value.
     * @param v10 The tenth value.
     * @return A new ListBuilder instance with the given values.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8, V v9, V v10) {
        return ListBuilder.<V, L>newBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6)
            .add(v7)
            .add(v8)
            .add(v9)
            .add(v10);
    }

    /**
     * Constructs a new SetBuilder, with the sorting order and all values of the specified set.
     * <p>
     * As this builder has a defined sorting, the set produced by this builder is a {@link SortedSet}.
     *
     * @param set The sorted set with the values to add.
     * @return A new SetBuilder instance with the sorting and values of the given set.
     * @param <V> The type of values within the list.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> of(SequencedSet<V> set) {
        return ListBuilder.<V, L>newBuilder()
            .addAll(set);
    }

    /**
     * Adds all values of the specified list into this list.
     *
     * @param list The list of which all values added to this builder.
     * @return This instance, to allow for method chaining.
     */
    private ListBuilder<V, L> addAll(Set<? extends V> list) {
        internalList.addAll(list);
        return this;
    }

    /**
     * Adds an additional value to the builder.
     *
     * @param value The value to add.
     * @return This instance, to allow for method chaining.
     */
    public ListBuilder<V, L> add(V value) {
        internalList.add(value);
        return this;
    }

    /**
     * Specifies that the list to be built is unmodifiable.
     *
     * @return This instance, to allow for method chaining.
     */
    public ListBuilder<V, L> unmodifiable() {
        unmodifiable = true;
        return this;
    }

    /**
     * Builds and returns a list containing the values added to this builder.
     * <p>
     * If the builder is configured to produce an unmodifiable list, the resulting list is wrapped in an
     * <em>unmodifiable view</em> of the list.
     *
     * @return The constructed list of type {@code L}.
     */
    @SuppressWarnings("unchecked")
    public L build() {
        return (L) determineUnmodifiable(new ArrayList<>(internalList));
    }

    /**
     * Determines if an unmodifiable list is configured to be produced, and if so, wraps the provided list into an
     * unmodifiable view of the list.
     *
     * @param list The created list to possibly wrap.
     * @return An unmodifiable view of the given list if this builder is configured to produce an unmodifiable list,
     * otherwise the given list without processing it.
     */
    private List<V> determineUnmodifiable(List<V> list) {
        return unmodifiable ? Collections.unmodifiableList(list) : list;
    }
}
