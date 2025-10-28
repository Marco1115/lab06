package it.unibo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ADDED_ELEMS = 100_000;
    private static final int READ_TEST = 1_000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> arrayList = new ArrayList<>(1000);
        for (int i = 1000; i < 2000; i++) {
            arrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int size = arrayList.size();
        final int temporaryVar = arrayList.get(size-1);
        arrayList.set(size-1, arrayList.get(0));
        arrayList.set(0, temporaryVar);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int element: arrayList) {
            System.out.print(element + " ");
        }
        System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /* ArrayList benchmark */
        long arrayTime = System.nanoTime();
        for (int i = 1; i <= ADDED_ELEMS; i++) {
            arrayList.add(0, i);
        }
        arrayTime = System.nanoTime() - arrayTime;

        /* LinkedList benchmark */
        long linkedTime = System.nanoTime();
        for (int i = 1; i <= ADDED_ELEMS; i++) {
            linkedList.add(0, i);
        }
        linkedTime = System.nanoTime() - linkedTime;

        /* print benchmark results */
        final var arrayMillis = TimeUnit.NANOSECONDS.toMillis(arrayTime);
        System.out.println(
            "Inserting "
                + ADDED_ELEMS
                + " ints into the ArrayList head took "
                + arrayTime
                + "ns ("
                + arrayMillis
                + "ms)"
        );

        final var linkedMillis = TimeUnit.NANOSECONDS.toMillis(linkedTime);
        System.out.println(
            "Inserting "
                + ADDED_ELEMS
                + " ints into the LinkedList head took "
                + linkedTime
                + "ns ("
                + linkedMillis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /* ArrayList read benchmark */
        long arrayReadTime = System.nanoTime();
        for (int i = 1; i <= READ_TEST; i++) {
            arrayList.get(arrayList.size() / 2);
        }
        arrayReadTime = System.nanoTime() - arrayReadTime;

        /* LinkedList read benchmark */
        long linkedReadTime = System.nanoTime();
        for (int i = 1; i <= READ_TEST; i++) {
            linkedList.get(linkedList.size() / 2);
        }
        linkedReadTime = System.nanoTime() - linkedReadTime;

        /* print benchmark results */
        final var arrayReadMillis = TimeUnit.NANOSECONDS.toMillis(arrayReadTime);
        System.out.println(
            "Reading "
                + READ_TEST
                + " ints from the ArrayList middle took "
                + arrayReadTime
                + "ns ("
                + arrayReadMillis
                + "ms)"
        );

        final var linkedReadMillis = TimeUnit.NANOSECONDS.toMillis(linkedReadTime);
        System.out.println(
            "Reading "
                + READ_TEST
                + " ints from the LinkedList middle took "
                + linkedReadTime
                + "ns ("
                + linkedReadMillis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> populationMap = new HashMap<>(6);
        populationMap.put("Africa", 1_110_635_000L);
        populationMap.put("Americas", 972_005_000L);
        populationMap.put("Antartica", 0L);
        populationMap.put("Asia", 4_298_723_000L);
        populationMap.put("Europe", 742_452_000L);
        populationMap.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        final Collection<Long> populations = populationMap.values();
        long globalPopulation = 0;
        for (long p: populations) {
            globalPopulation += p;
        }
        System.out.println("The global population is: " + globalPopulation);
    }
}
