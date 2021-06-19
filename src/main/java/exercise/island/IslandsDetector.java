package exercise.island;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

class IslandsDetector {
    List<Collection<Position>> getAllIslands(final char[][] map) {
        assertConditions(map);

        final Map<Position, FieldType> positionToFieldType = getPositionToFieldType(map);

        final List<Position> processedPositions = new ArrayList<>(
                getAllWaterPositions(positionToFieldType));

        final List<Collection<Position>> allIslands = new ArrayList<>();

        Set<Position> currentIsland = new LinkedHashSet<>();

        while (processedPositions.size() != (map.length * map[0].length)) {
            Position current = null;
            if (currentIsland.isEmpty() || processedPositions.containsAll(currentIsland)) {
                final Optional<Position> firstNotProcessed = findFirstNotProcessedField(positionToFieldType, processedPositions);
                if (!firstNotProcessed.isPresent()) {
                    break;
                }

                current = firstNotProcessed.get();
                if (!currentIsland.isEmpty() && processedPositions.containsAll(currentIsland)) {
                    allIslands.add(currentIsland);
                    currentIsland = new LinkedHashSet<>();
                }

                currentIsland.add(current);
            } else {
                boolean foundNotProcessedIslandField = false;
                for (Position position : currentIsland) {
                    if (!processedPositions.contains(position)) {
                        current = position;
                        foundNotProcessedIslandField = true;
                        break;
                    }
                }

                if (!foundNotProcessedIslandField) {
                    allIslands.add(currentIsland);
                    currentIsland = new LinkedHashSet<>();
                    continue;
                }
            }

            processedPositions.add(current);

            final Position upPosition = new Position(current.getRow() - 1, current.getColumn());
            checkAndAddToCurrentIsland(upPosition, positionToFieldType, currentIsland);
            final Position downPosition = new Position(current.getRow() + 1, current.getColumn());
            checkAndAddToCurrentIsland(downPosition, positionToFieldType, currentIsland);
            final Position leftPosition = new Position(current.getRow(), current.getColumn() - 1);
            checkAndAddToCurrentIsland(leftPosition, positionToFieldType, currentIsland);
            final Position rightPosition = new Position(current.getRow(), current.getColumn() + 1);
            checkAndAddToCurrentIsland(rightPosition, positionToFieldType, currentIsland);
        }

        if (!currentIsland.isEmpty()) {
            allIslands.add(currentIsland);
        }

        return allIslands;
    }

    private void assertConditions(final char[][] map) {
        if (ArrayUtils.isEmpty(map)) {
            throw new IllegalArgumentException("Map can not be empty or null !");
        }

        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            if (ArrayUtils.isEmpty(map[rowIndex])) {
                throw new IllegalArgumentException("Map row can not be empty or null !");
            }

            for (int columnIndex = 0; columnIndex < map[rowIndex].length; columnIndex++) {
                final char character = map[rowIndex][columnIndex];
                if (!isLand(character) && !isWater(character)) {
                    throw new IllegalArgumentException("Map element[" + rowIndex + "]["
                            + columnIndex + "] with value: " + character + " is not land or water !");
                }
            }
        }
    }

    private boolean isLand(final char character) {
        return character == 'l';
    }

    private boolean isWater(final char character) {
        return character == 'w';
    }

    private Map<Position, FieldType> getPositionToFieldType(final char[][] map) {
        final Map<Position, FieldType> positionToCharacter = new LinkedHashMap<>();

        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < map[rowIndex].length; columnIndex++) {
                final Position position = new Position(rowIndex, columnIndex);


                final char field = map[rowIndex][columnIndex];
                final FieldType fieldType;
                if (isWater(field)) {
                    fieldType = FieldType.WATER;
                } else {
                    fieldType = FieldType.LAND;
                }

                positionToCharacter.put(position, fieldType);
            }
        }

        return positionToCharacter;
    }

    private List<Position> getAllWaterPositions(final Map<Position, FieldType> positionToFieldType) {
        final List<Position> positions = new ArrayList<>();

        for (Map.Entry<Position, FieldType> mapEntry : positionToFieldType.entrySet()) {
            if (mapEntry.getValue() == FieldType.WATER) {
                positions.add(mapEntry.getKey());
            }
        }

        return positions;
    }

    private Optional<Position> findFirstNotProcessedField(final Map<Position, FieldType> positionToFieldType,
                                                          final List<Position> processed) {

        for (Map.Entry<Position, FieldType> mapEntry : positionToFieldType.entrySet()) {
            if (!processed.contains(mapEntry.getKey())) {
                return Optional.of(mapEntry.getKey());
            }
        }

        return Optional.empty();
    }

    private void checkAndAddToCurrentIsland(final Position position,
                                            final Map<Position, FieldType> positionToFieldType,
                                            final Set<Position> currentIsland) {
        final Set<Position> allPositions = positionToFieldType.keySet();

        if (allPositions.contains(position) && positionToFieldType.get(position) == FieldType.LAND) {
            currentIsland.add(position);
        }
    }

    private enum FieldType {
        WATER,
        LAND
    }

    static class Position {
        private final int row;
        private final int column;

        public Position(final int row, final int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            return new EqualsBuilder().append(row, position.row).append(column, position.column).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(row).append(column).toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("row", row)
                    .append("column", column)
                    .toString();
        }
    }
}
