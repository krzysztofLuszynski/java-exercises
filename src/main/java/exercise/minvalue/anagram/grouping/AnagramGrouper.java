package exercise.minvalue.anagram.grouping;

import java.util.Collection;
import java.util.Collections;

class AnagramGrouper {
    Collection<Collection<String>> findAnagrams(final Collection<String> strings) {
        if (strings == null || strings.size() == 0) {
            throw new IllegalArgumentException("Null or empty input strings");
        }

        return Collections.emptyList();
    }
}
