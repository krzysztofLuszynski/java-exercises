package exercise.minvalue.anagram.grouping;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramGrouperTest {
    private final AnagramGrouper anagramGrouper = new AnagramGrouper();

    @Test
    void nullCollection() {
        assertThrows(IllegalArgumentException.class,
                () -> anagramGrouper.findAnagrams(null),
                "Null or empty input strings");
    }

    @Test
    void emptyCollection() {
        assertThrows(IllegalArgumentException.class,
                () -> anagramGrouper.findAnagrams(Collections.emptyList()),
                "Null or empty input strings");
    }

    @Test
    void oneElementCollection() {
        final Collection<Collection<String>> anagrams = anagramGrouper.findAnagrams(Collections.singletonList("string"));
        assertEquals(anagrams, Collections.emptyList());
    }
}
