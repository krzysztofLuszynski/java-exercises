package exercise.score.maxaverage;

class StudentScore {
    private final String name;
    private final Double score;

    public StudentScore(final String name, final Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }
}
