package org.mcemperor.util.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SequencedSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A builder class for creating {@link Set}s.
 *
 * @param <V> The type of the values in the set.
 * @param <S> The type of set created by this builder.
 */
public class SetBuilder<V, S extends Set<V>> {

    /**
     * The internal set to store the values.
     */
    private final Set<V> internalSet;

    /**
     * Whether this SetBuilder maintains insertion order.
     */
    private final boolean ordered;

    /**
     * The comparator to use, if this builder has a sorting.
     */
    private Comparator<? super V> comparator;

    /**
     * Whether this builder should produce an unmodifiable Set instance.
     */
    private boolean unmodifiable = true;

    /**
     * Constructs a new SetBuilder instance.
     *
     * @param ordered Whether the builder maintains insertion order.
     * @param internalSet The set to store values added to the builder.
     */
    private SetBuilder(boolean ordered, Set<V> internalSet) {
        this.ordered = ordered;
        this.internalSet = internalSet;
    }

    /**
     * Creates a builder which maintains insertion order.
     *
     * @return A new SetBuilder.
     * @param <V> The type of values contained in this set.
     * @param <S> The type of set, which extends {@link SequencedSet}.
     */
    private static <V, S extends SequencedSet<V>> SetBuilder<V, S> newInsertionOrderBuilder() {
        return new SetBuilder<>(true, new LinkedHashSet<>());
    }

    /**
     * Creates an unordered builder.
     *
     * @return A new SetBuilder.
     * @param <V> The type of values contained in this set.
     * @param <S> The type of set.
     */
    private static <V, S extends Set<V>> SetBuilder<V, S> newUnorderedBuilder() {
        return new SetBuilder<>(false, new HashSet<>());
    }

    /**
     * Constructs a new unordered SetBuilder initially with the given value.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param value The value.
     * @return A new SetBuilder instance with the given value.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V value) {
        return SetBuilder.<V, S>newUnorderedBuilder()
            .add(value);
    }

    /**
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2) {
        return SetBuilder.<V, S>newUnorderedBuilder()
            .add(v1)
            .add(v2);
    }

    /**
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2, V v3) {
        return SetBuilder.<V, S>newUnorderedBuilder()
            .add(v1)
            .add(v2)
            .add(v3);
    }

    /**
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2, V v3, V v4) {
        return SetBuilder.<V, S>newUnorderedBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4);
    }

    /**
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2, V v3, V v4, V v5) {
        return SetBuilder.<V, S>newUnorderedBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5);
    }

    /**
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2, V v3, V v4, V v5, V v6) {
        return SetBuilder.<V, S>newUnorderedBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6);
    }

    /**
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @param v7 The seventh value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2, V v3, V v4, V v5, V v6, V v7) {
        return SetBuilder.<V, S>newUnorderedBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6)
            .add(v7);
    }

    /**
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @param v7 The seventh value.
     * @param v8 The eighth value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8) {
        return SetBuilder.<V, S>newUnorderedBuilder()
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
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
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
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8, V v9) {
        return SetBuilder.<V, S>newUnorderedBuilder()
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
     * Constructs a new unordered SetBuilder initially with the given values.
     * <p>
     * The SetBuilder has no specified encounter order, and any set this builder produces does not provide any
     * guarantees regarding encounter order.
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
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends Set<V>> SetBuilder<V, S> of(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8, V v9, V v10) {
        return SetBuilder.<V, S>newUnorderedBuilder()
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
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SortedSet<V>> SetBuilder<V, S> ofSet(SortedSet<V> set) {
        @SuppressWarnings("unchecked")
        Comparator<? super V> comparator = set.comparator() != null
            ? set.comparator()
            : (Comparator<V>) Comparator.naturalOrder();
        return SetBuilder.<V, S>newUnorderedBuilder()
            .<S>sorted(comparator)
            .addAll(set);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given value.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @param value The value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V value) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
            .add(value);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
            .add(v1)
            .add(v2);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2, V v3) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
            .add(v1)
            .add(v2)
            .add(v3);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2, V v3, V v4) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2, V v3, V v4, V v5) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2, V v3, V v4, V v5, V v6) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @param v7 The seventh value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2, V v3, V v4, V v5, V v6, V v7) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
            .add(v1)
            .add(v2)
            .add(v3)
            .add(v4)
            .add(v5)
            .add(v6)
            .add(v7);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @param v1 The first value.
     * @param v2 The second value.
     * @param v3 The third value.
     * @param v4 The fourth value.
     * @param v5 The fifth value.
     * @param v6 The sixth value.
     * @param v7 The seventh value.
     * @param v8 The eighth value.
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
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
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
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
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8, V v9) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
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
     * Constructs a new ordered SetBuilder, initially with the given values.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
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
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V v1, V v2, V v3, V v4, V v5, V v6, V v7, V v8, V v9, V v10) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
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
     * Adds all values of the specified set into this set.
     *
     * @param set The set of which all values added to this builder.
     * @return This instance, to allow for method chaining.
     */
    private SetBuilder<V, S> addAll(Set<? extends V> set) {
        internalSet.addAll(set);
        return this;
    }

    /**
     * Adds an additional value to the builder.
     *
     * @param value The value to add.
     * @return This instance, to allow for method chaining.
     */
    public SetBuilder<V, S> add(V value) {
        internalSet.add(value);
        return this;
    }

    /**
     * Specifies that the map to be built is sorted using the provided comparator.
     *
     * @param comparator The comparator to use for sorting.
     * @return This instance, to allow for method chaining.
     */
    @SuppressWarnings("unchecked")
    public <T extends SortedSet<V>> SetBuilder<V, T> sorted(Comparator<? super V> comparator) {
        this.comparator = comparator;
        return (SetBuilder<V, T>) this;
    }

    /**
     * Specifies that the set to be built is mutable.
     *
     * @return This instance, to allow for method chaining.
     */
    public SetBuilder<V, S> mutable() {
        unmodifiable = false;
        return this;
    }

    /**
     * Builds and returns a set containing the values added to this builder.
     * <p>
     * The specific implementation of the returned set depends on the builder configuration:
     * <ul>
     *     <li>If the builder is sorted, then this method returns a {@link SortedSet} instance.</li>
     *     <li>If the builder was constructed with ordering, then this method returns a {@link SequencedSet}.</li>
     *     <li>Otherwise, this method returns a {@link Set}, no further specified.</li>
     * </ul>
     * <p>
     * If the builder is configured to produce an unmodifiable set, the resulting set is wrapped in an <em>unmodifiable
     * view</em> of the set.
     *
     * @return The constructed set of type {@code S}.
     */
    public S build() {
        if (comparator != null) {
            return buildSortedSet();
        }
        else if (ordered) {
            return buildSequencedSet();
        }
        else {
            return buildSet();
        }
    }

    /**
     * Builds and returns a {@link SortedSet} containing the values added to this builder.
     * <p>
     * If the builder is configured to return an <em>unmodifiable</em> instance, the resulting set is wrapped into an
     * unmodifiable view of the resulting SortedSet.
     *
     * @return A SortedSet containing values added to this builder.
     */
    @SuppressWarnings("unchecked")
    private S buildSortedSet() {
        SortedSet<V> resultingSet = new TreeSet<>(comparator);
        resultingSet.addAll(internalSet);
        if (unmodifiable) {
            return (S) Collections.unmodifiableSortedSet(resultingSet);
        }
        return (S) resultingSet;
    }

    /**
     * Builds and returns a {@link SequencedSet} containing the values added to this builder.
     * <p>
     * If the builder is configured to return an <em>unmodifiable</em> instance, the resulting set is wrapped into an
     * unmodifiable view of the resulting SequencedSet.
     *
     * @return A SequencedSet containing values added to this builder.
     */
    @SuppressWarnings("unchecked")
    private S buildSequencedSet() {
        SequencedSet<V> resultingSet = new LinkedHashSet<>(internalSet);
        if (unmodifiable) {
            return (S) Collections.unmodifiableSequencedSet(resultingSet);
        }
        return (S) resultingSet;
    }

    /**
     * Builds and returns a {@link Set} containing the values added to this builder.
     * <p>
     * If the builder is configured to return an <em>unmodifiable</em> instance, the resulting set is wrapped into an
     * unmodifiable view of the resulting Set.
     *
     * @return A Set containing values added to this builder.
     */
    @SuppressWarnings("unchecked")
    private S buildSet() {
        Set<V> resultingSet = new HashSet<>(internalSet);
        if (unmodifiable) {
            return (S) Collections.unmodifiableSet(resultingSet);
        }
        return (S) resultingSet;
    }
}
