package exercise.anagram.grouping;

import exercise.anagram.grouping.AnagramGrouper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
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
        final Collection<Collection<String>> anagrams = anagramGrouper.findAnagrams(Collections.singletonList("first"));

        assertThat(anagrams).hasSize(1);
        assertThat(anagrams)
                .contains(Collections.singletonList("first"));
    }

    @Test
    void threeElementsCollectionNoRepetitionsNoAnagrams() {
        final Collection<Collection<String>> anagrams = anagramGrouper.findAnagrams(
                Arrays.asList("asda", "asd", "as"));

        assertThat(anagrams).hasSize(3);
        assertThat(anagrams)
                .contains(Collections.singletonList("asda"))
                .contains(Collections.singletonList("asd"))
                .contains(Collections.singletonList("as"));
    }

    @Test
    void fiveElementsCollectionRepetitionsNoAnagrams() {
        final Collection<Collection<String>> anagrams = anagramGrouper.findAnagrams(
                Arrays.asList("asda", "asd", "asda", "as", "as"));

        assertThat(anagrams).hasSize(3);
        assertThat(anagrams)
                .contains(Collections.singletonList("asda"))
                .contains(Collections.singletonList("asd"))
                .contains(Collections.singletonList("as"));
    }

    @Test
    void fiveElementsCollectionNoRepetitionsAnagrams() {
        final Collection<Collection<String>> anagrams = anagramGrouper.findAnagrams(
                Arrays.asList("asda", "asd", "sa", "as", "dsa"));

        assertThat(anagrams).hasSize(3);
        assertThat(anagrams)
                .contains(Collections.singletonList("asda"))
                .contains(Arrays.asList("asd", "dsa"))
                .contains(Arrays.asList("sa", "as"));
    }

    @Test
    void eightElementsCollectionRepetitionsAnagrams() {
        final Collection<Collection<String>> anagrams = anagramGrouper.findAnagrams(
                Arrays.asList("asda", "asd", "sa", "as", "dsa", "asd", "asda", "dsa"));

        assertThat(anagrams).hasSize(3);
        assertThat(anagrams)
                .contains(Collections.singletonList("asda"))
                .contains(Arrays.asList("asd", "dsa"))
                .contains(Arrays.asList("sa", "as"));
    }

    @Test
    void inputSet() {
        final Collection<Collection<String>> anagrams = anagramGrouper.findAnagrams(
                new LinkedHashSet<>(Arrays.asList("asda", "asd", "sa", "as", "dsa", "asd", "asda", "dsa")));

        assertThat(anagrams).hasSize(3);
        assertThat(anagrams)
                .contains(Collections.singletonList("asda"))
                .contains(Arrays.asList("asd", "dsa"))
                .contains(Arrays.asList("sa", "as"));
    }
}
