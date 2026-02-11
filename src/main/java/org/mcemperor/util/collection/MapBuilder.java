package org.mcemperor.util.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A builder class for creating {@link Map}.
 *
 * @param <K> The type of the keys in the map.
 * @param <V> The type of the values in the map.
 * @param <M> The type of map created by this builder.
 */
public class MapBuilder<K, V, M extends Map<K, V>> {

    /**
     * The internal map to store the entries.
     */
    private final Map<K, V> internalMap;

    /**
     * Whether this MapBuilder maintains insertion order.
     */
    private final boolean ordered;

    /**
     * The comparator to use, if this builder has a sorting.
     */
    private Comparator<? super K> comparator;

    /**
     * Whether this builder should produce an unmodifiable Map instance.
     */
    private boolean unmodifiable;

    /**
     * Constructs a new MapBuilder instance.
     *
     * @param ordered Whether the builder maintains insertion order.
     * @param internalMap The map to store entries added to the builder.
     */
    private MapBuilder(boolean ordered, Map<K, V> internalMap) {
        this.ordered = ordered;
        this.internalMap = internalMap;
    }

    /**
     * Creates a builder which maintains insertion order.
     *
     * @return A new MapBuilder.
     * @param <K> The type of keys contained in this map.
     * @param <V> The type of values contained in this map.
     * @param <M> The type of map, which extends {@link SequencedMap}.
     */
    private static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> newInsertionOrderBuilder() {
        return new MapBuilder<>(true, new LinkedHashMap<>());
    }

    /**
     * Creates an unordered builder.
     *
     * @return A new MapBuilder.
     * @param <K> The type of keys contained in this map.
     * @param <V> The type of values contained in this map.
     * @param <M> The type of map, which extends {@code SequencedMap}.
     */
    private static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> newUnorderedBuilder() {
        return new MapBuilder<>(false, new HashMap<>());
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given key and value.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The mapping's key.
     * @param v1 The mapping's value.
     * @return A new MapBuilder instance with the given key and value.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @param k7 The seventh mapping's key.
     * @param v7 The seventh mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6)
            .put(k7, v7);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @param k7 The seventh mapping's key.
     * @param v7 The seventh mapping's value.
     * @param k8 The eighth mapping's key.
     * @param v8 The eighth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6)
            .put(k7, v7)
            .put(k8, v8);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @param k7 The seventh mapping's key.
     * @param v7 The seventh mapping's value.
     * @param k8 The eighth mapping's key.
     * @param v8 The eighth mapping's value.
     * @param k9 The ninth mapping's key.
     * @param v9 The ninth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6)
            .put(k7, v7)
            .put(k8, v8)
            .put(k9, v9);
    }

    /**
     * Constructs a new unordered MapBuilder initially with the given keys and values.
     * <p>
     * The MapBuilder has no specified encounter order, and any map this builder produces does not provide any
     * guarantees regarding encounter order.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @param k7 The seventh mapping's key.
     * @param v7 The seventh mapping's value.
     * @param k8 The eighth mapping's key.
     * @param v8 The eighth mapping's value.
     * @param k9 The ninth mapping's key.
     * @param v9 The ninth mapping's value.
     * @param k10 The tenth mapping's key.
     * @param v10 The tenth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6)
            .put(k7, v7)
            .put(k8, v8)
            .put(k9, v9)
            .put(k10, v10);
    }

    /**
     * Constructs a new MapBuilder, with the sorting order and all entries of the specified map.
     * <p>
     * As this builder has a defined sorting, the map produced by this builder is a {@link SortedMap}.
     *
     * @param map The sorted map with the mappings to add.
     * @return A new MapBuilder instance with the sorting and mappings of the given map.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SortedMap<K, V>> MapBuilder<K, V, M> of(SortedMap<K, ? extends V> map) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .<M>sorted(map.comparator())
            .putAll(map);
    }

    @SafeVarargs
    public static <K, V, M extends Map<K, V>> MapBuilder<K, V, M> ofEntries(Map.Entry<K, V> first, Map.Entry<K, V>... more) {
        return MapBuilder.<K, V, M>newUnorderedBuilder()
            .putEntries(first, more);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given key and value.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K key, V value) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(key, value);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @param k7 The seventh mapping's key.
     * @param v7 The seventh mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6)
            .put(k7, v7);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @param k7 The seventh mapping's key.
     * @param v7 The seventh mapping's value.
     * @param k8 The eighth mapping's key.
     * @param v8 The eighth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6)
            .put(k7, v7)
            .put(k8, v8);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @param k7 The seventh mapping's key.
     * @param v7 The seventh mapping's value.
     * @param k8 The eighth mapping's key.
     * @param v8 The eighth mapping's value.
     * @param k9 The ninth mapping's key.
     * @param v9 The ninth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6)
            .put(k7, v7)
            .put(k8, v8)
            .put(k9, v9);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param k1 The first mapping's key.
     * @param v1 The first mapping's value.
     * @param k2 The second mapping's key.
     * @param v2 The second mapping's value.
     * @param k3 The third mapping's key.
     * @param v3 The third mapping's value.
     * @param k4 The fourth mapping's key.
     * @param v4 The fourth mapping's value.
     * @param k5 The fifth mapping's key.
     * @param v5 The fifth mapping's value.
     * @param k6 The sixth mapping's key.
     * @param v6 The sixth mapping's value.
     * @param k7 The seventh mapping's key.
     * @param v7 The seventh mapping's value.
     * @param k8 The eighth mapping's key.
     * @param v8 The eighth mapping's value.
     * @param k9 The ninth mapping's key.
     * @param v9 The ninth mapping's value.
     * @param k10 The tenth mapping's key.
     * @param v10 The tenth mapping's value.
     * @return A new MapBuilder instance with the given keys and values.
     * @param <K> The type of keys within the map.
     * @param <V> The type of values within the map.
     * @param <M> The type of map this builder produces.
     */
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .put(k1, v1)
            .put(k2, v2)
            .put(k3, v3)
            .put(k4, v4)
            .put(k5, v5)
            .put(k6, v6)
            .put(k7, v7)
            .put(k8, v8)
            .put(k9, v9)
            .put(k10, v10);
    }

    /**
     * Constructs a new ordered MapBuilder, initially with the given keys and values.
     * <p>
     * The MapBuilder maintains encounter order, which is the order in which key-value pairs are added. As this builder
     * is ordered, the map produced by this builder is a {@link SequencedMap}.
     *
     * @param first The first map entry.
     * @param more More map entries.
     * @return A new MapBuilder instance with the given keys and values.
     */
    @SafeVarargs
    public static <K, V, M extends SequencedMap<K, V>> MapBuilder<K, V, M> ofOrdered(Map.Entry<K, V> first, Map.Entry<K, V>... more) {
        return MapBuilder.<K, V, M>newInsertionOrderBuilder()
            .putEntries(first, more);
    }

    /**
     * Puts the specified entries into the map builder.
     *
     * @param first The first entry.
     * @param more More entries.
     * @return This instance, to allow for method chaining.
     */
    @SafeVarargs
    private MapBuilder<K, V, M> putEntries(Map.Entry<K, V> first, Map.Entry<K, V>... more) {
        put(first.getKey(), first.getValue());
        for (var entry : more) {
            put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    /**
     * Puts all entries of the specified map into this map.
     *
     * @param map The map of which all entries are put into this builder.
     * @return This instance, to allow for method chaining.
     */
    private MapBuilder<K, V, M> putAll(Map<K, ? extends V> map) {
        internalMap.putAll(map);
        return this;
    }

    /**
     * Puts an additional key-value pair into the builder.
     *
     * @param key The key to add.
     * @param value The value associated to the given key.
     * @return This instance, to allow for method chaining.
     */
    public MapBuilder<K, V, M> put(K key, V value) {
        internalMap.put(key, value);
        return this;
    }

    /**
     * Specifies that the map to be built is sorted using the provided comparator.
     *
     * @param comparator The comparator to use for sorting.
     * @return This instance, to allow for method chaining.
     */
    @SuppressWarnings("unchecked")
    public <N extends SortedMap<K, V>> MapBuilder<K, V, N> sorted(Comparator<? super K> comparator) {
        this.comparator = comparator;
        return (MapBuilder<K, V, N>) this;
    }

    /**
     * Specifies that the map to be built is unmodifiable.
     *
     * @return This instance, to allow for method chaining.
     */
    public MapBuilder<K, V, M> unmodifiable() {
        unmodifiable = true;
        return this;
    }

    /**
     * Builds and returns a map containing the entries added to this builder.
     * <p>
     * The specific implementation of the returned map depends on the builder configuration:
     * <ul>
     *     <li>If the builder is sorted, then this method returns a {@link SortedMap} instance.</li>
     *     <li>If the builder was constructed with ordering, then this method returns a {@link SequencedMap}.</li>
     *     <li>Otherwise, this method returns a {@link Map}, no further specified.</li>
     * </ul>
     * <p>
     * If the builder is configured to produce an unmodifiable map, the resulting map is wrapped in an <em>unmodifiable
     * view</em> of the map.
     *
     * @return The constructed map of type {@code M}.
     */
    @SuppressWarnings("unchecked")
    public M build() {
        if (comparator != null) {
            Map<K, V> resultingMap = new TreeMap<>(comparator);
            resultingMap.putAll(internalMap);
            return (M) determineUnmodifiable(resultingMap);
        }
        else if (ordered) {
            return (M) determineUnmodifiable(new LinkedHashMap<>(internalMap));
        }
        else {
            return (M) determineUnmodifiable(new HashMap<>(internalMap));
        }
    }

    /**
     * Determines if an unmodifiable map is configured to be produced, and if so, wraps the provided map into an
     * unmodifiable view of the map.
     *
     * @param map The created map to possibly wrap.
     * @return An unmodifiable view of the given map if this builder is configured to produce an unmodifiable map,
     * otherwise the given map without processing it.
     */
    private Map<K, V> determineUnmodifiable(Map<K, V> map) {
        return unmodifiable ? Collections.unmodifiableMap(map) : map;
    }
}
