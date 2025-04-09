package org.mcemperor.util.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapBuilder<K, V> {

    private enum Order {
        NONE, NATURAL, COMPARATOR, INSERTION
    }

    private Order order = Order.NONE;
    private Comparator<K> comparator;

    private final Map<K, V> entries = new LinkedHashMap<>();

    public MapBuilder<K, V> put(K key, V value) {
        entries.put(key, value);
        return this;
    }

    public MapBuilder<K, V> insertionOrder() {
        order = Order.INSERTION;
        return this;
    }

    public MapBuilder<K, V> sortedOrder(Comparator<K> comparator) {
        this.order = Order.COMPARATOR;
        this.comparator = comparator;
        return this;
    }

    public MapBuilder<K, V> naturalOrder() {
        order = Order.NATURAL;
        return this;
    }

    public Map<K, V> build() {
        return Collections.unmodifiableMap(switch (order) {
            case NONE -> new HashMap<>(entries);
            case NATURAL -> new TreeMap<>(entries);
            case COMPARATOR -> {
                Map<K, V> m = new TreeMap<>(comparator);
                m.putAll(entries);
                yield m;
            }
            case INSERTION -> new LinkedHashMap<>(entries);
        });
    }
}
