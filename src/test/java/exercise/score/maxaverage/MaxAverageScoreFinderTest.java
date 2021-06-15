package exercise.score.maxaverage;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MaxAverageScoreFinderTest {
    private final MaxAverageScoreFinder maxAverageScoreFinder = new MaxAverageScoreFinder();

    @Test
    void nullCollection() {
        final Optional<String> highestAverageStudent = maxAverageScoreFinder.getStudentWithMaxAverageScore(
                null);

        assertThat(highestAverageStudent).isNotPresent();
    }

    @Test
    void emptyCollection() {
        final Optional<String> highestAverageStudent = maxAverageScoreFinder.getStudentWithMaxAverageScore(
                new ArrayList<>());

        assertThat(highestAverageStudent).isNotPresent();
    }

    @Test
    void oneScore() {
        final Optional<String> highestAverageStudent = maxAverageScoreFinder.getStudentWithMaxAverageScore(
                Collections.singletonList(new StudentScore("erik", 20d)));

        assertThat(highestAverageStudent)
            .isPresent()
            .hasValue("erik");
    }

    @Test
    void threeScoresOneStudent() {
        final Optional<String> highestAverageStudent = maxAverageScoreFinder.getStudentWithMaxAverageScore(
                Arrays.asList(
                        new StudentScore("erik", 20d),
                        new StudentScore("erik", 10d),
                        new StudentScore("erik", 50d)));

        assertThat(highestAverageStudent)
                .isPresent()
                .hasValue("erik");
    }

    @Test
    void threeScoresThreeStudents() {
        final Optional<String> highestAverageStudent = maxAverageScoreFinder.getStudentWithMaxAverageScore(
                Arrays.asList(
                        new StudentScore("erik", 20d),
                        new StudentScore("john", 10d),
                        new StudentScore("mark", 50d)));

        assertThat(highestAverageStudent)
                .isPresent()
                .hasValue("mark");
    }

    @Test
    void sixScoresThreeStudents() {
        final Optional<String> highestAverageStudent = maxAverageScoreFinder.getStudentWithMaxAverageScore(
                Arrays.asList(
                        new StudentScore("erik", 20d),
                        new StudentScore("john", 10d),
                        new StudentScore("mark", 50d),
                        new StudentScore("mark", 50d),
                        new StudentScore("mark", 0d),
                        new StudentScore("mark", 0d)));

        assertThat(highestAverageStudent)
                .isPresent()
                .hasValue("mark");
    }

    @Test
    void sixScoresThreeStudents1() {
        final Optional<String> highestAverageStudent = maxAverageScoreFinder.getStudentWithMaxAverageScore(
                Arrays.asList(
                        new StudentScore("erik", 24d),
                        new StudentScore("john", 10d),
                        new StudentScore("mark", 50d),
                        new StudentScore("mark", 50d),
                        new StudentScore("mark", 0d),
                        new StudentScore("mark", 0d)));

        assertThat(highestAverageStudent)
                .isPresent()
                .hasValue("mark");
    }

    @Test
    void sixScoresThreeStudents2() {
        final Optional<String> highestAverageStudent = maxAverageScoreFinder.getStudentWithMaxAverageScore(
                Arrays.asList(
                        new StudentScore("erik", 25d),
                        new StudentScore("john", 10d),
                        new StudentScore("mark", 50d),
                        new StudentScore("mark", 50d),
                        new StudentScore("mark", 0d),
                        new StudentScore("mark", 0d)));

        assertThat(highestAverageStudent)
                .isPresent()
                .hasValue("erik");
    }
}
