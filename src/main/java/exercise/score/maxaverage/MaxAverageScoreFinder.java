package exercise.score.maxaverage;

import java.util.*;

class MaxAverageScoreFinder {
    Optional<String> getStudentWithMaxAverageScore(final Collection<StudentScore> studentScores) {
        if (studentScores == null || studentScores.isEmpty()) {
            return Optional.empty();
        }

        final Map<String, Collection<Double>> studentToScores = getStudentToScores(studentScores);
        final Collection<StudentScore> averageScores = getAverageScores(studentToScores);

        final StudentScore maxAverageScore = Collections.max(averageScores, new StudentScoreComparator());
        return Optional.of(maxAverageScore.getName());
    }

    private Collection<StudentScore> getAverageScores(final Map<String, Collection<Double>> studentToScores) {
        final Collection<StudentScore> averageScores = new ArrayList<>();
        for (Map.Entry<String, Collection<Double>> studentToScoreEntry : studentToScores.entrySet()) {
            final String studentName = studentToScoreEntry.getKey();
            final OptionalDouble average =
                    studentToScoreEntry.getValue().stream().mapToDouble(Double::doubleValue).average();

            if (average.isPresent()) {
                averageScores.add(new StudentScore(studentName, average.getAsDouble()));
            }
        }

        return averageScores;
    }

    private  Map<String, Collection<Double>> getStudentToScores(final Collection<StudentScore> studentScores) {
        final Map<String, Collection<Double>> studentToScores = new LinkedHashMap<>();

        for (StudentScore studentScore : studentScores) {
            final String studentName = studentScore.getName();

            if (!studentToScores.containsKey(studentName)) {
                studentToScores.put(studentName, new ArrayList<>());
            }

            studentToScores.get(studentName).add(studentScore.getScore());
        }

        return studentToScores;
    }

    private static class StudentScoreComparator implements Comparator<StudentScore> {
        @Override
        public int compare(StudentScore o1, StudentScore o2) {
            return o1.getScore().compareTo(o2.getScore());
        }
    }
}
