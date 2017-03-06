package oop.homework.patterns.battleships;

import java.util.Objects;

public class Field {
    private static final int ROWS_COUNT = 10;
    private static final int COLUMNS_COUNT = 10;

    private Cell[][] cells = new Cell[ROWS_COUNT][COLUMNS_COUNT];

    public static Field createField() {
        Field field = new Field();
        for (int i = 0; i < field.cells.length; i++) {
            for (int j = 0; j < field.cells[0].length; j++) {
                field.cells[i][j] = new Cell(i, j);
            }
        }

        return field;
    }

    public Cell[][] getCells() {
        return cells;
    }

    static class Cell {
        private int vertical;
        private int horizontal;
        private boolean isEngaged;
        private boolean isShooted;

        private Cell(int vertical, int horizontal) {
            this.vertical = vertical;
            this.horizontal = horizontal;
        }

        public int getVertical() {
            return vertical;
        }

        public int getHorizontal() {
            return horizontal;
        }

        public boolean isShooted() {
            return isShooted;
        }

        public boolean isEngaged() {
            return isEngaged;
        }

        public void shoot() {
            isShooted = true;
        }

        public void engage() {
            isEngaged = true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Cell)) return false;
            Cell cell = (Cell) o;
            return getVertical() == cell.getVertical() &&
                    getHorizontal() == cell.getHorizontal() &&
                    isEngaged() == cell.isEngaged() &&
                    isShooted() == cell.isShooted();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getVertical(), getHorizontal(), isEngaged(), isShooted());
        }
    }
}
