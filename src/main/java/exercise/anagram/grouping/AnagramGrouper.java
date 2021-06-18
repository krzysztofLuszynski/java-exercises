package exercise.anagram.grouping;

import java.util.*;

class AnagramGrouper {
    Collection<Collection<String>> findAnagrams(final Collection<String> strings) {
        if (strings == null || strings.size() == 0) {
            throw new IllegalArgumentException("Null or empty input strings !");
        }

        final Collection<String> uniqueStrings = getUniqueStrings(strings);
        final Collection<String> anagrams = createAnagrams(strings);

        final Collection<Collection<String>> result = new ArrayList<>();
        final Map<String, Boolean> addedToResult = getAddedToResultMap(uniqueStrings);
        for (String string : uniqueStrings) {
            final Collection<String> resultEntry = new ArrayList<>();
            if (anagrams.contains(string)) {
                if (!addedToResult.get(string)) {
                    resultEntry.add(string);

                    final String anagram = new StringBuilder(string).reverse().toString();
                    resultEntry.add(anagram);
                    addedToResult.put(string, true);
                    addedToResult.put(anagram, true);
                }
            } else {
                resultEntry.add(string);
            }

            if (!resultEntry.isEmpty()) {
                result.add(resultEntry);
            }
        }

        return result;
    }

    private Collection<String> getUniqueStrings(final Collection<String> strings) {
        if (strings instanceof Set) {
            return strings;
        } else {
            return new LinkedHashSet<>(strings);
        }
    }

    private Collection<String> createAnagrams(final Collection<String> strings) {
        final Collection<String> anagrams = new LinkedHashSet<>();

        for (String string : strings) {
            final String anagram = new StringBuilder(string).reverse().toString();
            anagrams.add(anagram);
        }

        return anagrams;
    }

    private Map<String, Boolean> getAddedToResultMap(Collection<String> uniqueStrings) {
        final Map<String, Boolean> addedToResult = new HashMap<>();
        for (String string : uniqueStrings) {
            addedToResult.put(string, false);
        }
        return addedToResult;
    }
}
