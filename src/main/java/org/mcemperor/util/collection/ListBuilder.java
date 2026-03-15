package org.mcemperor.util.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
     * Constructs a new ListBuilder with all values of the specified collection, in the order of the collection's
     * iterator.
     *
     * @param collection The collection with the values to add.
     * @return A new ListBuilder instance with the values of the given collection.
     * @param <V> The type of values within the list builder.
     * @param <L> The type of list this builder produces.
     */
    public static <V, L extends List<V>> ListBuilder<V, L> ofCollection(Collection<V> collection) {
        return ListBuilder.<V, L>newBuilder()
            .addAll(collection);
    }

    /**
     * Adds all values of the specified collection into this list builder. The elements are added in the same order as
     * collection's iterator.
     *
     * @param collection The collection of which all values added to this builder.
     * @return This instance, to allow for method chaining.
     */
    private ListBuilder<V, L> addAll(Collection<? extends V> collection) {
        internalList.addAll(collection);
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
     * Specifies that the list to be built is mutable.
     *
     * @return This instance, to allow for method chaining.
     */
    public ListBuilder<V, L> mutable() {
        unmodifiable = false;
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
    public L build() {
        return buildList();
    }

    /**
     * Builds and returns a {@link List} containing the values added to this builder.
     * <p>
     * If the builder is configured to return an <em>unmodifiable</em> instance, the resulting list is wrapped into an
     * unmodifiable view of the resulting List.
     *
     * @return A List containing values added to this builder.
     */
    @SuppressWarnings("unchecked")
    private L buildList() {
        List<V> resultingList = new ArrayList<>(internalList);
        if (unmodifiable) {
            return (L) Collections.unmodifiableList(resultingList);
        }
        return (L) resultingList;
    }
}
