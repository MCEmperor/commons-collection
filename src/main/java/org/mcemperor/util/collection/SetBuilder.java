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
    private boolean unmodifiable;

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
     * Constructs a new SetBuilder, with the sorting order and all values of the specified set.
     * <p>
     * As this builder has a defined sorting, the set produced by this builder is a {@link SortedSet}.
     *
     * @param set The sorted set with the values to add.
     * @return A new SetBuilder instance with the sorting and values of the given set.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SortedSet<V>> SetBuilder<V, S> of(SortedSet<V> set) {
        return SetBuilder.<V, S>newUnorderedBuilder()
            .<S>sorted(set.comparator())
            .addAll(set);
    }

    /**
     * Constructs a new ordered SetBuilder, initially with the given value.
     * <p>
     * The SetBuilder maintains encounter order, which is the order in which values are added. As this builder is
     * ordered, the set produced by this builder is a {@link SequencedSet}.
     *
     * @return A new SetBuilder instance with the given values.
     * @param <V> The type of values within the set.
     * @param <S> The type of set this builder produces.
     */
    public static <V, S extends SequencedSet<V>> SetBuilder<V, S> ofOrdered(V value) {
        return SetBuilder.<V, S>newInsertionOrderBuilder()
            .add(value);
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
     * Adds an additional values to the builder.
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
     * Specifies that the set to be built is unmodifiable.
     *
     * @return This instance, to allow for method chaining.
     */
    public SetBuilder<V, S> unmodifiable() {
        unmodifiable = true;
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
    @SuppressWarnings("unchecked")
    public S build() {
        if (comparator != null) {
            Set<V> resultingSet = new TreeSet<>(comparator);
            resultingSet.addAll(internalSet);
            return (S) determineUnmodifiable(resultingSet);
        }
        else if (ordered) {
            return (S) determineUnmodifiable(new LinkedHashSet<>(internalSet));
        }
        else {
            return (S) determineUnmodifiable(new HashSet<>(internalSet));
        }
    }

    /**
     * Determines if an unmodifiable set is configured to be produced, and if so, wraps the provided set into an
     * unmodifiable view of the set.
     *
     * @param set The created set to possibly wrap.
     * @return An unmodifiable view of the given set if this builder is configured to produce an unmodifiable set,
     * otherwise the given set without processing it.
     */
    private Set<V> determineUnmodifiable(Set<V> set) {
        return unmodifiable ? Collections.unmodifiableSet(set) : set;
    }
}
