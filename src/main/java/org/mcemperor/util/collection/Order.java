package org.mcemperor.util.collection;

import java.util.Comparator;

/**
 * Enumeration defining the possible ordering of the elements.
 */
enum Order {

    /**
     * No specific ordering is applied; the order is determined by the underlying collection.
     */
    NONE,

    /**
     * The collection is to be ordered based on the natural ordering of elements or keys. They must implement the
     * {@link Comparable} interface.
     */
    NATURAL,

    /**
     * Elements or keys are ordered based on a provided {@link Comparator}.
     */
    COMPARATOR,

    /**
     * Elements are ordered based on the order in which they were inserted into the builder.
     */
    INSERTION
}
