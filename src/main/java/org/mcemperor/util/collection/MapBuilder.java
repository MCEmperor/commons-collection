package org.mcemperor.util.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A builder class for creating immutable {@link Map} instances with different ordering options.
 *
 * @param <K> the type of the keys in the map
 * @param <V> the type of the values in the map
 */
public class MapBuilder<K, V> {

    /**
     * Enumeration defining the possible ordering of the map entries.
     */
    private enum Order {
        /**
         * No specific ordering is applied; the order is determined by the underlying {@link HashMap}.
         */
        NONE,

        /**
         * Entries are ordered based on the natural ordering of the keys. The keys must implement {@link Comparable}.
         */
        NATURAL,

        /**
         * Entries are ordered based on a provided {@link Comparator} for the keys.
         */
        COMPARATOR,

        /**
         * Entries are ordered based on the order in which they were inserted into the builder.
         */
        INSERTION
    }

    /**
     * The desired ordering for the map. Defaults to {@link Order#NONE}.
     */
    private Order order = Order.NONE;

    /**
     * The comparator to use for ordering when {@link #order} is {@link Order#COMPARATOR}.
     */
    private Comparator<K> comparator;

    /**
     * The map used to store the entries as they are added. Maintains insertion order.
     */
    private final Map<K, V> entries = new LinkedHashMap<>();

    /**
     * Constructs a new MapBuilder instance.
     */
    public MapBuilder() { }

    /**
     * Adds a key-value pair to the map being built. If the key already exists, the value is overwritten.
     *
     * @param key The key to add.
     * @param value The value associated with the key.
     * @return This {@code MapBuilder} instance for method chaining.
     */
    public MapBuilder<K, V> put(K key, V value) {
        entries.put(key, value);
        return this;
    }

    /**
     * Specifies that the built map should maintain the order in which entries were inserted.
     *
     * @return This {@code MapBuilder} instance for method chaining.
     */
    public MapBuilder<K, V> insertionOrder() {
        order = Order.INSERTION;
        return this;
    }

    /**
     * Specifies that the built map should be sorted based on the provided {@link Comparator}.
     *
     * @param comparator The comparator to use for sorting the keys.
     * @return This {@code MapBuilder} instance for method chaining.
     */
    public MapBuilder<K, V> sortedOrder(Comparator<K> comparator) {
        this.order = Order.COMPARATOR;
        this.comparator = comparator;
        return this;
    }

    /**
     * Specifies that the built map should be sorted based on the natural ordering of its keys.
     * <p>
     * The keys must implement the {@link Comparable} interface.
     *
     * @return This {@code MapBuilder} instance for method chaining.
     * @throws ClassCastException If the keys do not implement the {@code Comparable} interface.
     */
    public MapBuilder<K, V> naturalOrder() {
        order = Order.NATURAL;
        return this;
    }

    /**
     * Builds an immutable {@link Map} based on the configured order and added entries.
     *
     * @return An unmodifiable {@link Map} containing the added entries with the specified ordering.
     * @throws ClassCastException If natural ordering is requested and the keys do not implement {@link Comparable}.
     */
    public Map<K, V> build() {
        var map = switch (order) {
            case NONE -> new HashMap<>(entries);
            case NATURAL -> new TreeMap<>(entries);
            case COMPARATOR -> {
                Map<K, V> m = new TreeMap<>(comparator);
                m.putAll(entries);
                yield m;
            }
            case INSERTION -> new LinkedHashMap<>(entries);
        };

        return Collections.unmodifiableMap(map);
    }
}